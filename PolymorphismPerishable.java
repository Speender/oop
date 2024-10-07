public class PolymorphismPerishable extends Encapsulation{
    private String product; 
    private String expirationDate; 
    private static final int MAX_QUANTITY = 100;

    public PolymorphismPerishable(String product, String expirationDate) {
        super(product, product, MAX_QUANTITY, MAX_QUANTITY);
        this.product = product;
        this.expirationDate = expirationDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public static int getMaxQuantity() {
        return MAX_QUANTITY;
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