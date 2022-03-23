package by.epam.lab.main;

import by.epam.lab.Constants;
import by.epam.lab.enums.Fields;
import by.epam.lab.exceptions.RawException;

public class PurchasesFactory {

    private final static int PURCHASE_FIELDS_NUMBER = Purchase.class.getDeclaredFields().length;
    private final static int DISCOUNT_PURCHASE_FIELDS_NUMBER = PURCHASE_FIELDS_NUMBER+ PriceDiscountPurchase.class.getDeclaredFields().length;
    public static Purchase getPurchaseFromFactory(String file) throws RawException {
      
        try {
        	  Purchase purchase;
            String[] mass = file.split(Constants.DELIMITER);
            if ((mass.length != PURCHASE_FIELDS_NUMBER) && (mass.length != DISCOUNT_PURCHASE_FIELDS_NUMBER)) {
                throw new RawException(Constants.ERROR_FORMAT_NUMBER, file);
            }
            String name = mass[Fields.NAME.ordinal()];
            int price = Integer.parseInt(mass[Fields.PRICE.ordinal()]);
            int number = Integer.parseInt(mass[Fields.NUMBER.ordinal()]);
            if (mass.length == PURCHASE_FIELDS_NUMBER) {
                purchase = new Purchase(name, price, number);
            } else {
                int discount = Integer.parseInt(mass[Fields.DISCOUNT.ordinal()]);
                purchase = new PriceDiscountPurchase(name, price, number, discount);
            }
            return purchase;
        } catch (NumberFormatException e) {
            throw new RawException(Constants.ERROR_INCORRECT_NUMBER, file);
        } catch (RuntimeException e) {
            throw new RawException(e, file);
        }
    }
}