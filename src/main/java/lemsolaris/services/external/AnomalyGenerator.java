package lemsolaris.services.external;

import lemsolaris.model.anomaly.Anomaly;
import lemsolaris.model.other.Coordinates;
import lemsolaris.repositories.AnomalyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@EnableScheduling
@ComponentScan("application.yaml")
public class AnomalyGenerator {
    @Value("${lemsolaris.base_coordinates.x}")
    private int baseX = 0;
    @Value("${lemsolaris.base_coordinates.y}")
    private int baseY = 0;
    @Value("${lemsolaris.max_anomaly_distance}")
    private int maxDistance = 1000;
    AnomalyRepository anomalyRepository;

    @Autowired
    public AnomalyGenerator(AnomalyRepository anomalyRepository) {
        this.anomalyRepository = anomalyRepository;
    }

    @Scheduled(fixedDelay = 3000) // раз в 3 секунды новая аномалия
    public void generateRandomAnomaly() {
        int x = randomIntInRange(baseX - maxDistance, baseX + maxDistance);
        int y = randomIntInRange(baseY - maxDistance, baseY + maxDistance);
        int radius = randomIntInRange(0,10);
        Anomaly anomaly = new Anomaly();
        anomaly.setStatusOfAnomaly("Unexplored");
        Coordinates coordinates = new Coordinates();
        coordinates.setX(x);
        coordinates.setY(y);
        anomaly.setFlightRadius(radius);
        anomaly.setCoordinatesByCoordsId(coordinates);
        anomalyRepository.save(anomaly);
    }

    public void makeAnomalyDisappear() {
        // todo
    }

    private static int randomIntInRange(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
