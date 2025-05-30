import java.util.ArrayList;
import java.util.List;

public class SignatureSandwich extends Sandwich {

    public SignatureSandwich(String type) {
        super("8", getBread(), getToppings(type), isToasted(type));
    }

    private static Bread getBread() {
        return new Bread("White", 7.00); // Default 8" price
    }

    private static boolean isToasted(String type) {
        return switch (type.toLowerCase()) {
            case "blt", "philly cheese" -> true;
            default -> false;
        };
    }

    private static List<Topping> getToppings(String type) {
        List<Topping> toppings = new ArrayList<>();
        switch (type.toLowerCase()) {
            case "blt" -> {
                toppings.add(new Topping("Bacon", 2.00, false));
                toppings.add(new Topping("Cheddar", 1.50, false));
                toppings.add(new Topping("Lettuce", 0.00, false));
                toppings.add(new Topping("Tomatoes", 0.00, false));
                toppings.add(new Topping("Ranch", 0.00, false));
            }
            case "philly cheese" -> {
                toppings.add(new Topping("Steak", 2.00, false));
                toppings.add(new Topping("American", 1.50, false));
                toppings.add(new Topping("Peppers", 0.00, false));
                toppings.add(new Topping("Mayo", 0.00, false));
            }
            case "veggie delight" -> {
                toppings.add(new Topping("Lettuce", 0.00, false));
                toppings.add(new Topping("Tomatoes", 0.00, false));
                toppings.add(new Topping("Cucumbers", 0.00, false));
                toppings.add(new Topping("Pickles", 0.00, false));
                toppings.add(new Topping("Vinaigrette", 0.00, false));
            }
        }
        return toppings;
    }
}
