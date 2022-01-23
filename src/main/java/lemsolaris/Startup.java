package lemsolaris;

import com.github.javafaker.Faker;
import lemsolaris.model.employee.EmployeeHuman;
import lemsolaris.model.employee.EmployeeStatus;
import lemsolaris.model.employee.Profession;
import lemsolaris.model.other.Ship;
import lemsolaris.model.other.ShipType;
import lemsolaris.model.other.StockResource;
import lemsolaris.repositories.EmployeeRepository;
import lemsolaris.repositories.ShipRepository;
import lemsolaris.repositories.StockResourceRepository;
import lemsolaris.services.FlightCreator;
import lemsolaris.services.generators.AnomalyGenerator;
import lemsolaris.services.generators.TouristGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

import static lemsolaris.util.RandomUtil.randomFromArray;
import static lemsolaris.util.RandomUtil.randomIntInRange;

@Component
public class Startup {
    private final AnomalyGenerator anomalyGenerator;
    private final StockResourceRepository resourceRepository;
    private final ShipRepository shipRepository;
    private final TouristGenerator touristGenerator;
    private final FlightCreator flightCreator;
    private final EmployeeRepository<EmployeeHuman> humanEmployeeRepository;

    private final Logger logger = LoggerFactory.getLogger(Startup.class);

    @Autowired
    public Startup(AnomalyGenerator anomalyGenerator,
                   StockResourceRepository resourceRepository,
                   ShipRepository shipRepository,
                   TouristGenerator touristGenerator,
                   FlightCreator flightCreator,
                   EmployeeRepository<EmployeeHuman> humanEmployeeRepository) {
        this.anomalyGenerator = anomalyGenerator;
        this.resourceRepository = resourceRepository;
        this.shipRepository = shipRepository;
        this.touristGenerator = touristGenerator;
        this.flightCreator = flightCreator;
        this.humanEmployeeRepository = humanEmployeeRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    @Transactional
    public void fillTables() {
        long start = System.nanoTime();
        // Employees
        Faker faker = new Faker();
        {
            Profession[] professions = {Profession.Doctor, Profession.Pilot,
                    Profession.Scientist, Profession.Scientist};
            for (int i = 0; i < 100; i++) {
                EmployeeHuman e = new EmployeeHuman(
                        faker.name().fullName(),
                        EmployeeStatus.Candidate,
                        randomIntInRange(1, 5) * 1000,
                        randomIntInRange(20, 60),
                        randomFromArray(professions),
                        randomIntInRange(50, 200),
                        randomIntInRange(2, 5)
                );
                humanEmployeeRepository.save(e);
            }
        }

        // Resources
        {
            resourceRepository.save(new StockResource("Money", 10000, 1));
            resourceRepository.save(new StockResource("Fuel", 5000, 10));
        }

        // Anomalies
        {
            for (int i = 0; i < 50; i++) {
                long id = anomalyGenerator.generateRandomAnomaly();
                if (i % 2 == 0) {
                    anomalyGenerator.exploreAnomaly(id);
                }
            }
        }

        // Ships
        {
            for (int i = 0; i < 100; i++) {
                Ship s = new Ship(
                        ShipType.Tourist,
                        randomIntInRange(1000, 2000),
                        randomIntInRange(2, 5),
                        randomIntInRange(2, 20)
                );
                shipRepository.save(s);
            }
            for (int i = 0; i < 100; i++) {
                Ship s = new Ship(
                        ShipType.Exploration,
                        randomIntInRange(1000, 2000),
                        randomIntInRange(2, 5),
                        randomIntInRange(2, 20)
                );
                shipRepository.save(s);
            }
        }

        // Tourists
        {
            touristGenerator.generateTourists(50);
        }

        // Flights
        {
            flightCreator.createExplorationToAnomaly(1);
            flightCreator.createTourFlightToAnomaly(2, 1000);
        }

        long elapsedTime = System.nanoTime() - start;
        logger.info("Startup initialisation finished in " + elapsedTime / Math.pow(10, 9) + " seconds");
    }
}

