import java.util.List;

public class Sandwich extends MenuProduct {
    private String size;
    private Bread bread;
    private List<Topping> toppings;
    private boolean toasted;

    public Sandwich(String size, Bread bread, List<Topping> toppings, boolean toasted) {
        super(size + "\" " + bread.getDescription());
        this.size = size;
        this.bread = bread;
        this.toppings = toppings;
        this.toasted = toasted;
    }

    @Override
    public double getPrice() {
        double total = bread.getPrice();
        for (Topping topping : toppings) {
            total += topping.getPrice();
        }
        return total;
    }

    @Override
    public String getDescription() {
        StringBuilder sb = new StringBuilder(name + (toasted ? " (toasted)" : "") + "\n");
        for (Topping topping : toppings) {
            sb.append("  - ").append(topping.getDescription()).append(" [$")
                    .append(String.format("%.2f", topping.getPrice())).append("]\n");
        }
        return sb.toString();
    }
}
