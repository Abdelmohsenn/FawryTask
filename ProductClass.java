import ExceptionsGrouped.OutOfStockException;

public class ProductClass {

    // all variables intialization
    protected int price;
    protected String name;
    protected int quantity;


    // the getter functions
    public int getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return 0.0;  // default if does not require shipping
    }

    // constructor for the class
    public ProductClass(int price, String name, int quantity) {
        this.price = price;
        this.name = name;
        this.quantity = quantity;
    }

    //by default the product is not expired nor requires shipping
    public boolean isExpired() {
        return false;
    }

    public boolean isShippingRequired(){ // for price of shipping
        return false;
    }

    public void decreaseQuantity(int units) {
      quantity = quantity - units;
    }

}

