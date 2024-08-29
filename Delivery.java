public class Delivery {
    private int deliveryId;
    private String itemName;
    private double itemWeight;
    private Customer customer;
    private boolean isDelivered;
    private static int lastID = 1000;

    public Delivery(String itemName, double itemWeight, Customer customer) {
        this.deliveryId = lastID ++;
        this.itemName = itemName;
        this.itemWeight = itemWeight;
        this.customer = customer;
        this.isDelivered = false;
    }

    public int getDeliveryId() {
        return deliveryId;
    }

    public String getItemName() {
        return itemName;
    }

    public double getItemWeight() {
        return itemWeight;
    }

    public Customer getCustomer() {
        return customer;
    }

    public boolean isDelivered() {
        return isDelivered;
    }

    public void markAsDelivered() {
        this.isDelivered = true;
    }

    public void displayDeliveryInfo() {
        System.out.println("Delivery ID: " + deliveryId);
        System.out.println("Item Name: " + itemName);
        System.out.println("Item Weight: " + itemWeight + " kg");
        System.out.println("Customer Name: " + customer.getName());
        System.out.println("Delivery Status: " + (isDelivered ? "Delivered" : "Pending"));
    }
}