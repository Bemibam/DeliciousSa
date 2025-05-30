import java.util.*;

public class SandwichBuilder {
    private static final Map<String, List<String>> toppingOptions = Map.of(
            "Meats", List.of("Steak", "Ham", "Salami", "Roast Beef", "Chicken", "Bacon"),
            "Cheese", List.of("American", "Provolone", "Cheddar", "Swiss"),
            "Toppings", List.of("Lettuce", "Peppers", "Onions", "Tomatoes", "Jalapeños", "Cucumbers", "Pickles", "Guacamole", "Mushrooms"),
            "Sauces", List.of("Mayo", "Mustard", "Ketchup", "Ranch", "Thousand Islands", "Vinaigrette")
    );

    private static final List<String> breads = List.of("White", "Wheat", "Rye", "Wrap");

    public static Sandwich build(Scanner scanner) {
        String size = chooseSize(scanner);
        Bread bread = chooseBread(scanner, size);
        List<Topping> toppings = chooseToppings(scanner, size);
        boolean toasted = askYesNo(scanner, "Would you like it toasted?");
        return new Sandwich(size, bread, toppings, toasted);
    }

    private static String chooseSize(Scanner scanner) {
        System.out.println("\n\u001B[35mSelect sandwich size:\u001B[0m");
        System.out.println("1) 4\"   2) 8\"   3) 12\"");
        String input = scanner.nextLine();
        return switch (input) {
            case "1" -> "4";
            case "2" -> "8";
            case "3" -> "12";
            default -> "8";
        };
    }

    private static Bread chooseBread(Scanner scanner, String size) {
        System.out.println("\n\u001B[34mSelect Bread:\u001B[0m");
        for (int i = 0; i < breads.size(); i++) {
            System.out.println((i + 1) + ") " + breads.get(i));
        }
        System.out.print("Choose a number (# to skip, Z to cancel): ");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("Z")) return null;

        int index = input.equals("#") ? 0 : Integer.parseInt(input) - 1;
        double price = switch (size) {
            case "4" -> 5.50;
            case "8" -> 7.00;
            case "12" -> 8.50;
            default -> 7.00;
        };
        return new Bread(breads.get(index), price);
    }

    private static List<Topping> chooseToppings(Scanner scanner, String size) {
        List<Topping> all = new ArrayList<>();
        for (Map.Entry<String, List<String>> category : toppingOptions.entrySet()) {
            System.out.println("\n\u001B[33m" + category.getKey() + ":\u001B[0m");
            List<String> items = category.getValue();
            for (int i = 0; i < items.size(); i++) {
                System.out.printf("%d) %s%n", i + 1, items.get(i));
            }
            for (int i = 0; i < items.size(); i++) {
                String item = items.get(i);
                if (askYesNo(scanner, "Add " + item + "?")) {
                    boolean isExtra = askYesNo(scanner, "Extra " + item + "?");
                    double price = getPriceByType(category.getKey(), size, isExtra);
                    all.add(new Topping(item, price, isExtra));
                }
            }
        }
        return all;
    }

    private static double getPriceByType(String type, String size, boolean extra) {
        double multiplier = switch (size) {
            case "4" -> 1.0;
            case "8" -> 2.0;
            case "12" -> 3.0;
            default -> 1.0;
        };
        return switch (type) {
            case "Meats" -> extra ? multiplier * 0.5 : multiplier * 1.0;
            case "Cheese" -> extra ? multiplier * 0.3 : multiplier * 0.75;
            default -> 0.0;
        };
    }

    private static boolean askYesNo(Scanner scanner, String prompt) {
        System.out.print(prompt + " (yes/no): ");
        return scanner.nextLine().equalsIgnoreCase("yes");
    }

    public static Drink selectDrink(Scanner scanner) {
        List<String> flavors = List.of("Cola", "Lemonade", "Iced Tea", "Root Beer");
        System.out.println("\n\u001B[36mAvailable Drinks:\u001B[0m");
        System.out.println("1) Small   2) Medium   3) Large");
        System.out.print("Choose size: ");
        String size = switch (scanner.nextLine()) {
            case "1" -> "small";
            case "2" -> "medium";
            case "3" -> "large";
            default -> "small";
        };

        for (int i = 0; i < flavors.size(); i++) {
            System.out.println((i + 1) + ") " + flavors.get(i));
        }
        System.out.print("Choose drink: ");
        String flavor = flavors.get(Integer.parseInt(scanner.nextLine()) - 1);
        return new Drink(size, flavor);
    }

    public static Chips selectChips(Scanner scanner) {
        List<String> chips = List.of("BBQ", "Sour Cream", "Salt & Vinegar", "Jalapeño", "Lays Classic");
        System.out.println("\n\u001B[36mAvailable Chips Flavors:\u001B[0m");
        for (int i = 0; i < chips.size(); i++) {
            System.out.println((i + 1) + ") " + chips.get(i));
        }
        System.out.print("Choose a number (0 to skip): ");
        String input = scanner.nextLine();
        if (input.equals("0")) return null;
        return new Chips(chips.get(Integer.parseInt(input) - 1));
    }
}
