package lemsolaris.util;

import java.time.LocalDateTime;

public class TimeUtil {
    public static LocalDateTime tomorrow() {
        return LocalDateTime.now().plusDays(1);
    }
    public static LocalDateTime now() {
        return LocalDateTime.now();
    }
}
