import java.util.Scanner;

public class OrderUtils {

    public static Sandwich createSandwich(Scanner scanner) {
        return SandwichBuilder.build(scanner);
    }

    public static Drink createDrink(Scanner scanner) {
        System.out.print("Enter drink size (small/medium/large): ");
        String size = scanner.nextLine();
        System.out.print("Enter flavor: ");
        String flavor = scanner.nextLine();
        return new Drink(size, flavor);
    }

    public static Chips createChips(Scanner scanner) {
        System.out.print("Enter chip flavor: ");
        String flavor = scanner.nextLine();
        return new Chips(flavor);
    }
}
