public class Chips extends MenuProduct {
    public Chips(String flavor) {
        super(flavor);
    }

    @Override
    public double getPrice() {
        return 1.50;
    }

    @Override
    public String getDescription() {
        return "Chips - " + name;
    }
}
