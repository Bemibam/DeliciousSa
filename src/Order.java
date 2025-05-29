import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Order {
    private static final double TAX_RATE = 0.10;
    private List<MenuProduct> items = new ArrayList<>();
    private String orderType = "Dine-in";

    public void setOrderType(String type) {
        if (type.equalsIgnoreCase("1")) this.orderType = "Dine-in";
        else if (type.equalsIgnoreCase("2")) this.orderType = "Takeout";
    }

    public void addItem(MenuProduct item) {
        items.add(item);
    }

    public double getSubtotal() {
        return items.stream().mapToDouble(MenuProduct::getPrice).sum();
    }

    public double getTax() {
        return getSubtotal() * TAX_RATE;
    }

    public double getTotal() {
        return getSubtotal() + getTax();
    }

    public String getSummary() {
        StringBuilder sb = new StringBuilder();
        sb.append("\u001B[36m=== 🧾 New Order Summary ===\u001B[0m\n");
        sb.append("Order Type: ").append(orderType).append("\n");
        sb.append("Time: ").append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))).append("\n\n");
        for (MenuProduct item : items) {
            sb.append("- ").append(item.getDescription()).append(" [$")
                    .append(String.format("%.2f", item.getPrice())).append("]\n");
        }
        sb.append("\nSubtotal: $").append(String.format("%.2f", getSubtotal())).append("\n");
        sb.append("Tax (10%): $").append(String.format("%.2f", getTax())).append("\n");
        sb.append("Total: $").append(String.format("%.2f", getTotal())).append("\n");
        sb.append("Estimated Wait Time: 10–15 minutes\n");
        return sb.toString();
    }

    public void saveReceipt() {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
        Path dir = Paths.get("receipts");
        Path file = dir.resolve("receipt-" + timestamp + ".txt");

        try {
            Files.createDirectories(dir);
            Files.write(file, getSummary().getBytes());
            System.out.println("✅ Receipt saved to: " + file);
        } catch (IOException e) {
            System.out.println("❌ Error saving receipt: " + e.getMessage());
        }
    }
}
