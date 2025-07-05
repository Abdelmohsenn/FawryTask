import ExceptionsGrouped.CartEmptyException;
import ExceptionsGrouped.ExpiredProductException;
import ExceptionsGrouped.InsufficientBalanceException;
import ExceptionsGrouped.OutOfStockException;

import java.util.*;

public class Demo {
    public static void main(String[] args) {

        CheckoutClass checkoutClass = new CheckoutClass();

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 3);
        Date expiryDate = cal.getTime();

        Calendar cal2 = Calendar.getInstance();
        cal2.add(Calendar.DATE, -2);
        Date expiredDate = cal2.getTime();

        // all products in the Inventory as a sample
        Cheese cheese = new Cheese(150, 8, "Parmesiano", 3, expiryDate);
        TV tv = new TV(100000, 3, "Samsung 5293", 500);
        MobileScratchCard scratchCard = new MobileScratchCard("Scratch Card", 80, 10);
        Mobile mobile = new Mobile(42000, 1, "iPhone 14 Pro", 0.24);
        Biscuit biscuit = new Biscuit(10, 2, "McVities", expiryDate);
        Cheese expiredCheese = new Cheese(100, 1, "OldCheese", 1, expiredDate);

        // customers initialization object
        Customer richCustomer = new Customer(1000000, "Mohamed", new Cart());
        Customer poorCustomer = new Customer(100, "Ahmed", new Cart());
        Customer emptyCartCustomer = new Customer(100000, "Hassan", new Cart());


        System.out.println("======== Test 1: Normal Checkout ========");
        Cart cart1 = new Cart();
        cart1.add(cheese, 2);
        cart1.add(tv, 1);
        cart1.add(scratchCard, 1);        try {
            checkoutClass.checkout(cart1, richCustomer);
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("\n======== Test 2: Out Of Stock Exception ========");
        Cart cart2 = new Cart();
        cart2.add(cheese, 20);
        try {
            checkoutClass.checkout(cart2, richCustomer);
        } catch (OutOfStockException e) {
            System.out.println("Caught OutOfStockException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("\n======== Test 3: Expired Product Exception ========");
        Cart cart3 = new Cart();
        cart3.add(expiredCheese, 1);
        try {
            checkoutClass.checkout(cart3, richCustomer);
        } catch (ExpiredProductException e) {
            System.out.println("Caught ExpiredProductException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("\n======== Test 4: Insufficient Balance ========");
        Cart cart4 = new Cart();
        cart4.add(tv, 1);
        try {
            checkoutClass.checkout(cart4, poorCustomer);
        } catch (InsufficientBalanceException e) {
            System.out.println("Caught InsufficientBalanceException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("\n======== Test 5: Empty Cart ========");
        Cart cart5 = new Cart();
        try {
            checkoutClass.checkout(cart5, emptyCartCustomer);
        } catch (CartEmptyException e) {
            System.out.println( e.getMessage());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}