package by.gsu.epamlab;

public class Format {
    public static String format(int a) {
        return String.format("%d.%02d", a / 100, a % 100);
    }

    public static String format2(double a) {
        return String.format("%.3f", a / 100, a % 100);
    }
}
