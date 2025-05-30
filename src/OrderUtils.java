import java.util.Scanner;

public class OrderUtils {

    public static Sandwich createSandwich(Scanner scanner) {
        return SandwichBuilder.build(scanner);
    }

    public static Drink createDrink(Scanner scanner) {
        return SandwichBuilder.selectDrink(scanner);
    }

    public static Chips createChips(Scanner scanner) {
        return SandwichBuilder.selectChips(scanner);
    }
}
