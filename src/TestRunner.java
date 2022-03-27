import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import by.epam.lab.*;
import by.epam.lab.exceptions.RawException;
import by.epam.lab.main.Byn;
import by.epam.lab.main.PriceDiscountPurchase;
import by.epam.lab.main.Purchase;
import by.epam.lab.main.PurchasesFactory;
import by.epam.lab.main.PurchasesList;
public class TestRunner {
	private final static String FILE_NAME = "in.csv";
@Test
	public void testFabricMethod () throws RawException {
		String purchase = "bread;155;1"; 
		String purchaseDiscount = "bread;180;2;10"; 
		Purchase purchaseOBJ = PurchasesFactory.getPurchaseFromFactory(purchase);
		Purchase purchaseDiscountObj = PurchasesFactory.getPurchaseFromFactory(purchaseDiscount);
		assertEquals(purchase.toString(), purchaseOBJ.toString());
		assertEquals(purchaseDiscount.toString(), purchaseDiscountObj.toString());	
	}
@Test
public void testPuchaseConstructor(){
	List<Purchase> puchasTest = new ArrayList<>();
	puchasTest.add(new PriceDiscountPurchase("bread",155,1,2));
	puchasTest.add(new Purchase("milk", 131,2));
	puchasTest.add(new Purchase("bread",154,3));
	puchasTest.add(new Purchase("bread",145,5));
	puchasTest.add(new PriceDiscountPurchase("potato", 180, 2, 10));	
	puchasTest.add(new Purchase("butter",370,1));
	puchasTest.add(new PriceDiscountPurchase("butter", 341, 1, 1));
	puchasTest.add(new PriceDiscountPurchase("meat", 1100, 2, 80));
	PurchasesList puchList = new PurchasesList(FILE_NAME);
	assertEquals(puchasTest.toString(), puchList.toString());
}
@Test
public void testTotalCost() {
PurchasesList puchList = new PurchasesList(FILE_NAME);
Byn totalCost = puchList.getFullCost();
assertEquals(new Byn(4692).toString(), totalCost.toString());
}

@Test
public void testSearchElement() {
	PurchasesList puchList = new PurchasesList(FILE_NAME);
	int i = puchList.search(new Purchase("butter",370,1));
	assertEquals(5, i);
}

//@Test(expected = IllegalArgumentException.){}
}
