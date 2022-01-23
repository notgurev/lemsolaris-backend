package lemsolaris.services.generators;

import lemsolaris.model.anomaly.Anomaly;
import lemsolaris.model.anomaly.AnomalyStatus;
import lemsolaris.model.anomaly.AnomalyType;
import lemsolaris.model.anomaly.HazardLevel;
import lemsolaris.model.other.Coordinates;
import lemsolaris.repositories.AnomalyRepository;
import lemsolaris.repositories.CoordinatesRepository;
import lemsolaris.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import static lemsolaris.util.RandomUtil.randomFromArray;
import static lemsolaris.util.RandomUtil.randomIntInRange;

@Service
@ComponentScan("application.yaml")
public class AnomalyGenerator {
    @Value("${lemsolaris.base_coordinates.x}")
    private int baseX = 0;
    @Value("${lemsolaris.base_coordinates.y}")
    private int baseY = 0;
    @Value("${lemsolaris.max_anomaly_distance}")
    private int maxDistance = 1000;

    private static final HazardLevel[] hazardLevels = {HazardLevel.Safe, HazardLevel.Dangerous};
    private static final AnomalyType[] anomalyTypes = {AnomalyType.NonStructural, AnomalyType.Structural};

    private final AnomalyRepository anomalyRepository;
    private final CoordinatesRepository coordinatesRepository;

    @Autowired
    public AnomalyGenerator(AnomalyRepository anomalyRepository, CoordinatesRepository coordinatesRepository) {
        this.anomalyRepository = anomalyRepository;
        this.coordinatesRepository = coordinatesRepository;
    }

    public long generateRandomAnomaly() {
        int x = randomIntInRange(baseX - maxDistance, baseX + maxDistance);
        int y = randomIntInRange(baseY - maxDistance, baseY + maxDistance);
        Coordinates coordinates = new Coordinates(x, y);
        Anomaly anomaly = new Anomaly(AnomalyStatus.Unexplored, null, null, 10, coordinates);
        coordinatesRepository.save(coordinates);
        anomalyRepository.save(anomaly);
        return anomaly.getId();
    }

    public void exploreAnomaly(long id) {
        anomalyRepository.findById(id).ifPresent(anomaly -> {
            anomaly.setStatus(AnomalyStatus.Explored);
            anomaly.setHazardLevel(randomFromArray(hazardLevels));
            anomaly.setType(RandomUtil.randomFromArray(anomalyTypes));
            if (anomaly.getHazardLevel() == HazardLevel.Dangerous) {
                anomaly.setFlightRadius(randomIntInRange(50, 100));
            }
        });
    }
}
