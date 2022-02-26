import java.io.FileNotFoundException;
import java.util.Enumeration;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.Assert;
import org.junit.Test;
public class TestRunner {
    final static String KEY_FIRST = "index(.*)";
    final static String NUM_SEARCH = "[1-9]\\d*";
    final static String VALUE = "value";
    static Pattern pattern = Pattern.compile(KEY_FIRST);
    static Pattern pattern2 = Pattern.compile(NUM_SEARCH);
    private static int getResult(String g) throws FileNotFoundException {
        double sum = 0.0;
        int errors = 0;
        try {
            ResourceBundle rb = ResourceBundle.getBundle(g);
            Enumeration<String> keys = rb.getKeys();
            while (keys.hasMoreElements()) {
                String key = keys.nextElement();
                Matcher keyMatcher = pattern.matcher(key);//первый паттерн
                if (keyMatcher.matches()) {
                    String str1 = keyMatcher.group(1);
                    String str2 = rb.getString(key).trim();
                    Matcher matcher1 = pattern2.matcher(str1);
                    Matcher matcher2 = pattern2.matcher(str2);
                    if (matcher1.matches() && matcher2.matches()) {
                        String valueIJ = VALUE + str1 + str2;
                        try {
                            String number = rb.getString(valueIJ).trim();
                            sum += Double.parseDouble(number);
                        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                            errors++;
                        }
                    } else {
                        errors++;
                    }
                }
            }
        } catch (MissingResourceException e) {
            System.out.println("No file...");
        }
        return new Result(sum, errors);;
    }
    private static class Result {
        private double sum;
        private int errors;
        public Result(double sum, int errors) {
            this.sum = sum;
        }
        public Result(int errors) {
            this.errors = errors;
        }
        public Result() {}
        public double errorLines() {
            return errors;
        }
        public double getSum() {
            return sum;
        }
        public void setSum(double sum) {
            this.sum = sum;
        }
    }
    @Test
    public void testMain (){
        class TestCase {
            private final String fileName;
            private final Result test;
            public TestCase(String fileName, Result test) {super();this.fileName = fileName;this.test = test;}
            public String getFileName() {return fileName;}
            public Result getTest (){
                return  test;
            }}
        TestCase[] testCases = {new TestCase ("in",new Result(8.24,3)),
                new TestCase("in2",new Result(30.124,9)),
                new TestCase("in3",new Result(1.9, 0))};
        for (TestCase test1 : testCases) {
            Result resultTest = getResult(test1.fileName);
            Assert.assertEquals(resultTest.sum, test1.getTest().sum,0.00001);
            Assert.assertEquals(resultTest.errors, test1.getTest().errorLines());
        }}
}