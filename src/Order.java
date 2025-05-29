import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Order {
    private static final double TAX_RATE = 0.10;
    private List<MenuProduct> items = new ArrayList<>();

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
        StringBuilder sb = new StringBuilder("🧾 Order Summary:\n");
        for (MenuProduct item : items) {
            sb.append("- ").append(item.getDescription()).append(" [$").append(String.format("%.2f", item.getPrice())).append("]\n");
        }
        sb.append("Subtotal: $").append(String.format("%.2f", getSubtotal())).append("\n");
        sb.append("Tax (10%): $").append(String.format("%.2f", getTax())).append("\n");
        sb.append("Total: $").append(String.format("%.2f", getTotal())).append("\n");
        return sb.toString();
    }

    public void saveReceipt() {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
        Path receiptsDir = Paths.get("receipts");
        Path filePath = receiptsDir.resolve("receipt-" + timestamp + ".txt");

        try {
            Files.createDirectories(receiptsDir);
            Files.write(filePath, getSummary().getBytes());
            System.out.println("✅ Receipt saved to: " + filePath);
        } catch (IOException e) {
            System.out.println("❌ Error saving receipt: " + e.getMessage());
        }
    }
}
