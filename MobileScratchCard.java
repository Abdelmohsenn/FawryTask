public class MobileScratchCard extends ProductClass

{

public MobileScratchCard(String name, int price, int quantity){ // only the super constructor needed
    super(price, name, quantity);
}

@Override
public boolean isShippingRequired()
{
    // the mobile cards does not require shipping
    return false;
}


    public static void main(String[] args)
    {
        MobileScratchCard mobileCard = new MobileScratchCard("Vodafone Scratch Card", 80, 10);
        System.out.println("the customer has ordered " + mobileCard.getQuantity()+" " + mobileCard.getName() + " with a price of EGP " +
                mobileCard.getPrice()*mobileCard.getQuantity());


}
}
