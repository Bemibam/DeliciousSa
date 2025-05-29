public class Bread extends MenuProduct {
    private double price;

    public Bread(String name, double price) {
        super(name);
        this.price = price;
    }

    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getDescription() {
        return name + " bread";
    }
}

