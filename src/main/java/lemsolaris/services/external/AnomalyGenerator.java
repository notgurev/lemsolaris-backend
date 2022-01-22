package lemsolaris.services.external;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@ComponentScan("application.yaml")
public class AnomalyGenerator {
    @Value("${lemsolaris.base_coordinates.x}")
    private int baseX = 0;
    @Value("${lemsolaris.base_coordinates.y}")
    private int baseY = 0;
    @Value("${lemsolaris.max_anomaly_distance}")
    private int maxDistance = 1000;

    public void generateRandomAnomaly() {
        int x = randomIntInRange(baseX - maxDistance, baseX + maxDistance);
        int y = randomIntInRange(baseY - maxDistance, baseY + maxDistance);
        System.out.println(x);
        System.out.println(y);
        // todo add to db, return id
    }

    public void makeAnomalyDisappear() {
        // todo
    }

    private static int randomIntInRange(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
