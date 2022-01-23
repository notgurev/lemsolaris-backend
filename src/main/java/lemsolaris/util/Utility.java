package lemsolaris.util;

import java.util.Random;

public class Utility {
    public static String randomStringFromArray(String[] list) {
        return list[new Random().nextInt(list.length)];
    }

    public static int randomIntInRange(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
