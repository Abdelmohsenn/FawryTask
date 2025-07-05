import ExceptionsGrouped.InsufficientBalanceException;

public class Customer {
    private double balance;
    private String name;
    private Cart cart = new Cart();

    public Customer(double balance, String name, Cart cart) {
        this.balance = balance;
        this.name = name;
        this.cart = cart;
    }
    public double subtotal(){
        double subTotal = cart.getSumtotal();
        return subTotal;
    }
    public double getTotalPaidAmount(){ // retrieving car total + shipping
        double totalShippingCost = cart.getTotalShippingCost();
        double totalPaid = totalShippingCost + subtotal();
        return totalPaid;
    }

    public double getBalance(){ // get balance getter
        return balance;
    }

    public void deductBalance(double amount) {
        if (amount > balance) throw new InsufficientBalanceException("Sorry You have an Insufficient balance");
        balance = balance - amount;
        System.out.println("Your Remaining Balance => " + balance + " EGP");
    }

    public String getName(){
        return name;
    }

}
