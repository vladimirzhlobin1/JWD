import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

public class testRunner1 {
    private static int getResult(String csvName, StringBuilder strResult)
            throws FileNotFoundException {
        final String MINUS = " - ";
        final String RESULT_HEAD = "result(";
        final String SEMICOLON = ";";
        final String ERROR_LINES = "error-lines = ";
        final String PLUS = " + ";
        final String RESULT_TAIL = ") = ";
        final String SEARCH_ERROR = "Input file is not found";
        int errorLines = 0;
        try {
            Scanner sc = new Scanner(new FileReader(csvName));
            StringBuilder finalString = new StringBuilder();
            double result = 0.0;
            while (sc.hasNext()) {
                String line = sc.next();
                String[] elements = line.split(SEMICOLON);
                int index;
                double number;
                try {
                    index = Integer.parseInt(elements[0]);
                    if (index < 0 || index >= elements.length) {
                        errorLines++;
                        continue;
                    }
                    number = Double.parseDouble(elements[index]);
                } catch (Exception e) {
                    errorLines++;
                    continue;
                }
                result += number;
                StringBuilder element = new StringBuilder();
                if (finalString.length() > 0) {
                    element.append(number < 0 ? MINUS : PLUS).append(Math.abs(number));
                } else {
                    element.append(number);
                }
                finalString.append(element);
            }
            strResult.append(RESULT_HEAD).append(finalString).append(RESULT_TAIL).append(result);
            System.out.println(ERROR_LINES + errorLines);
        } catch (FileNotFoundException e) {
            System.err.println(SEARCH_ERROR);
        }

        return errorLines;
    }

    @Test
    public void testMainScenario() throws FileNotFoundException {
        StringBuilder result = new StringBuilder();
        int errorLines = getResult("src/in1.csv", result);
        Assert.assertEquals(3, errorLines);
        String expectedIn1 = "result(5.2 - 3.14 + 0.0) = 2.06";
        Assert.assertEquals(expectedIn1, result.toString());
    }

    public void testMainScenario2() throws FileNotFoundException {
        StringBuilder result = new StringBuilder();
        int errorLines = getResult("src/in2.csv", result);
        Assert.assertEquals(2, errorLines);
        String expectedIn1 = "result(-3.1 - 1.0) = -4.1";
        Assert.assertEquals(expectedIn1, result.toString());
    }

    @Test(expected = FileNotFoundException.class)
    public void testFileNotFoundEx() throws FileNotFoundException {
        getResult("wrongName", new StringBuilder());
    }
}