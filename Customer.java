import java.util.*;
public class Customer {
    String name;
    int dues;
    static int id_counter = 0;
    int id;
    Reservation reservation;
    Customer(String name, int bal) {
        this.name = name;
        this.dues = bal;
        this.id = ++id_counter;
        reservation = null;
    }

    public static Customer createCustomer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the customer:");
        String name = sc.nextLine();
        System.out.println("Enter the dues of the customer, if any:");
        int dues = sc.nextInt();
        Customer customer = new Customer(name, dues);
        return customer;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public void print() {
        System.out.println("Name: " + name);
        System.out.println("Dues: " + dues);
        System.out.println("ID: " + id);
        if (reservation != null) {
            System.out.println("Reservation: ");
            reservation.printMinimal();
        }

    }
}
