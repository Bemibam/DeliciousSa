import java.util.ArrayList;
import java.util.List;

public class SignatureSandwich extends Sandwich {

    public SignatureSandwich(String type) {
        super(getSize(type), getBread(type), getToppings(type), isToasted(type));
    }

    private static String getSize(String type) {
        return "8"; // All signature sandwiches are 8"
    }

    private static Bread getBread(String type) {
        return new Bread("white", 7.00); // You can customize per sandwich if needed
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
                toppings.add(new Topping("bacon", 2.00, false));
                toppings.add(new Topping("cheddar", 1.50, false));
                toppings.add(new Topping("lettuce", 0.0, false));
                toppings.add(new Topping("tomato", 0.0, false));
                toppings.add(new Topping("ranch", 0.0, false));
            }

            case "philly cheese" -> {
                toppings.add(new Topping("steak", 2.00, false));
                toppings.add(new Topping("american", 1.50, false));
                toppings.add(new Topping("peppers", 0.0, false));
                toppings.add(new Topping("mayo", 0.0, false));
            }

            case "veggie delight" -> {
                toppings.add(new Topping("lettuce", 0.0, false));
                toppings.add(new Topping("cucumbers", 0.0, false));
                toppings.add(new Topping("tomato", 0.0, false));
                toppings.add(new Topping("pickles", 0.0, false));
                toppings.add(new Topping("vinaigrette", 0.0, false));
            }

            default -> {
                toppings.add(new Topping("lettuce", 0.0, false));
            }
        }

        return toppings;
    }
}

