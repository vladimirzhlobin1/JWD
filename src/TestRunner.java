
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import by.epam.lab.*;
import by.epam.lab.beans.Byn;
import by.epam.lab.beans.PriceDiscountPurchase;
import by.epam.lab.beans.Purchase;
import by.epam.lab.exceptions.NegativeArgumentException;
import by.epam.lab.exceptions.NonpositiveArgumentException;
import by.epam.lab.exceptions.CsvLineException;
import by.epam.lab.services.PurchasesFactory;
import by.epam.lab.services.PurchasesList;
public class TestRunner {
	private final static String FILE_NAME = "in.csv";
@Test
	public void testFabricMethod () throws CsvLineException {
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
@ Test (expected = CsvLineException.class)
public void testFabriqElementLessEq () throws CsvLineException {
	Purchase purchObj = PurchasesFactory.getPurchaseFromFactory("bread");
	Purchase purchObj1 = PurchasesFactory.getPurchaseFromFactory(new String ("bread;2;1;4;d"));
	Purchase purchObj2 = PurchasesFactory.getPurchaseFromFactory(new String ("bread;2;1;-4"));
	Purchase purchObj3 = PurchasesFactory.getPurchaseFromFactory(new String ("bread;2;1;40"));
}
@Test
public void testStringRepresentation() {
    PurchasesList purchaseList = new PurchasesList(FILE_NAME);
    String listToString = purchaseList.getProducts();
    String g = ";";
    final String resultString = "NAME;PRICE;NUMBER;DISCOUNT;COST;\n"+
            "bread;1.55;1;0.02;1.53;\n" + "milk;1.31;2;no discount;2.62;\n" 
    		+"bread;1.54;3;no discount;4.62;\n" + "bread;1.45;5;no discount;7.25;\n" +
                    "potato;1.80;2;0.10;3.40;\n" + "butter;3.70;1;no discount;3.70;\n" 
    		+ "butter;3.41;1;0.01;3.40;\n"
                    +"meat;11.00;2;0.80;20.40;\n" +"Total cost                          46.92\n";
    assertEquals(resultString, listToString);
}
@Test
public void testDelWithIncIndex() {
	 PurchasesList purchaseList = new PurchasesList(FILE_NAME);
	 purchaseList.deletePurchase(0, 20);
	 List<Purchase> purchasesTest = new ArrayList<>();
	 PurchasesList purchaseLis = new PurchasesList();
	 purchaseLis.setPurchases(purchasesTest);
	 assertEquals(purchaseLis.getProducts(),purchaseList.getProducts());
}
@Test
public void testListSort() {
	 PurchasesList purchaseList = new PurchasesList(FILE_NAME);
	    purchaseList.sort();
	    List<Purchase> purchasesTest = new ArrayList<>();
	    purchasesTest.add(new Purchase("bread", 154, 3));
	    purchasesTest.add(new Purchase("bread", 145, 5));
	    purchasesTest.add(new PriceDiscountPurchase("potato",180, 2, 10));
	    purchasesTest.add(new Purchase("butter", 370,1));
	    purchasesTest.add(new PriceDiscountPurchase("bread", 155, 1, 2));
	    purchasesTest.add(new Purchase("milk", 131, 2));
	    purchasesTest.add(new PriceDiscountPurchase("butter", 341, 1, 1));
	    purchasesTest.add(new PriceDiscountPurchase("meat", 1100, 2, 80));
	    PurchasesList puchList1 = new PurchasesList();
	    puchList1.setPurchases(purchasesTest);
	    puchList1.sort();
	    assertEquals(puchList1.getProducts(), purchaseList.getProducts().toString());
}
}
