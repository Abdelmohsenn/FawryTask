import java.util.Map;

public class ShippingService { // shipping service returning the total weight and print each shipped item details
    public double itemsShipped(Map<ShippingInterface, Integer> items) {
        double totalWeight = 0.0;
        for (Map.Entry<ShippingInterface, Integer> pair : items.entrySet()) {
            ShippingInterface item = pair.getKey();
            int quantity = pair.getValue();
            double itemTotalWeight = item.getWeight() * quantity;
            System.out.printf("Shipping item: %dx %s (%.2f kg total)%n",
                    quantity, item.getName(), itemTotalWeight);
            totalWeight += itemTotalWeight;
        }

        System.out.printf("Total package weight %.2fkg%n", totalWeight);
        return totalWeight;
    }
}
