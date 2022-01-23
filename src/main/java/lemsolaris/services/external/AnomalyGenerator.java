package lemsolaris.services.external;

import lemsolaris.model.anomaly.Anomaly;
import lemsolaris.model.other.Coordinates;
import lemsolaris.repositories.AnomalyRepository;
import lemsolaris.repositories.CoordinatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@Service
@ComponentScan("application.yaml")
public class AnomalyGenerator {
    @Value("${lemsolaris.base_coordinates.x}")
    private int baseX = 0;
    @Value("${lemsolaris.base_coordinates.y}")
    private int baseY = 0;
    @Value("${lemsolaris.max_anomaly_distance}")
    private int maxDistance = 1000;

    final AnomalyRepository anomalyRepository;
    final CoordinatesRepository coordinatesRepository;

    @Autowired
    public AnomalyGenerator(AnomalyRepository anomalyRepository,
                            CoordinatesRepository coordinatesRepository) {
        this.anomalyRepository = anomalyRepository;
        this.coordinatesRepository = coordinatesRepository;
    }

    public Long generateRandomAnomaly() {
        int x = randomIntInRange(baseX - maxDistance, baseX + maxDistance);
        int y = randomIntInRange(baseY - maxDistance, baseY + maxDistance);
        Coordinates coordinates = new Coordinates(x, y);
        Anomaly anomaly = new Anomaly("Unexplored", null, null, 10, coordinates);
        coordinatesRepository.save(coordinates);
        anomalyRepository.save(anomaly);
        return anomaly.getId();
    }

    private static int randomIntInRange(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
