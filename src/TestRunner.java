import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import by.epam.lab.*;
import by.epam.lab.exceptions.RawException;
import by.epam.lab.main.Purchase;
import by.epam.lab.main.PurchasesFactory;
public class TestRunner {

	public void testFabricMethod () throws RawException {
		String purchase = "bread;155;1"; 
		String purchaseDiscount = "bread;180;2;10"; 
		Purchase purchaseOBJ = PurchasesFactory.getPurchaseFromFactory(purchase);
		Purchase purchaseDiscountObj = PurchasesFactory.getPurchaseFromFactory(purchaseDiscount);
		assertEquals(purchase, purchaseOBJ);
		assertEquals(purchaseDiscount, purchaseDiscountObj);
		
	}
	
}
