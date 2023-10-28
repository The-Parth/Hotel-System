import java.util.*;

import HMS.Inputs;
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
        String name = Inputs.getString("Enter the name of the customer: ");
        int dues = Inputs.getInt("Enter the dues of the customer, if any: ");
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

    public void addDues(int dues) {
        this.dues += dues;
    }
}
