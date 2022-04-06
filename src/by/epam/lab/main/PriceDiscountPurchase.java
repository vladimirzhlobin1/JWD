package by.epam.lab.main;

import by.epam.lab.Constants;
import by.epam.lab.enums.Fields;
import by.epam.lab.exceptions.NonpositiveArgumentException;

public class PriceDiscountPurchase extends Purchase {

    private Byn discount;

    public PriceDiscountPurchase(String productName, int price, int numberUnits, int priceDiscount) {
        super(productName, price, numberUnits);
        setDiscount(priceDiscount);

    }

    public void setDiscount(Byn discount) {
        if (discount.equals(new Byn())) {
            throw new NonpositiveArgumentException(0, Fields.DISCOUNT);
        }
        this.discount = discount;
        if (this.discount.compareTo(getPrice()) >= 0) {
            throw new IllegalArgumentException(Constants.ERROR_WRONG_DISCOUNT);
        }
    }

    public void setDiscount(int discountInt) {
        checkPositive(discountInt, Fields.DISCOUNT);
        setDiscount(new Byn(discountInt));
    }

    public Byn getDiscount() {
        return discount;
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + Constants.DELIMITER + discount;
    }

    @Override
    public Byn getCost() {
        Byn cost = new Byn(getPrice());
        return cost.sub(discount).mul(getNumber());
    }
}