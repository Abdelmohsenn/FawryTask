import ExceptionsGrouped.CartEmptyException;
import ExceptionsGrouped.ExpiredProductException;
import ExceptionsGrouped.InsufficientBalanceException;
import ExceptionsGrouped.OutOfStockException;

import javax.swing.event.CaretEvent;
import java.util.Map;
import java.util.HashMap;

public class CheckoutClass {
    public void checkout(Cart cart, Customer customer) {
        if (cart == null || cart.isEmpty()) { // first error when the cart is null
            throw new CartEmptyException("Cart is empty. Cannot checkout.");
        }
        for (Cart.Item item : cart.getItems()) {
            ProductClass product = item.getProduct();
            if (product.isExpired()) {
                throw new ExpiredProductException("Product " + product.getName() + " is expired and cannot be checked out.");
            }
        }
        // all the sum and prices
        double subtotal = cart.getSumtotal();
        double shipping = cart.getTotalShippingCost();
        double total = subtotal + shipping;

        if (customer.getBalance() < total) {
            throw new InsufficientBalanceException("Insufficient balance. Please recharge your balance and try again!");
        }

        System.out.println("** Shipment notice **");
        ShippingService shippingService = new ShippingService();
        Map<ShippingInterface, Integer> shippingItems = new HashMap<>(); // initalizing a HashMap for the shipped items, quantity pair

        for (Cart.Item item : cart.getItems()) {
            ProductClass prod = item.getProduct();
            if (prod instanceof ShippingInterface) {
                shippingItems.put((ShippingInterface) prod, item.getItemQuantity());
            }
        }
        shippingService.itemsShipped(shippingItems); // calling the shippingService function

        System.out.println("** Checkout receipt **");
        for (Cart.Item item : cart.getItems()) {
            int price = item.getPrice() * item.getItemQuantity();
            System.out.printf("%s, %d EGP, Quantity: %d%n",
                    item.getProduct().getName(),
                    price,
                    item.getItemQuantity());
        }
        // summing up every detail
        System.out.println("----------------------");
        System.out.printf("Subtotal => %.0f EGP %n", subtotal);
        System.out.printf("Shipping => %.0f EGP %n", shipping);
        System.out.printf("Total Amount => %.0f EGP %n", total);

        for (Cart.Item item : cart.getItems()) {
            item.getProduct().decreaseQuantity(item.getItemQuantity());
        }
        customer.deductBalance(total);
    }
}