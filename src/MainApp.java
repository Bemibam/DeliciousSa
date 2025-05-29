import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== 🥪 Welcome to DELI-cious! ===");
            System.out.println("1) 🧾 New Order");
            System.out.println("0) ❌ Exit");
            System.out.print("👉 Select an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    Order order = new Order();
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
                        String option = scanner.nextLine();

                        switch (option) {
                            case "1":
                                order.addItem(OrderUtils.createSandwich(scanner));
                                break;
                            case "2":
                                order.addItem(OrderUtils.createDrink(scanner));
                                break;
                            case "3":
                                order.addItem(OrderUtils.createChips(scanner));
                                break;
                            case "4":
                                System.out.println("Available Signature Sandwiches: 🥓 BLT, 🧀 Philly Cheese, 🥬 Veggie Delight");
                                System.out.print("Enter your choice: ");
                                String type = scanner.nextLine();
                                order.addItem(new SignatureSandwich(type));
                                break;
                            case "5":
                                System.out.println(order.getSummary());
                                System.out.print("Confirm order? (yes/no): ");
                                if (scanner.nextLine().equalsIgnoreCase("yes")) {
                                    order.saveReceipt();
                                }
                                ordering = false;
                                break;
                            case "0":
                                ordering = false;
                                break;
                            default:
                                System.out.println("❌ Invalid input. Please try again.");
                        }
                    }
                    break;
                case "0":
                    System.out.println("👋 Thank you for visiting DELI-cious. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("❌ Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}
