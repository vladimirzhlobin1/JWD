package by.gsu.epamlab;
import by.gsu.epamlab.Format;
public class Purchase implements Comparable<Purchase>
{
	public static final String  NAME_OF_PRODUCT="Item";
	public static final int PRICE=770;
	private int numberOfPurchases;
	private WeekDay  weekDay;
	private double discountPercentage;
	public Purchase(){
	}
	public Purchase(WeekDay weekDay, int numberOfPurchases,int discountPercentage)
	{
		this.weekDay = weekDay;
		this.numberOfPurchases = numberOfPurchases;
		this.discountPercentage = discountPercentage;
	}
	public WeekDay getWeekDay()
	{
		return weekDay;
	}
	public void setWeekDay(WeekDay weekDay)
	{
		this.weekDay = weekDay;
	}

	public int getNumberOfPurchases()
	{
		return numberOfPurchases;
	}
	public void setNumberOfPurchases(int numberOfPurchases)
	{
		this.numberOfPurchases = numberOfPurchases;
	}
	public int getDiscountPercentage() {
		return discountPercentage;
	}
	public void setDiscountPercentage(int discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	public int getCost() {
		return (int) Math.round((PRICE * numberOfPurchases
				* (100.0 - discountPercentage) / 100) * 0.01) * 100;
	}
	public int compareTo(Purchase purchase)
	{
		if(numberOfPurchases < purchase.numberOfPurchases)
		{
			return -1;
		}
		else if(numberOfPurchases>purchase.numberOfPurchases)
		{
			return 1;
		}
		return 0;
	}

	public String toString() {
		return numberOfPurchases+";"+weekDay+";"+Format.format(getCost())+";";
	}

}
