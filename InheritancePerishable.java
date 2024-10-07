public class InheritancePerishable(String productId, String productName, int quantity, double price, String expirationDate) {
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
    if (amount < 0 && getQuantity() + amount < 0) {
        System.out.println("Insufficient stock for product " + getProductName() + ".");
    }
    int newQuantity = getQuantity() + amount;
    if (newQuantity > MAX_QUANTITY) {
        System.out.println("Cannot exceed maximum quantity of " + MAX_QUANTITY + " for perishable products.");
    } else {
        setQuantity(newQuantity);
        System.out.println("Stock updated. New quantity: " + getQuantity());
    }
}    
    public InheritanceNonPerishable(String productId, String productName, int quantity, double price, int shelfLife) {
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
        if (amount < 0 && getQuantity() + amount < 0) {
            System.out.println("Insufficient stock for product " + getProductName() + ".");
        }
        int newQuantity = getQuantity() + amount;
        if (newQuantity > MAX_QUANTITY) {
            System.out.println("Cannot exceed maximum quantity of " + MAX_QUANTITY + " for perishable products.");
        } else {
            setQuantity(newQuantity);
            System.out.println("Stock updated. New quantity: " + getQuantity());
        }
    }
}