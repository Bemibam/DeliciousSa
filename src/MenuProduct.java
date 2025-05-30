public abstract class MenuProduct {
    protected String name;

    public MenuProduct(String name) {
        this.name = name;
    }

    public abstract double getPrice();
    public abstract String getDescription();
}



