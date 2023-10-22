import java.util.*;
public class Customer {
    String name;
    int dues;
    int id;
    Vector<Object> reservations;
    Customer(String name, int bal, int id) {
        this.name = name;
        this.dues = bal;
        this.id = id;
        reservations = new Vector<Object>();
    }

    public static Customer createCustomer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the customer:");
        String name = sc.nextLine();
        System.out.println("Enter the dues of the customer, if any:");
        int dues = sc.nextInt();
        System.out.println("Enter the id of the customer:");
        int id = sc.nextInt();
        Customer customer = new Customer(name, dues, id);
        return customer;
    }

    public void print() {
        System.out.println("Name: " + name);
        System.out.println("Dues: " + dues);
        System.out.println("ID: " + id);
    }
}
