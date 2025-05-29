public class Drink extends MenuProduct {
    private String size;

    public Drink(String size, String flavor) {
        super(size + " " + flavor);
        this.size = size.toLowerCase();
    }

    @Override
    public double getPrice() {
        return switch (size) {
            case "small" -> 2.00;
            case "medium" -> 2.50;
            case "large" -> 3.00;
            default -> 2.00;
        };
    }

    @Override
    public String getDescription() {
        return name;
    }
}
