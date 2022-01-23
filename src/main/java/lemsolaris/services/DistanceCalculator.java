package lemsolaris.services;

import lemsolaris.model.other.Coordinates;

import java.time.LocalDateTime;

public class DistanceCalculator {
    private static final int BASE_X = 0;
    private static final int BASE_Y = 0;
    private static final int SPEED_COORDS_PER_MINUTE = 100;

    public static int calculateDistance(long x, long y) {
        long diffX = BASE_X - x;
        long diffY = BASE_Y - y;
        return (int) Math.sqrt(diffX * diffX + diffY * diffY);
    }

    public static LocalDateTime calculateEndTime(LocalDateTime start, Coordinates coordinates) {
        long diffX = BASE_X - coordinates.getX();
        long diffY = BASE_Y - coordinates.getY();
        long distance = (long) Math.sqrt(diffX * diffX + diffY * diffY);
        return start.plusMinutes(SPEED_COORDS_PER_MINUTE * distance);
    }
}
