import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import org.junit.Assert;
import org.junit.Test;
public class testRunner1 {
  private static final String MINUS = " - ";
  private static final String RESULT_HEAD = "result(";
  private static final String RESULT_TAIL = ") = ";
  private static int getResult(String csvName, StringBuilder strResult)
        throws FileNotFoundException {
        final String SEMICOLON = ";";
        final String ERROR_LINES = "error-lines = ";
        final String PLUS = " + ";
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
    String csv1 = "src/in1.csv";
    String res = String.format("5.2%s3.14",MINUS);
    String sum = "2.06";
      StringBuilder res2 = new StringBuilder();
      int errorLines = getResult(csv1, res2);
      Assert.assertEquals(3, errorLines);
      String expectedIn1 = String.format("%s%s%s%s",RESULT_HEAD, res, RESULT_TAIL, sum);
      Assert.assertEquals(expectedIn1, res2.toString());
  }
  @Test
  public void testMainScenario2() throws FileNotFoundException {
    String csv2 = "src/in2.csv";
    String res = String.format("-3.1%s1.0",MINUS);
    String sum = "-4.1";
      StringBuilder res2 = new StringBuilder();
      int errorLines = getResult(csv2, res2);
      Assert.assertEquals(0, errorLines);
      String expectedIn1 = String.format("%s%s%s%s",RESULT_HEAD, res, RESULT_TAIL, sum);
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
      String expectedIn1 = String.format("%s%s%s%s",RESULT_HEAD, res, RESULT_TAIL, sum);
      Assert.assertEquals(expectedIn1, res2.toString());}
  @Test
  public void testMainScenario4() throws FileNotFoundException {
    String csv2 = "src/in4.csv";
    String res = "0.0";
    String sum = "0.0";
      StringBuilder res2 = new StringBuilder();
      int errorLines = getResult(csv2, res2);
      Assert.assertEquals(2, errorLines);
      String expectedIn1 = String.format("%s%s%s%s",RESULT_HEAD, res, RESULT_TAIL, sum);
      Assert.assertEquals(expectedIn1, res2.toString());}
  
  @Test(expected = FileNotFoundException.class)
  public void testFileNotFoundEx() throws FileNotFoundException {
      getResult("wrongName", new StringBuilder());
  }    
  @Test
public void testXxx() throws FileNotFoundException {
    String csv1 = "src/in1.csv";
    String csv2 = "src/in2.csv";
    Assert.assertEquals(csv1, csv2);
}
}