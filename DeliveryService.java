import java.util.ArrayList;

public class DeliveryService {

    private ArrayList<Customer> customers;
    private ArrayList<Delivery> deliveries;


    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public ArrayList<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(ArrayList<Delivery> deliveries) {
        this.deliveries = deliveries;
    }

    public DeliveryService(){
        this.customers = new ArrayList<>();
        this.deliveries = new ArrayList<>();
    }

    public Customer getCustomer(Integer id){
        for(var c: customers){
            if(c.getCustomerId() == id){
                return c;
            }
        }
        return null;
    }

    public Customer registerCustomer(String name, String address){
        Customer customer = new Customer(name, address);
        if(getCustomer(customer.getCustomerId()) == null) {
            customers.add(customer);
        //    System.out.println("Registration successful");
            return customer;
        }
      //  System.out.println("Registration impossible, ID exists");
        return null;
    }


    public void displayRegisteredCustomers(){
        System.out.println("Registered customers:");
        if(!customers.isEmpty()){
            for(var c: customers){
                c.displayCustomerInfo();
            }
        }
    }

    public Delivery getDelivery(int id){
        for(var d: deliveries){
            if(d.getDeliveryId() == id){
                return d;
            }
        }
        return null;
    }

    public Delivery placeDelivery(String itemName, double itemWeight, Customer customer){
        Delivery delivery = new Delivery(itemName, itemWeight, customer);
        if(getDelivery(delivery.getDeliveryId()) != null){
            deliveries.add(delivery);
            return delivery;
        }
        return null;
    }

   public void markDeliveryAsDelivered(String deliveryID){
       Delivery checkedDelivery = getDelivery(Integer.parseInt(deliveryID));
        if(checkedDelivery != null){
            checkedDelivery.markAsDelivered();
          //  System.out.println("Delivery successful");
        }
      // System.out.println("ID does not exist");
    }

    public void displayDeliveries(){
        System.out.println("Deliveries:");
        if(!deliveries.isEmpty()){
            for(var d: deliveries){
                d.displayDeliveryInfo();
            }
        }
    }

}
