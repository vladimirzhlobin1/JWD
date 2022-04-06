import by.epam.lab.comparators.PurchaseComparatorBuilder;
import by.epam.lab.main.Purchase;
import by.epam.lab.main.PurchasesList;

public class Runner {
    public static void main(String[] args) {
        final String inFile = "in.csv";
        final String addonFile = "dutyFree.csv";
        PurchaseComparatorBuilder.buildPurchaseComparator("in.csv");
        final PurchasesList mainList = new PurchasesList(inFile);
        printList(mainList, "print");
        final PurchasesList addonList = new PurchasesList(addonFile);
        mainList.insertPurchase(0, addonList.getPurchaseByIndex(addonList.size() - 1));
        mainList.insertPurchase(354, addonList.getPurchaseByIndex(0));
        if (mainList.deletePurchase(3) < 0) {
            printErr("Error : you try delete an invalid index");
        }
        if (mainList.deletePurchase(-7) < 0) {
            printErr("Error : you try delete an invalid index");
        }
        if (mainList.deletePurchase(20) < 0) {
            printErr("Error : you try delete an invalid index");
        }
        mainList.deletePurchase(1, 5);
        printList(mainList, "print before sort");
        mainList.sort();
        printList(mainList, "Print after sort");
        search(mainList, addonList, 5);
        search(mainList, addonList, 2);
    }

    private static void printList(PurchasesList list, String header) {
        System.out.println(header);
        System.out.println(list.getProducts());
        System.out.println();
    }

    private static void search(PurchasesList in, PurchasesList addon, int index) {
        Purchase purchase = addon.getPurchaseByIndex(index);
        int id = in.search(purchase);
        System.out.println("Purchase " + purchase + (id >= 0 ? " was found at position " + id : " wasn't found"));
    }

    private static void printErr(String str) {
        System.err.println(str);
    }
}