import ExceptionsGrouped.OutOfStockException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

public class Cart {
    private static final int shippingPrice = 10; // 10 EGP per kg

    static class Item {
        private  ProductClass product;
        private int quantity;
        public Item(ProductClass product, int quantity){
            this.product = product;
            this.quantity = quantity;
        }
        public ProductClass getProduct() {
            return product;
        }
        public int getItemQuantity() {
            return quantity; // this is the quantity of the items already added
        }

        public int getRemainingQuantity() {
            return product.getQuantity() - quantity; // quantity left for this item
        }
        public int getPrice() {
            return product.getPrice();
        }

        public double getWeight() {
            return product.getWeight();
        }

    }


    private Vector<Item> items = new Vector<>(); // Vector for all items in the cart
    private int shippingcost;
    public void add(ProductClass product, int quan){
        Item item = new Item(product, quan);
        if (item.getRemainingQuantity() < 0){
            System.out.println("Not enough stock to add the following product: " + product.getName() + "!"); // check the GroupedFile for Exceptions
        } else {
            items.add(item);
        }
    }
    public Vector<Item> getItems() {
        return items;
    }
    public boolean isEmpty() {
        return items.isEmpty();
    }

    public double getTotalWeight() {
        double totalWeight = 0;
        for (Item item : items) {
            ProductClass prod = item.getProduct();
            if (prod instanceof ShippingInterface requiresShipping) {
                totalWeight = totalWeight + requiresShipping.getWeight() * item.getItemQuantity();
            }
        }
        return totalWeight;
    }

    public double getTotalShippingCost() {
        return getTotalWeight() * shippingPrice;
    }

    public double getSumtotal() {
        double sum = 0;
        for (Item item : items) {
            sum += item.getPrice() * item.getItemQuantity();
        }
        return sum;
    }

    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 3);
        Date expiryDate = cal.getTime();

        Cart cart = new Cart();
        TV tv = new TV(100000,1,"Samsung 5293",500);
        Cheese cheese = new Cheese(150, 12, "Parmesiano", 3, expiryDate);
        cart.add(cheese, 10);
        cart.add(tv, 1);
    }


}
