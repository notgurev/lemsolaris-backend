package lemsolaris.util;

import java.util.Random;

public class Utility {
    public static String randomStringFromArray(String[] list) { // todo should not exist when enums done
        return list[new Random().nextInt(list.length)];
    }
}
