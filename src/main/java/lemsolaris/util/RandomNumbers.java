package lemsolaris.util;

public class RandomNumbers {
    public static int randomIntInRange(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
