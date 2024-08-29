public class Customer {
    private int customerId;
    private String name;
    private String address;
    private static int lastID = 1000;


    public Customer(String name, String address) {
        lastID++;
        this.customerId = lastID;
        this.name = name;
        this.address = address;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void displayCustomerInfo() {
        System.out.println("Customer ID: " + customerId);
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
    }
}