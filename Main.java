// Custom Exceptions
class InsufficientStockException extends Exception {
    public InsufficientStockException(String message) {
        super(message);
    }
}

class InvalidQuantityException extends Exception {
    public InvalidQuantityException(String message) {
        super(message);
    }
}

// Encapsulation
class Product {
    private String productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

// Inheritance
class PerishableProduct extends Product {
    private String expirationDate;
    private static final int MAX_QUANTITY = 100;

    public PerishableProduct(String productId, String productName, int quantity, double price, String expirationDate) {
        super(productId, productName, quantity, price);
        this.expirationDate = expirationDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void updateStock(int amount) {
        try {
            if (amount < 0) {
                if (getQuantity() + amount < 0) {
                    System.out.println("Insufficient stock for product " + getProductName() + ".");
                }
            } else if (amount < 0) {
                System.out.println("Quantity cannot be negative.");
            }

            int newQuantity = getQuantity() + amount;
            if (newQuantity > MAX_QUANTITY) {
                System.out.println("Cannot exceed maximum quantity of " + MAX_QUANTITY + " for perishable products.");
            } else {
                setQuantity(newQuantity);
                System.out.println("Stock updated: " + getProductName() + " new quantity is " + getQuantity());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class NonPerishableProduct extends Product {
    private int shelfLife;

    public NonPerishableProduct(String productId, String productName, int quantity, double price, int shelfLife) {
        super(productId, productName, quantity, price);
        this.shelfLife = shelfLife;
    }

    public int getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(int shelfLife) {
        this.shelfLife = shelfLife;
    }

    public void updateStock(int amount) {
        try {
            if (amount < 0) {
                if (getQuantity() + amount < 0) {
                    System.out.println("Insufficient stock for product " + getProductName() + ".");
                }
            } else if (amount < 0) {
                System.out.println("Quantity cannot be negative.");
            }

            int newQuantity = getQuantity() + amount;
            setQuantity(newQuantity);
            System.out.println("Stock updated: " + getProductName() + " new quantity is " + getQuantity());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

// Abstraction
abstract class InventoryOperation {
    public abstract void addProduct(Product product);

    public abstract void removeProduct(String productId);
}

class Inventory extends InventoryOperation {
    private java.util.List<Product> products = new java.util.ArrayList<>();

    @Override
    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Product added: " + product.getProductName() + " with quantity " + product.getQuantity());
    }

    @Override
    public void removeProduct(String productId) {
        for (Product product : products) {
            if (product.getProductId().equals(productId)) {
                products.remove(product);
                System.out.println("Product " + productId + " removed successfully.");
                return;
            }
        }
        System.out.println("Product not found.");
    }

    public void showProducts() {
        System.out.println("Current inventory:");
        for (Product product : products) {
            System.out.println(product.getProductName() + " - Quantity: " + product.getQuantity());
        }
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        PerishableProduct apple =