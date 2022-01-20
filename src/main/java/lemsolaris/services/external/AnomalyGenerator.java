package lemsolaris.services.external;

import lemsolaris.services.external.interfaces.IAnomalyGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnomalyGenerator implements IAnomalyGenerator {
    @Value("{lemsolaris.base_coordinates.x}")
    private int baseX = 0;
    @Value("{lemsolaris.base_coordinates.y}")
    private int baseY = 0;
    @Value("{lemsolaris.base_coordinates.y}")
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
