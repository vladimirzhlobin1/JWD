package by.gsu.epamlab;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import by.gsu.epamlab.Format;
public class Runner {
	public static void main(String[] args) {
		final int NUMBEROFPURCHASE;
		 Purchase[] purchases=null;
       Scanner sc=null;
       
       try{   
    	   sc=new Scanner(new FileReader("purchases.txt"));
    	   sc.useLocale(Locale.ENGLISH);    
    	   NUMBEROFPURCHASE = sc.nextInt();
    	   purchases = new Purchase[NUMBEROFPURCHASE];
    	   for(int i=0; i<NUMBEROFPURCHASE; i++)
    	   {
    		  int days =sc.nextInt();
    		  int number = sc.nextInt();
    		  WeekDay WDay = WeekDay.values()[days];
    		  purchases[i] = new Purchase(WDay,number);   		        
    	   }
       }
       catch(FileNotFoundException e)
       {
    	   System.err.println("File not found");
       }
       finally
       {
    	   if(sc!=null){
    	   sc.close();}
       }
       
       Purchase.LOOKARRAY(purchases);
       double lowerCost=0.00;
       double mondayCost=0;
       String maxday=null;
       for(Purchase purchase:purchases)
       {
    	   
    	    lowerCost+=purchase.getCost()/purchases.length;
    	    
    	   if(purchase.getWeekDay()==WeekDay.MONDAY)
    	   {
    		   mondayCost+=purchase.getCost();
    	   }
    	   
    	   int maxPurchase=0;
    	   if(purchase.getNumberOfPurchases()>maxPurchase)
    	   {
    		  maxPurchase=purchase.getNumberOfPurchases();
    		   maxday=purchase.getWeekDay().toString();
    	   }    
       }
       
       System.out.println("Lower cost="+Format.format2(lowerCost)+";\n"+"Monday's purchases="+Format.format2(mondayCost)+";\n"+"Max purchases day:"+maxday);
       Arrays.sort(purchases);
       Purchase.LOOKARRAY(purchases);
      int index= Arrays.binarySearch(purchases, new Purchase(null,6) );
      if (index<0)
      {
    	  System.out.println("Item not found");
      }
      else
      {
      System.out.println("Request item is:" +purchases[index]);
      }   
 }
	public static void LOOKARRAY(Purchase[] purchases)
    {
		 if (purchases.length>0)
	   {
   	 System.out.println("Name:"+Purchase.NAMEOFPRODUCT+";"+"Price="
	   +Format.format(Purchase.PRICE) + Purchase.discountPercentage);
   	 
        for (Purchase purchase:purchases)
        {
        System.out.println(purchase);
        }
	   }  
    }
}