import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;
import java.util.Scanner;
import org.junit.Assert;
import org.junit.Test;

public class testRunner {
    private static final String MINUS = " - ";
    private static final String RESULT_HEAD = "result(";
    private static final String RESULT_TAIL = ") = ";
    private static final String SEMICOLON = ";";
    private static final String PLUS = " + ";

    private static int getResult(String csvName, StringBuilder strResult)
            throws FileNotFoundException {
        int errorLines = 0;
        try {
            Scanner sc = new Scanner(new FileReader(csvName));
            sc.useLocale(Locale.ENGLISH);
            StringBuilder StrResult = new StringBuilder();
            double result = 0.0;
            while (sc.hasNextLine()) {
                try {
                    String line = sc.nextLine();
                    String[] elements = line.split(SEMICOLON);
                    int index = Integer.parseInt(elements[0]);
                    double number = Double.parseDouble(elements[index]);
                    result += number;
                    StrResult.append(number >= 0 ? PLUS : MINUS).append(Math.abs(number));
                } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                    errorLines++;
                }
            }
            if (StrResult.length() > 0) {
                final int SINGL = MINUS.length();
                final char CHAR_MIN = '-';
                String sym = StrResult.substring(0, SINGL);
                StrResult.delete(0, SINGL);
                if (sym.equals(MINUS)) {
                    StrResult.insert(0, CHAR_MIN);
                }
            }
            StrResult.insert(0, RESULT_HEAD).append(RESULT_TAIL).append(result);
        } finally {
        }
        return errorLines;
    }

    @Test
    public void testMainScenario() throws FileNotFoundException {
        String csv1 = "src/in1.csv";
        String res = String.format("5.2%s3.14%s0.0", MINUS, PLUS);
        String sum = "2.06";
        StringBuilder res2 = new StringBuilder();
        int errorLines = getResult(csv1, res2);
        Assert.assertEquals(3, errorLines);
        String expectedIn1 = String.format("%s%s%s%s", RESULT_HEAD, res, RESULT_TAIL, sum);
        Assert.assertEquals(expectedIn1, res2.toString());
    }

    @Test
    public void testMainScenario2() throws FileNotFoundException {
        String csv2 = "src/in2.csv";
        String res = String.format("-3.1%s1.0", MINUS);
        String sum = "-4.1";
        StringBuilder res2 = new StringBuilder();
        int errorLines = getResult(csv2, res2);
        Assert.assertEquals(0, errorLines);
        String expectedIn1 = String.format("%s%s%s%s", RESULT_HEAD, res, RESULT_TAIL, sum);
        Assert.assertEquals(expectedIn1, res2.toString());
    }

    @Test
    public void testMainScenario3() throws FileNotFoundException {
        String csv2 = "src/in3.csv";
        String res = "0.75";
        String sum = "0.75";
        StringBuilder res2 = new StringBuilder();
        int errorLines = getResult(csv2, res2);
        Assert.assertEquals(0, errorLines);
        String expectedIn1 = String.format("%s%s%s%s", RESULT_HEAD, res, RESULT_TAIL, sum);
        Assert.assertEquals(expectedIn1, res2.toString());
    }

    @Test
    public void testMainScenario4() throws FileNotFoundException {
        String csv2 = "src/in4.csv";
        String res = "0.0";
        String sum = "0.0";
        StringBuilder res2 = new StringBuilder();
        int errorLines = getResult(csv2, res2);
        Assert.assertEquals(0, errorLines);
        String expectedIn1 = String.format("%s%s%s%s", RESULT_HEAD, res, RESULT_TAIL, sum);
        Assert.assertEquals(expectedIn1, res2.toString());
    }

    @Test
    public void testMainScenario5() throws FileNotFoundException {
        String csv2 = "src/in5.csv";
        String res = "";
        String sum = "0.0";
        StringBuilder res2 = new StringBuilder();
        int errorLines = getResult(csv2, res2);
        Assert.assertEquals(1, errorLines);
        String expectedIn1 = String.format("%s%s%s%s", RESULT_HEAD, res, RESULT_TAIL, sum);
        Assert.assertEquals(expectedIn1, res2.toString());
    }


    @Test(expected = FileNotFoundException.class)
    public void testFileNotFoundEx() throws FileNotFoundException {
        getResult("wrongName", new StringBuilder());
    }
}