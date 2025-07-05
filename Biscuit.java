import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Biscuit extends ProductClass { // assume biscuits do not require shipping

// my needed variable
    private Date expiryDate;

    public Biscuit(int price, int quantity, String name, Date expiryDate){
        super(price, name, quantity); // this is the super constuctor for the reference to the parent class (ProductClass)
        this.expiryDate = expiryDate;
    }


    public Date getExpiryDate() {
        return expiryDate;
    }
    
    @Override
    public boolean isExpired() {
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

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -3);
        Date expiryDate = cal.getTime();

        Biscuit instant = new Biscuit(10, 2, "MCvities", expiryDate);
        System.out.println("Price of the biscuit is " + instant.getPrice() + "$");
        System.out.println("quantity of the biscuit ordered: " + instant.getQuantity());
        System.out.println("Name of the biscuit is " + instant.getName());
        System.out.println("Weight of the biscuit is " + instant.getWeight()+ " kg");
        System.out.println("The biscuit will get expired on " + instant.getExpiryDate());
        System.out.println("Is the Biscuit Expired? " + instant.isExpired()); // here will get as it is expired, since we are adding -3


    }

}