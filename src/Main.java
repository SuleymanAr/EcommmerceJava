import com.ecommerce.Customer;
import com.ecommerce.Product;
import com.ecommerce.orders.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Product> productList = new ArrayList<>();
        List<Customer> customerList = new ArrayList<>();

        while (true) {
        	
        	//New
            System.out.println("\n1. Create a customer");
            System.out.println("2. Create a product");
            System.out.println("3. Add product to customer's cart");
            System.out.println("4. Place order");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter customer ID (integer): ");
                    while (!scanner.hasNextInt()) {
                        System.out.print("Invalid input. Enter customer ID (integer): ");
                        scanner.next();
                    }
                    int customerID = scanner.nextInt();
                    scanner.nextLine(); 

                    System.out.print("Enter customer name: ");
                    String customerName = scanner.nextLine();

                    Customer customer = new Customer(String.valueOf(customerID), customerName);
                    customerList.add(customer);
                    System.out.println("Customer created: " + customer);
                    break;

                case 2:
                    System.out.print("Enter product ID (integer): ");
                    while (!scanner.hasNextInt()) {
                        System.out.print("Invalid input. Enter product ID (integer): ");
                        scanner.next();
                    }
                    int productID = scanner.nextInt();
                    scanner.nextLine(); 

                    System.out.print("Enter product name: ");
                    String productName = scanner.nextLine();

                    System.out.print("Enter product price (decimal): ");
                    while (!scanner.hasNextDouble()) {
                        System.out.print("Invalid input. Enter product price (decimal): ");
                        scanner.next();
                    }
                    double productPrice = scanner.nextDouble();
                    scanner.nextLine(); 

                    Product product = new Product(String.valueOf(productID), productName, productPrice);
                    productList.add(product);
                    System.out.println("Product created: " + product);
                    break;

                case 3:
                    if (customerList.isEmpty()) {
                        System.out.println("No customers available. Please create a customer first.");
                        break;
                    }
                    if (productList.isEmpty()) {
                        System.out.println("No products available. Please create products first.");
                        break;
                    }
                    System.out.println("Available customers:");
                    for (int i = 0; i < customerList.size(); i++) {
                        System.out.println((i + 1) + ". " + customerList.get(i));
                    }
                    System.out.print("Enter the customer number to add product to cart: ");
                    while (!scanner.hasNextInt()) {
                        System.out.print("Invalid input. Enter the customer number to add product to cart: ");
                        scanner.next();
                    }
                    int customerNumber = scanner.nextInt();
                    scanner.nextLine(); 

                    if (customerNumber < 1 || customerNumber > customerList.size()) {
                        System.out.println("Invalid customer number.");
                        break;
                    }
                    Customer selectedCustomer = customerList.get(customerNumber - 1);

                    System.out.println("Available products:");
                    for (int i = 0; i < productList.size(); i++) {
                        System.out.println((i + 1) + ". " + productList.get(i));
                    }
                    System.out.print("Enter the product number to add to cart: ");
                    while (!scanner.hasNextInt()) {
                        System.out.print("Invalid input. Enter the product number to add to cart: ");
                        scanner.next();
                    }
                    int productNumber = scanner.nextInt();
                    scanner.nextLine(); 

                    if (productNumber < 1 || productNumber > productList.size()) {
                        System.out.println("Invalid product number.");
                        break;
                    }
                    selectedCustomer.addToCart(productList.get(productNumber - 1));
                    System.out.println("Product added to cart for customer: " + selectedCustomer);
                    break;

                case 4:
                    if (customerList.isEmpty()) {
                        System.out.println("No customers available. Please create a customer first.");
                        break;
                    }
                    System.out.println("Available customers:");
                    for (int i = 0; i < customerList.size(); i++) {
                        System.out.println((i + 1) + ". " + customerList.get(i));
                    }
                    System.out.print("Enter the customer number to place an order: ");
                    while (!scanner.hasNextInt()) {
                        System.out.print("Invalid input. Enter the customer number to place an order: ");
                        scanner.next();
                    }
                    customerNumber = scanner.nextInt();
                    scanner.nextLine(); 

                    if (customerNumber < 1 || customerNumber > customerList.size()) {
                        System.out.println("Invalid customer number.");
                        break;
                    }
                    selectedCustomer = customerList.get(customerNumber - 1);

                    if (selectedCustomer.getShoppingCart().isEmpty()) {
                        System.out.println("Shopping cart is empty. Please add products to the cart first.");
                        break;
                    }
                    Order order = new Order("O001", selectedCustomer, new ArrayList<>(selectedCustomer.getShoppingCart()));
                    System.out.println("Order placed successfully for customer: " + selectedCustomer);
                    System.out.println("Order Summary:");
                    System.out.println(order.generateOrderSummary());
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
