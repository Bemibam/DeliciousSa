import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SandwichBuilder {

    private static final Map<String, Double> breadPrices = Map.of(
            "white", 5.50,
            "wheat", 5.50,
            "rye", 5.50,
            "wrap", 5.50
    );

    private static final Map<String, Double> meatPrices = Map.of(
            "steak", 1.00,
            "ham", 1.00,
            "salami", 1.00,
            "roast beef", 1.00,
            "chicken", 1.00,
            "bacon", 1.00
    );

    private static final Map<String, Double> cheesePrices = Map.of(
            "american", 0.75,
            "provolone", 0.75,
            "cheddar", 0.75,
            "swiss", 0.75
    );

    private static final String[] regularToppings = {
            "lettuce", "peppers", "onions", "tomatoes", "jalapeños",
            "cucumbers", "pickles", "guacamole", "mushrooms"
    };

    private static final String[] sauces = {
            "mayo", "mustard", "ketchup", "ranch", "thousand islands", "vinaigrette"
    };

    public static Sandwich build(Scanner scanner) {
        // Step 1: Bread
        System.out.print("Select bread (white/wheat/rye/wrap): ");
        String breadType = scanner.nextLine().trim().toLowerCase();
        double breadPrice = breadPrices.getOrDefault(breadType, 5.50);
        Bread bread = new Bread(breadType, breadPrice);

        // Step 2: Size
        System.out.print("Choose sandwich size (4\" / 8\" / 12\"): ");
        String size = scanner.nextLine().trim();

        // Step 3: Toppings
        List<Topping> toppings = new ArrayList<>();

        for (String meat : meatPrices.keySet()) {
            System.out.print("Add " + meat + "? (yes/no): ");
            if (scanner.nextLine().equalsIgnoreCase("yes")) {
                System.out.print("Extra " + meat + "? (yes/no): ");
                boolean extra = scanner.nextLine().equalsIgnoreCase("yes");
                toppings.add(new Topping(meat, meatPrices.get(meat), extra));
            }
        }

        for (String cheese : cheesePrices.keySet()) {
            System.out.print("Add " + cheese + "? (yes/no): ");
            if (scanner.nextLine().equalsIgnoreCase("yes")) {
                System.out.print("Extra " + cheese + "? (yes/no): ");
                boolean extra = scanner.nextLine().equalsIgnoreCase("yes");
                toppings.add(new Topping(cheese, cheesePrices.get(cheese), extra));
            }
        }

        for (String topping : regularToppings) {
            System.out.print("Add " + topping + "? (yes/no): ");
            if (scanner.nextLine().equalsIgnoreCase("yes")) {
                toppings.add(new Topping(topping, 0.00, false));
            }
        }

        for (String sauce : sauces) {
            System.out.print("Add " + sauce + "? (yes/no): ");
            if (scanner.nextLine().equalsIgnoreCase("yes")) {
                toppings.add(new Topping(sauce, 0.00, false));
            }
        }

        // Toasted?
        System.out.print("Would you like the sandwich toasted? (yes/no): ");
        boolean toasted = scanner.nextLine().equalsIgnoreCase("yes");

        return new Sandwich(size, bread, toppings, toasted);
    }
}
