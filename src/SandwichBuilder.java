import java.util.*;

public class SandwichBuilder {
    private static final String[] breads = {"White", "Wheat", "Rye", "Wrap"};
    private static final String[] meats = {"Steak", "Ham", "Salami", "Roast Beef", "Chicken", "Bacon"};
    private static final String[] cheeses = {"American", "Provolone", "Cheddar", "Swiss"};
    private static final String[] toppings = {"Lettuce", "Peppers", "Onions", "Tomatoes", "Jalapeños", "Cucumbers", "Pickles", "Guacamole", "Mushrooms"};
    private static final String[] sauces = {"Mayo", "Mustard", "Ketchup", "Ranch", "Thousand Islands", "Vinaigrette"};

    private static final Map<String, Double> meatPrices = Map.ofEntries(
            Map.entry("Steak", 1.00), Map.entry("Ham", 1.00), Map.entry("Salami", 1.00),
            Map.entry("Roast Beef", 1.00), Map.entry("Chicken", 1.00), Map.entry("Bacon", 1.00)
    );

    private static final Map<String, Double> cheesePrices = Map.ofEntries(
            Map.entry("American", 0.75), Map.entry("Provolone", 0.75),
            Map.entry("Cheddar", 0.75), Map.entry("Swiss", 0.75)
    );

    public static Sandwich build(Scanner scanner) {
        // Bread
        String breadType = promptCategory(scanner, "Select Bread:", breads, true);
        if (breadType == null) return null;
        Bread bread = new Bread(breadType.toLowerCase(), 5.50);

        // Size
        System.out.println("Select sandwich size:");
        System.out.println("1) 4\"    2) 8\"    3) 12\"");
        String sizeOption = scanner.nextLine();
        String size = switch (sizeOption) {
            case "1" -> "4";
            case "2" -> "8";
            case "3" -> "12";
            case "#" -> "8"; // default if skipped
            default -> {
                System.out.println("Invalid input. Using default size 8\".");
                yield "8";
            }
        };

        List<Topping> allToppings = new ArrayList<>();

        // Meats
        for (String meat : meats) {
            if (askYesNo(scanner, "Add " + meat + " (1.00)?")) {
                boolean extra = askYesNo(scanner, "Add extra " + meat + " (+$1.00)?");
                allToppings.add(new Topping(meat, 1.00, extra));
            }
        }

        // Cheeses
        for (String cheese : cheeses) {
            if (askYesNo(scanner, "Add " + cheese + " (0.75)?")) {
                boolean extra = askYesNo(scanner, "Add extra " + cheese + " (+$0.75)?");
                allToppings.add(new Topping(cheese, 0.75, extra));
            }
        }

        // Regular toppings
        for (String top : toppings) {
            if (askYesNo(scanner, "Add " + top + "?")) {
                allToppings.add(new Topping(top, 0.0, false));
            }
        }

        // Sauces
        for (String sauce : sauces) {
            if (askYesNo(scanner, "Add " + sauce + "?")) {
                allToppings.add(new Topping(sauce, 0.0, false));
            }
        }

        boolean toasted = askYesNo(scanner, "Would you like it toasted?");
        return new Sandwich(size, bread, allToppings, toasted);
    }

    private static String promptCategory(Scanner scanner, String label, String[] options, boolean allowCancel) {
        while (true) {
            System.out.println(label);
            for (int i = 0; i < options.length; i++) {
                System.out.printf("%d) %s%n", i + 1, options[i]);
            }
            if (allowCancel) {
                System.out.println("#) Skip\nZ) Cancel Order");
            }

            System.out.print("Enter your choice: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("Z")) {
                System.out.println("❌ Order canceled.");
                return null;
            }
            if (input.equalsIgnoreCase("#")) return options[0]; // default bread
            try {
                int num = Integer.parseInt(input);
                if (num >= 1 && num <= options.length) return options[num - 1];
            } catch (NumberFormatException ignored) {}
            System.out.println("Invalid input. Try again.");
        }
    }

    private static boolean askYesNo(Scanner scanner, String prompt) {
        System.out.print(prompt + " (yes/no): ");
        return scanner.nextLine().equalsIgnoreCase("yes");
    }
}
