
public class TV extends ProductClass implements ShippingInterface{ // shippable prod

// my needed variables for Tv

    public double weight; // the only new var since it is shippable


    public TV(int price, int quantity, String name, double weight){

        super(price,name,quantity); // this is the super constuctor for the reference to the parent class (ProductClass)
        this.weight = weight;

    }

    @Override
    public double getWeight() {
        return weight;
    }
    @Override
    public boolean isShippingRequired() { // since Tv is a shippable item, it is true by default
        return true;
    }

    public static void main(String args[]){
    // printing for testing, no expiry date required, all units in KGs! and EGP for prices
        TV tv = new TV(100000,1,"Samsung 5293",500);

        System.out.println("Name of the Tv: " + tv.getName());
        System.out.println("Price: EGP" + tv.getPrice());
        System.out.println("Quantity: " + tv.getQuantity());
        System.out.println("Is it shippable? " + tv.isShippingRequired());
        System.out.println("Weight of the Tv is : " + tv.getWeight() + " in kg");
    }
}