package lemsolaris.util;

public class HashColor {
    private static String hex(int i) {
        return String.format("%02X", i);
    }

    /**
     * @return RGB hex color, such as "#13E0A6"
     */
    public static String hashToColor(Object o) {
        int hash = o.hashCode();
        int r = (hash & 0xFF0000) >> 16;
        int g = (hash & 0x00FF00) >> 8;
        int b = hash & 0x0000FF;
        return "#" + hex(r) + hex(g) + hex(b);
    }
}

