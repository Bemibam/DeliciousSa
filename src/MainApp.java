import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n\u001B[36m=== 🥪 Welcome to DELI-cious! ===\u001B[0m");
            System.out.println("1) 🧾 New Order");
            System.out.println("0) ❌ Exit");
            System.out.print("👉 Select an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                    Order order = new Order();
                    System.out.println("1) 🍽️ Dine-in\n2) 🛍️ Takeout");
                    System.out.print("👉 Enter your choice: ");
                    order.setOrderType(scanner.nextLine());

                    boolean ordering = true;
                    while (ordering) {
                        System.out.println("\n🍽️ Order Menu:");
                        System.out.println("1) 🥪 Add Custom Sandwich");
                        System.out.println("2) 🥤 Add Drink");
                        System.out.println("3) 🍟 Add Chips");
                        System.out.println("4) ⭐ Add Signature Sandwich");
                        System.out.println("5) ✅ Checkout");
                        System.out.println("0) ❌ Cancel Order");
                        System.out.print("👉 Select an option: ");
                        switch (scanner.nextLine()) {
                            case "1" -> order.addItem(OrderUtils.createSandwich(scanner));
                            case "2" -> order.addItem(OrderUtils.createDrink(scanner));
                            case "3" -> order.addItem(OrderUtils.createChips(scanner));
                            case "4" -> {
                                System.out.println("1) BLT  2) Philly Cheese  3) Veggie Delight");
                                System.out.print("Choose (1–3): ");
                                String choiceSig = scanner.nextLine();
                                switch (choiceSig) {
                                    case "1" -> order.addItem(new SignatureSandwich("blt"));
                                    case "2" -> order.addItem(new SignatureSandwich("philly cheese"));
                                    case "3" -> order.addItem(new SignatureSandwich("veggie delight"));
                                }
                            }
                            case "5" -> {
                                System.out.println(order.getSummary());
                                System.out.print("🧾 Confirm order? (yes/no): ");
                                if (scanner.nextLine().equalsIgnoreCase("yes")) {
                                    order.saveReceipt();
                                    System.out.println("Order placed! ✅");
                                }
                                ordering = false;
                            }
                            case "0" -> {
                                System.out.println("🗑️ Order canceled.");
                                ordering = false;
                            }
                            default -> System.out.println("❌ Invalid input.");
                        }
                    }
                }
                case "0" -> {
                    System.out.println("👋 Thank you for visiting DELI-cious!");
                    running = false;
                }
                default -> System.out.println("❌ Invalid input.");
            }
        }
        scanner.close();
    }
}
