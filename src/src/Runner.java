import by.gsu.epamlab.comparators.PurchaseComparatorBuilder;
import by.gsu.epamlab.main.Purchase;
import by.gsu.epamlab.main.PurchasesList;
public class Runner {
    public static void main(String[] args) {
            final String inFile = "in.csv";
            final String addonFile = "addon.csv";
            PurchaseComparatorBuilder.buildPurchaseComparator("in.csv");
            final PurchasesList mainList = new PurchasesList(inFile);
            printList(mainList, "after creation");
            final PurchasesList addonList = new PurchasesList(addonFile);
            mainList.insertPurchase(0, addonList.getPurchaseByIndex(addonList.size() - 1));
            mainList.insertPurchase(354, addonList.getPurchaseByIndex(0));
            if (mainList.deletePurchase(3) < 0) {printErr("Error : you try delet an invalid index");}
            if (mainList.deletePurchase(4) < 0) {printErr("Error : you try delet an invalid index");}
            if (mainList.deletePurchase(5) < 0) {printErr("Error : you try delet an invalid index");} 
            if (mainList.deletePurchase(-7) < 0){printErr("Error : you try delet an invalid index");} 
            if (mainList.deletePurchase(20) < 0){printErr("Error : you try delet an invalid index");}
            printList(mainList, "before sorting");
            mainList.sort();
            printList(mainList, "after sorting");
            search(mainList, addonList, 1);
            search(mainList, addonList, 3);        
            }
    private static void printList(PurchasesList list, String header) {
        System.out.println(header);System.out.println(list.getProducts());System.out.println();}

    private static void search(PurchasesList in, PurchasesList addon, int index) {
        Purchase purchase = addon.getPurchaseByIndex(index);
        int id = in.search(purchase);
        System.out.println("Purchase " + purchase + (id >= 0 ? " is found at position " + id : " isn't found"));}
    private static void printErr(String str) {System.err.println(str);}}