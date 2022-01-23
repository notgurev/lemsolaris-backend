package lemsolaris.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DistanceCalculator {
    @Value("${lemsolaris.base_coordinates.x}")
    private int baseX = 0;
    @Value("${lemsolaris.base_coordinates.y}")
    private int baseY = 0;

    private static final int SPEED_COORDS_PER_MINUTE = 100;

    public long calculate(long x, long y) {
        long diffX = baseX - x;
        long diffY = baseY - y;
        return (long) Math.sqrt(diffX * diffX + diffY * diffY);
    }

    public LocalDateTime calculateEndTime(LocalDateTime start, long distance) {
        return start.plusMinutes(SPEED_COORDS_PER_MINUTE * distance);
    }
}
