import java.util.ArrayList;
import java.util.List;

class DeliveryOrder {
    private String itemName;
    private String itemVersion;
    private String orderDate;
    private double price;
    private double bill;
    private String customer;

    public DeliveryOrder(String itemName, String itemVersion, String orderDate, double price, double bill, String customer) {
        
        this.itemName = itemName;
        this.itemVersion = itemVersion;
        this.orderDate = orderDate;
        this.price = price;
        this.bill = bill;
        this.customer = customer;
    }

    // Getters and setters
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemVersion() {
        return itemVersion;
    }

    public void setItemVersion(String itemVersion) {
        this.itemVersion = itemVersion;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
        this.bill = price;
    }

    public double getBill() {
        return bill;
    }

    public void setBill(double bill) {
        this.bill = bill;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }
}

class DeliverySystem {
    private List<DeliveryOrder> orders;

    public DeliverySystem() {
        this.orders = new ArrayList<>();
    }

    public void addOrder(DeliveryOrder order) {
        orders.add(order);
    }

    // basic logic for adding the deliveries on the system to print it out later.
    public void deliverOrder(String itemName, String customer) {
        for (DeliveryOrder order : orders) {
            if (order.getItemName().equals(itemName)) {
                System.out.println("Delivery " + order.getItemName() + " " + order.getItemVersion() + " to " + customer + " on " + order.getOrderDate() + " for  £ "+ order.getPrice());
                return;
            }
        }
        System.out.println("Delivery " + itemName + " not found");
    }

    public double TotalBill(String customer) {
        double total = 0;
        for (DeliveryOrder order : orders) {
            if (order.getBill()>0 && order.getCustomer().equals(customer)) {
                total = total + order.getBill();
            }
        }
        return total;
    }
}

public class Delivery {
    public static void main(String[] args) {
        // Create a new delivery system
        DeliverySystem deliverySystem = new DeliverySystem();

        // Create customers
        String john = "John";
        String margaret = "Margaret";

        // Add some delivery orders with associated customers
        deliverySystem.addOrder(new DeliveryOrder("Coffee", "Small", "2024-04-24", 2.00, 2.00, "John"));
        deliverySystem.addOrder(new DeliveryOrder("Croissant", "Small", "2024-04-24", 2.00, 2.00, "Margaret"));

        // Deliver orders to recipients
        deliverySystem.deliverOrder("Coffee", john);
        deliverySystem.deliverOrder("Croissant", margaret);

        // Calculate total bill for a customer
        double johnTotalBill = deliverySystem.TotalBill(john);
        System.out.println("Total bill for John: £" + johnTotalBill);
    }
}
