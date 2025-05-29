public class Topping extends MenuProduct {
    private double basePrice;
    private boolean isExtra;

    public Topping(String name, double basePrice, boolean isExtra) {
        super(name);
        this.basePrice = basePrice;
        this.isExtra = isExtra;
    }

    @Override
    public double getPrice() {
        return isExtra ? basePrice * 1.5 : basePrice;
    }

    @Override
    public String getDescription() {
        return name + (isExtra ? " (extra)" : "");
    }
}
