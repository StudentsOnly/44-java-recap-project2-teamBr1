import java.util.Scanner;

public class Main {

        private static Scanner scanner = new Scanner(System.in);
        private static DeliveryService deliveryService = new DeliveryService();

        public static void main(String[] args) {

                boolean flag = true;
                while (flag) {
                        try {
                                displayMenu();
                                String input = scanner.nextLine().trim();
                                System.out.println();
                                switch (input.substring(0,1)) {
                                        case "1" -> registerCustomer();
                                        case "2" -> displayCustomers();
                                        case "3" -> placeDelivery();
                                        case "4" -> displayDeliveries();
                                        case "5" -> markDeliveryAsDelivered();
                                        case "6" -> flag = false;
                                        default -> {}
                                }
                                System.out.println();
                        } catch (Exception e) {
                                System.out.println("Exception caught in user-interactive loop: " + e.getMessage());
                        }
                }
                scanner.close();
        }

        private static void displayMenu() {
                String menu = """
                        MENU
                        ---------------
                        1 Customer Registration
                        2 Displaying Customers
                        3 Placing deliveries
                        4 Displaying deliveries
                        5 Marking deliveries as delivered
                        6 Exit
                        
                        Select operation:\s""";

                System.out.print(menu);
        }

        private static void registerCustomer() {
                try {
                        System.out.print("Please enter the name of the customer: ");
                        String name = scanner.nextLine().trim();

                        System.out.print("Please enter the address of the customer: ");
                        String address = scanner.nextLine().trim();

                        deliveryService.registerCustomer(name, address);
                        System.out.println("Customer registered successfully.");
                } catch (Exception e) {
                        System.out.println("Exception in registerCustomer: " + e.getMessage());
                }
        }
        private static void displayCustomers() {
                try {
                        deliveryService.displayRegisteredCustomers();
                } catch (Exception e) {
                        System.out.println("Exception in displayCustomers: " + e.getMessage());
                }
        }
        private static void placeDelivery() {

                try {
                        System.out.print("Please enter customer ID: ");
                        int customerID = Integer.parseInt(scanner.nextLine().trim());
                        Customer customer = deliveryService.getCustomer(customerID);
                        if (customer == null) {
                                System.out.println("Customer not found.");
                                return;
                        }

                        System.out.print("Please enter item name: ");
                        String itemName = scanner.nextLine().trim();

                        System.out.print("Please enter item weight in kilograms: ");
                        double itemWeight = Double.parseDouble(scanner.nextLine().trim());

                        deliveryService.placeDelivery(itemName, itemWeight, customer);
                } catch (NumberFormatException e) {
                        System.out.println("Invalid number format: " + e.getMessage());
                } catch (NullPointerException e) {
                        System.out.println("Error: A required object was not found: " + e.getMessage());
                } catch (Exception e) {
                        System.out.println("Exception in placeDelivery: " + e.getMessage());
                }
        }
        private static void displayDeliveries() {

                try {
                        deliveryService.displayDeliveries();
                } catch (Exception e) {
                        System.out.println("Exception in displayDeliveries: " + e.getMessage());
                }
        }
        private static void markDeliveryAsDelivered() {

                        displayDeliveries();

                try {
                        System.out.println("Please enter the delivery ID to mark it as delivered: ");
                        String deliveryID = scanner.nextLine().trim();
                        deliveryService.markDeliveryAsDelivered(deliveryID);
                } catch (Exception e) {
                        System.out.println("Exception in markDeliveryAsDelivered: " + e.getMessage());
                }
        }

}
