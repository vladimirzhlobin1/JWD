import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.Enumeration;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class testRunner {
        final static String KEY_FIRST = "index(.*)";//index + один произвольный символ с повторениями
        final static String NUM_SEARCH = "[1-9]\\d*";//символ без нуля + любое число с повторениями
        final static String VALUE = "value";
    private static int getResult(String g, Itest it) throws FileNotFoundException {
    double result = 0.0;
    int errors = 0;
        try {
            ResourceBundle rb = ResourceBundle.getBundle(g);
            Enumeration<String> keys = rb.getKeys();//возвращает объект Enumeration, который применяется для посл.эл.
            while (keys.hasMoreElements()) {
                String key = keys.nextElement();//в key запихнули все ключи (4 штуки из in3)
                Pattern pattern = Pattern.compile(KEY_FIRST);//устанавливаем паттерн
                Matcher keyMatcher = pattern.matcher(key);//заносим в keyMatcher все совпадения с паттерном key
                if (keyMatcher.matches()) {
                    String str1 = keyMatcher.group(1);//группируем начиная с 1 индекса все совпадения 4 штуки в in3
                    String str2 = rb.getString(key).trim();//удаляем пробелы в начале и конце
                    pattern = Pattern.compile(NUM_SEARCH);//проверяем паттерн
                    Matcher matcher1 = pattern.matcher(str1);//проверяем на совпадение паттерну
                    pattern = Pattern.compile(NUM_SEARCH);//проверяем на паттерн
                    Matcher matcher2 = pattern.matcher(str2);//проверяем на совпадение паттерну
                    if (matcher1.matches() && matcher2.matches()) {//если звезды сошлись
                        String valueIJ = VALUE + str1 + str2;
                        try {
                            String number = rb.getString(valueIJ).trim();
                            result += Double.parseDouble(number);
                        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                            errors++;}
                    } else {errors++;}}}
            System.out.println("sum = " + result);
            System.out.println("error-lines = " + errors);
        } catch (MissingResourceException e) {
            System.out.println("No file...");
        }
        return errors;
    }
   class Itest{
      public  double sum;
      public  int error;
       public Itest(double sum) {this.sum=sum;}
       public Itest() {}
       public double getSum() {return sum;}
       public void setSum(double sum) {this.sum = sum;}
   }
   @Test
   public void testMainScenario() throws FileNotFoundException{
        ResourceBundle rb = ResourceBundle.getBundle("in");
    Assert.assertEquals(5,5);
    Assert.assertEquals(5,5);
   }
    @Test
    public void testMainScenario1() throws FileNotFoundException{
Itest it = new Itest();
int res = getResult("in3",it);
it.setSum(1.9);
Assert.assertEquals(res,it.getSum());
Assert.assertEquals(0,1.9000000000000001);


    }

}