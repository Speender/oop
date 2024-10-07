import java.util.ArrayList;
import java.util.List;

public abstract class InventoryOperation {
    public abstract void addProduct(String product);
    public abstract void removeProduct(String product);
}

class Inventory extends InventoryOperation {
    private List<String> products = new ArrayList<>(); 

    @Override
    public void addProduct(String product) {
        products.add(product);
        System.out.println(product + " added.");
    }

    @Override
    public void removeProduct(String product) {
        boolean isRemoved = products.remove(product);
        if (isRemoved) {
            System.out.println(product + " removed.");
        } else {
            System.out.println(product + " not found.");
        }
    }
    public void showProducts() {
        System.out.println("Current inventory: " + products);
    }
}
