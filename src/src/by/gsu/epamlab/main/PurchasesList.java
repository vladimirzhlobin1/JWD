package by.gsu.epamlab.main;

import by.gsu.epamlab.Constants;
import by.gsu.epamlab.comparators.PurchaseComparatorBuilder;
import by.gsu.epamlab.enums.EnumRow;
import by.gsu.epamlab.exceptions.RawException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class PurchasesList {

    private boolean product = false;

    private List<Purchase> purchases;

    private final Comparator<Purchase> PURCHASE_COMPARATOR = PurchaseComparatorBuilder.getPurchaseComparator();

    public PurchasesList() {
        setPurchases(new ArrayList<>());
        product = true;
    }

    public PurchasesList(String fileName) {
        this();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileReader(Constants.PACKAGE + fileName));

            while (scanner.hasNext()) {
                Purchase purchase = null;
                try {
                    purchase = PurchasesFactory.getPurchaseFromFactory(scanner.next());
                } catch (RawException e) {System.err.println(e);
                }
                if (purchase != null) { purchases.add(purchase);
                }}

        } catch (FileNotFoundException e) {
            System.err.println(Constants.ERROR_FILE + Constants.PACKAGE+ fileName + Constants.FORMAT);
        } finally {if (scanner != null) {scanner.close();}
        }}

    public void setPurchases(List<Purchase> purchases) {
        if (purchases == null) {
            throw new NullPointerException();
        }
        this.purchases = purchases;
        product = false;
    }

    public int size() {
        return purchases.size();
    }

    public String getProducts() {
        Formatter formatter = new Formatter();
        StringBuilder builder = new StringBuilder();
        String format = EnumRow.NAME.get() +
                EnumRow.PRICE.get() +
                EnumRow.NUMBER.get() +
                EnumRow.DISCOUNT.get() +
                EnumRow.COST.get();
        formatter.format(format, EnumRow.NAME, EnumRow.PRICE, EnumRow.NUMBER,
                EnumRow.DISCOUNT, EnumRow.COST);
        builder.append(formatter).append(Constants.NEW_LINE_LIST);

        for (Purchase purchase : purchases) {
            builder.append(PrintPurchase.print(purchase)).append(Constants.NEW_LINE_LIST);
        }

        formatter = new Formatter();
        formatter.format(Constants.TOTAL_COST + Constants.FORMATTER_TOTALCOST + Constants.NEW_LINE, getFullCost());
        builder.append(formatter);

        return builder.toString();
    }

    public Byn getFullCost() {

        Byn totalCost = new Byn(0);
        for (Purchase purchase : purchases) {
            totalCost.add(purchase.getCost());
        }
        return totalCost;
    }

    public void insertPurchase(int index, Purchase purchase) {
        if (index < 0) {
            index = 0;
        }
        if (index > purchases.size()) {
            index = purchases.size();
        }
        purchases.add(index, purchase);
        errorPuch();
    }

    private boolean normIndex(int index) {
        return index >= 0 && index < purchases.size();
    }

    public int deletePurchase(int index) {
        int res;
        if (normIndex(index)) {
            purchases.remove(index);
            res = purchases.size();
            errorPuch();
        } else {
            res = -1;
        }
        return res;
    }

    public Purchase getPurchaseByIndex(int index) {
        Purchase purchase;
        if (normIndex(index)) {
            purchase = purchases.get(index);
        } else {
            purchase = null;
        }
        return purchase;
    }

    public void sort() {
        Collections.sort(purchases, PURCHASE_COMPARATOR);
        product = true;
    }
private void errorPuch() {
        product = false;
    }
    public int search(Purchase purchase) {
        if (!product) {
            sort();
        }
        return Collections.binarySearch(purchases, purchase, PURCHASE_COMPARATOR);
    }
    
}