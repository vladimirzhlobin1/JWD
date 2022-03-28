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
		Purchase purchase1 = new Purchase("bread", new Byn(155),1);
		String purchaseDiscount = "bread;180;2;10"; 
		PriceDiscountPurchase priceDiscountPurchase = new PriceDiscountPurchase("bread", 180, 2, 10);
		Purchase purchaseOBJ = PurchasesFactory.getPurchaseFromFactory(purchase);
		Purchase purchaseDiscountObj = PurchasesFactory.getPurchaseFromFactory(purchaseDiscount);
		assertEquals(purchase1.toString(), purchaseOBJ.toString());
		assertEquals(priceDiscountPurchase.toString(), purchaseDiscountObj.toString());	
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
	PurchasesList puchList1 = new PurchasesList();
	puchList1.setPurchases(puchasTest);
	assertEquals(puchList1.getProducts(), puchList.getProducts());
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

@Test
public void testAddElementIntoRightPos() {
    List<Purchase> purchasesTest = new ArrayList<>();
    purchasesTest.add(new PriceDiscountPurchase("bread", 155, 1, 2));
    purchasesTest.add(new Purchase("milk", 131, 2));
    purchasesTest.add(new Purchase("butter", 370, 1));
    purchasesTest.add(new Purchase("bread", 154, 3));
    purchasesTest.add(new Purchase("bread", 145, 5));
    purchasesTest.add(new PriceDiscountPurchase("potato", 180, 2, 10));
    purchasesTest.add(new Purchase("butter", 370, 1));
    purchasesTest.add(new PriceDiscountPurchase("butter", 341,1,1));
    purchasesTest.add(new PriceDiscountPurchase("meat", 1100, 2, 80));
    PurchasesList purchaseList = new PurchasesList(FILE_NAME);
    purchaseList.insertPurchase(2, new Purchase("butter",370,1));
    PurchasesList puchList1 = new PurchasesList();
    puchList1.setPurchases(purchasesTest);
    assertEquals(puchList1.getProducts(), purchaseList.getProducts());
}


@Test
public void testAddElementIntoPosLesZero() {
    List<Purchase> purchasesTest = new ArrayList<>();
    purchasesTest.add(new Purchase("butter", 370, 1));
    purchasesTest.add(new PriceDiscountPurchase("bread", 155, 1, 2));
    purchasesTest.add(new Purchase("milk", 131, 2));
    purchasesTest.add(new Purchase("bread", 154, 3));
    purchasesTest.add(new Purchase("bread", 145, 5));
    purchasesTest.add(new PriceDiscountPurchase("potato", 180, 2, 10));
    purchasesTest.add(new Purchase("butter", 370, 1));
    purchasesTest.add(new PriceDiscountPurchase("butter", 341, 1, 1));
    purchasesTest.add(new PriceDiscountPurchase("meat", 1100, 2, 80));
    PurchasesList purchaseList = new PurchasesList(FILE_NAME);
    purchaseList.insertPurchase(-2, new Purchase("butter",370,1));
    PurchasesList puchList1 = new PurchasesList();
    puchList1.setPurchases(purchasesTest);
    assertEquals(puchList1.getProducts(), purchaseList.getProducts());
}
public void testAddElementMoreThenList() {
    List<Purchase> purchasesTest = new ArrayList<>();
    purchasesTest.add(new Purchase("butter", 370, 1));
    purchasesTest.add(new PriceDiscountPurchase("bread", 155, 1, 2));
    purchasesTest.add(new Purchase("milk", 131, 2));
    purchasesTest.add(new Purchase("bread", 154, 3));
    purchasesTest.add(new Purchase("bread", 145, 5));
    purchasesTest.add(new PriceDiscountPurchase("potato", 180, 2, 10));
    purchasesTest.add(new Purchase("butter", 370, 1));
    purchasesTest.add(new PriceDiscountPurchase("butter", 341, 1, 1));
    purchasesTest.add(new PriceDiscountPurchase("meat", 1100, 2, 80));
    PurchasesList purchaseList = new PurchasesList(FILE_NAME);
    purchaseList.insertPurchase(60, new Purchase("butter",370,1));
    PurchasesList puchList1 = new PurchasesList();
    puchList1.setPurchases(purchasesTest);
    assertEquals(puchList1.getProducts(), purchaseList.getProducts());
}

@Test
public void testDeleteSubsequenceWithCorrectIndexes() {
    PurchasesList purchaseList = new PurchasesList(FILE_NAME);
    purchaseList.deletePurchase(0, 2);
    List<Purchase> purchasesTest = new ArrayList<>();
    purchasesTest.add(new Purchase("bread", 154, 3));
    purchasesTest.add(new Purchase("bread", 145, 5));
    purchasesTest.add(new PriceDiscountPurchase("potato",180, 2, 10));
    purchasesTest.add(new Purchase("butter", 370,1));
    purchasesTest.add(new PriceDiscountPurchase("butter", 341, 1, 1));
    purchasesTest.add(new PriceDiscountPurchase("meat", 1100, 2, 80));
    PurchasesList puchList1 = new PurchasesList();
    puchList1.setPurchases(purchasesTest);
    assertEquals(puchList1.getProducts(), purchaseList.getProducts());
}
@Test
public void testDeleteSubsequenceWithIncorrectIndexes() {
    PurchasesList purchaseList = new PurchasesList(FILE_NAME);
    purchaseList.deletePurchase(0, 20);
    List<Purchase> purchasesTest = new ArrayList<>();
   
    PurchasesList puchList1 = new PurchasesList();
    puchList1.setPurchases(purchasesTest);
    assertEquals(puchList1.getProducts(), purchaseList.getProducts());
}
}
