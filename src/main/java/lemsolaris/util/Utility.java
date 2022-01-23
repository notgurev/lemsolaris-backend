package lemsolaris.util;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

public class Utility {
    public static String randomStringFromArray(String[] list) {
        return list[new Random().nextInt(list.length)];
    }

    public static int randomIntInRange(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static Timestamp tomorrow() {
        return Timestamp.valueOf(LocalDateTime.now().plusDays(1));
    }
}
