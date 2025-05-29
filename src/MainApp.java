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

                    System.out.println("\n🏷️ Order Type:");
                    System.out.println("1) 🍽️ Dine-in");
                    System.out.println("2) 🛍️ Takeout");
                    System.out.print("👉 Enter your choice: ");
                    String typeChoice = scanner.nextLine();
                    if (typeChoice.equals("1")) {
                        order.setOrderType("Dine-in");
                    } else if (typeChoice.equals("2")) {
                        order.setOrderType("Takeout");
                    } else {
                        System.out.println("❌ Invalid input. Defaulting to Takeout.");
                        order.setOrderType("Takeout");
                    }

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
                            case "1" -> order.addItem(OrderUtils.createSandwich(scanner));
                            case "2" -> order.addItem(OrderUtils.createDrink(scanner));
                            case "3" -> order.addItem(OrderUtils.createChips(scanner));
                            case "4" -> {
                                System.out.println("\n⭐ Signature Sandwiches:");
                                System.out.println("1) 🥓 BLT");
                                System.out.println("2) 🧀 Philly Cheese");
                                System.out.println("3) 🥬 Veggie Delight");
                                System.out.print("👉 Enter your choice (1-3, # to skip, z to cancel): ");
                                String type = scanner.nextLine();

                                switch (type) {
                                    case "1" -> order.addItem(new SignatureSandwich("blt"));
                                    case "2" -> order.addItem(new SignatureSandwich("philly cheese"));
                                    case "3" -> order.addItem(new SignatureSandwich("veggie delight"));
                                    case "#" -> System.out.println("⏭️ Skipped.");
                                    case "z" -> {
                                        System.out.println("❌ Canceled Signature Sandwich.");
                                        break;
                                    }
                                    default -> System.out.println("❌ Invalid input.");
                                }
                            }
                            case "5" -> {
                                System.out.println(order.getSummary());
                                System.out.print("🧾 Confirm order? (yes/no): ");
                                if (scanner.nextLine().equalsIgnoreCase("yes")) {
                                    order.saveReceipt();
                                    System.out.println("⏳ Estimated Wait Time: 10–15 minutes");
                                }
                                ordering = false;
                            }
                            case "0" -> {
                                System.out.println("🗑️ Order canceled.");
                                ordering = false;
                            }
                            default -> System.out.println("❌ Invalid input. Please try again.");
                        }
                    }
                }
                case "0" -> {
                    System.out.println("👋 Thank you for visiting DELI-cious. Goodbye!");
                    running = false;
                }
                default -> System.out.println("❌ Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}
