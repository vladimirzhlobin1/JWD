package by.gsu.epamlab;

public final class Format {
    public static String format(int a) {
        return String.format("%d.%02d", a / 100, a % 100);
    }
}
