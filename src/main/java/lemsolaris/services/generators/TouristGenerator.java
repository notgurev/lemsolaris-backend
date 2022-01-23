package lemsolaris.services.generators;

import com.github.javafaker.Faker;
import lemsolaris.model.flight.Tourist;
import lemsolaris.repositories.TouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

import static lemsolaris.util.RandomUtil.randomIntInRange;
import static lemsolaris.util.Utility.randomStringFromArray;

@Service
public class TouristGenerator {
    private final TouristRepository touristRepository;

    @Autowired
    public TouristGenerator(TouristRepository touristRepository) {
        this.touristRepository = touristRepository;
    }

    public List<Tourist> generateTourists(int number) {
        String[] sexes = {"Man", "Woman"};
        Faker faker = new Faker();
        List<Tourist> tourists = new LinkedList<>();
        for (int i = 0; i < number; i++) {
            Tourist tourist = new Tourist(
                    faker.name().fullName(),
                    randomIntInRange(16, 60),
                    randomStringFromArray(sexes)
            );
            touristRepository.save(tourist);
            tourists.add(tourist);
        }
        return tourists;
    }
}
