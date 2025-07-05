import java.time.LocalDate;
import java.util.Date;
import java.util.Calendar;

public class Cheese extends ProductClass implements ShippingInterface { // shippable prod

// my needed variables for Tv

    private double weight;
    private Date expiryDate;

    public Cheese(int price, int quantity, String name, int weight, Date expiryDate){
        super(price,name,quantity); // this is the super constuctor for the reference to the parent class (ProductClass)
        this.weight = weight;
        this.expiryDate = expiryDate;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }
    @Override
    public boolean isShippingRequired()
    { // the mobile cards does not require shipping
        return true;
    }

    @Override
    public boolean isExpired() {
        // here is a function for checking if the product has expired or not.
        // I am declaring a now time and compare it to the expiry date, then check who is larger
        Date today = new Date();
        long now = today.getTime();
        long expiry = expiryDate.getTime();
        if (now > expiry) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String args[]){
        // Simple testing by printing
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 3);
        Date expiryDate = cal.getTime();

        Cheese instant = new Cheese(150, 2, "Parmesiano", 3, expiryDate);
        System.out.println("Price of the cheese is " + instant.getPrice() + " EGP");
        System.out.println("quantity of the cheese ordered: " + instant.getQuantity());
        System.out.println("Name of the cheese is " + instant.getName());
        System.out.println("Weight of the cheese is " + instant.getWeight()+ " kg");

        System.out.println("Is it shippable? " + instant.isShippingRequired());

        System.out.println("The Cheese will get expired on " + instant.getExpiryDate());
        System.out.println("Is the Cheese Expired? " + instant.isExpired()); // here will get as still valid (expired = false), since we are adding 3

    }
}