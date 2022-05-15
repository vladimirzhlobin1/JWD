package by.epam.lab.beans;

import java.util.Formatter;

import by.epam.lab.Constants;
import by.epam.lab.enums.EnumRow;

public class PrintPurchase {

    public static String print(Purchase purchase) {

        Formatter formatter = new Formatter();
        String format = EnumRow.NAME.get() +Constants.DELIMITER+
                EnumRow.PRICE.get() +Constants.DELIMITER+
                EnumRow.NUMBER.get() +Constants.DELIMITER+
                EnumRow.DISCOUNT.get() +Constants.DELIMITER+
                EnumRow.COST.get()+Constants.DELIMITER;
        formatter.format(format, purchase.getName(), purchase.getPrice(), purchase.getNumber(),
                getDiscount(purchase), purchase.getCost());
        return formatter.toString();

    }

    private static String getDiscount(Purchase purchase) {
        return purchase.getClass() == PriceDiscountPurchase.class ?
                ((PriceDiscountPurchase) purchase).getDiscount().toString() : Constants.WITHOUT_DISCOUNT;
    }

}