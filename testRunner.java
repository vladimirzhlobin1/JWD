import java.io.FileNotFoundException;
import java.util.Enumeration;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.junit.Test;

public class testRunner {
    final static String KEY_FIRST = "index(.*)";
    final static String NUM_SEARCH = "[1-9]\\d*";
    final static String VALUE = "value";

    private static int getResult(String g, Itest it) throws FileNotFoundException {
        double sum = 0.0;
        int errors = 0;
        try {
            ResourceBundle rb = ResourceBundle.getBundle(g);
            Enumeration<String> keys = rb.getKeys();
            while (keys.hasMoreElements()) {
                String key = keys.nextElement();
                Pattern pattern = Pattern.compile(KEY_FIRST);
                Matcher keyMatcher = pattern.matcher(key);
                if (keyMatcher.matches()) {
                    String str1 = keyMatcher.group(1);
                    String str2 = rb.getString(key).trim();
                    pattern = Pattern.compile(NUM_SEARCH);
                    Matcher matcher1 = pattern.matcher(str1);
                    pattern = Pattern.compile(NUM_SEARCH);
                    Matcher matcher2 = pattern.matcher(str2);
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
            System.out.println("sum = " + sum);
            System.out.println("error-lines = " + errors);
        } catch (MissingResourceException e) {
            System.out.println("No file...");
        }
        it.setSum(sum);
        return errors;
    }

    class Itest {
        public double sum;

        public Itest(double sum) {
            this.sum = sum;
        }

        public Itest() {
        }

        public double getSum() {
            return sum;
        }

        public void setSum(double sum) {
            this.sum = sum;
        }
    }


    @Test
    public void testMainScenario1() throws FileNotFoundException {
        Itest it = new Itest();
        int res = getResult("in3", it);
        Assert.assertEquals(1.9, it.getSum(), 0.0001);
        Assert.assertEquals(0, res);
    }

    @Test
    public void testMainScenario2() throws FileNotFoundException {
        Itest it = new Itest();
        int res = getResult("in2", it);
        Assert.assertEquals(30.242, it.getSum(), 0.0001);
        Assert.assertEquals(9, res);
    }

    @Test
    public void testMainScenario3() throws FileNotFoundException {
        Itest it = new Itest();
        int res = getResult("in2", it);
        Assert.assertEquals(8.24, it.getSum(), 0.0001);
        Assert.assertEquals(3, res);
    }

    @Test
    public void testMain() {
        class TestCase {
            String fileName;
            Itest test;

            public TestCase(String fileName, Itest test) {
                super();
                this.fileName = fileName;
                this.test = test;
            }

            public String getFileName() {
                return fileName;
            }
        }
        TestCase[] testCases = {new TestCase("in", new Itest(8.24)),
                new TestCase("in2", new Itest(30.124)), new TestCase("in3", new Itest(1.9))};
        {
            for (TestCase test1 : testCases) {
                Itest resultTest = getResult(TestCase.getFileName());
                Assert.assertEquals(testCases, 3);
            }
        }
    }

}