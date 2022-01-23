package lemsolaris.services.generators;

import com.github.javafaker.Faker;
import lemsolaris.model.flight.Tourist;
import lemsolaris.repositories.TouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static lemsolaris.util.Utility.randomIntInRange;
import static lemsolaris.util.Utility.randomStringFromArray;

@Service
public class TouristGenerator {
    private final TouristRepository touristRepository;

    @Autowired
    public TouristGenerator(TouristRepository touristRepository) {
        this.touristRepository = touristRepository;
    }

    public void generateTourists(int number) {
        String[] sexes = {"Man", "Woman"};
        Faker faker = new Faker();
        for (int i = 0; i < number; i++) {
            Tourist tourist = new Tourist(
                    faker.name().fullName(),
                    randomIntInRange(16, 60),
                    randomStringFromArray(sexes)
            );
            touristRepository.save(tourist);
        }
    }
}
