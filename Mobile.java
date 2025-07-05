public class Mobile extends ProductClass implements ShippingInterface{ // let us assume that mobile do require shipping
    private  double weight;

    public Mobile(int price, int quantity, String name, double weight) {
        super(price, name,quantity);
        this.weight = weight;

    }
    @Override
    public boolean isShippingRequired(){
        return true;
    }
    @Override
    public double getWeight(){
        return weight;
    }

    public static void main(String[] args) {
        Mobile mobile = new Mobile(42000, 1, "iPhone 14 Pro", 0.24);
        System.out.println(mobile.getName());
        System.out.println("Total Price = "+mobile.getQuantity()*mobile.getPrice());
        System.out.println("Weight of the "+mobile.getName()+" is "+mobile.getWeight());
        System.out.println(mobile.isShippingRequired());


    }
}
