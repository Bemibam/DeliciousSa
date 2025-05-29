import java.util.Scanner;

public class OrderUtils {

    public static Sandwich createSandwich(Scanner scanner) {
        return SandwichBuilder.build(scanner);
    }

    public static Drink createDrink(Scanner scanner) {
        System.out.print("Drink size (small/medium/large): ");
        String size = scanner.nextLine();
        System.out.print("Drink flavor: ");
        String flavor = scanner.nextLine();
        return new Drink(size, flavor);
    }

    public static Chips createChips(Scanner scanner) {
        System.out.print("Chip flavor: ");
        String flavor = scanner.nextLine();
        return new Chips(flavor);
    }
}
