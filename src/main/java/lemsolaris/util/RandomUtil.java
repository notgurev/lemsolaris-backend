package lemsolaris.util;

import java.util.Random;

public class RandomUtil {
    private final static Random random = new Random();

    public static int randomIntInRange(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static <T> T randomFromArray(T[] list) {
        return list[random.nextInt(list.length)];
    }
}
