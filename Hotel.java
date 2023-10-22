import java.util.*;

import HMS.EasyPrint;
import HMS.UtilityFunctions;

public class Hotel {
    Vector<Object> customers;
    Vector<Vector<Object>> rooms;
    Vector<Object> reservations;

    static EasyPrint ep = new EasyPrint();

    Hotel(int floors) {
        customers = new Vector<Object>();
        rooms = new Vector<Vector<Object>>();
        reservations = new Vector<Object>();

        for (int i = 0; i < floors; i++) {
            rooms.add(new Vector<Object>());
        }
    }

    public static void main(String args[]) {
        Hotel hotel = new Hotel(7);
        UtilityFunctions.cls();
        while (true) {
            UtilityFunctions.cls();
            hotel.run();
        }
    }

    public void run() {
        ep.print("Welcome to the Hotel Management System!");
        ep.print("Please select an option:");
        ep.print("1. Add a new room");
        ep.print("2. Add a new customer");
        ep.print("3. Check-in a customer");
        ep.print("4. Check-out a customer");
        ep.print("5. Display all rooms");
        ep.print("6. Display all customers");
        ep.print("7. Exit");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        UtilityFunctions.cls();

        switch (choice) {
            case 1:
                Room room = Room.createRoom();
                addRoom(room);
                break;
            case 2:
                addCustomer();
                break;
            case 3:
                Reservation reservation = Reservation.createReservation(customers, rooms);
                // checkInCustomer(reservation.customer);
                break;
            case 4:
                Customer customerObj = null;
                ep.print("Enter the customer id: ");
                int id = sc.nextInt();

                for (Object customer1 : customers) {
                    Customer customer2 = (Customer) customer1;
                    if (customer2.id == id) {
                        customerObj = customer2;
                        break;
                    }
                }
                // checkOutCustomer(customerObj);
                break;

            case 5:
                showRooms();
                break;

            case 6:
                showCustomers();
                break;

            default:
                ep.print("Invalid choice!");
                break;
        }
    }

    /**
     * This function will be used to add a new room to the hotel.
     * 
     * @param room The room to be added.
     */
    public void addRoom(Room room) {
        int floorNumber = room.floorNumber;
        if (floorNumber > rooms.size()) {
            ep.print("Floor number does not exist!");
            return;
        }
        Vector<Object> floor = rooms.get(floorNumber - 1);
        floor.add(room);
        ep.print("Room added successfully!");
    }

    /**
     * This function will be used to add a new customer to the hotel.
     */

    public void addCustomer() {
        Customer n = Customer.createCustomer();
        customers.add(n);
        ep.print("Customer added successfully!");

        // sort customer by debt
        UtilityFunctions.sortVector(customers, (guest) -> {
            Customer customer = (Customer) guest;
            return (float) customer.dues;
        }, true);

        ep.print("Customer added successfully!");
    }

    /**
     * This function will be used to a new room to the hotel.
     */
    public void addRoom() {
        Room n = Room.createRoom();
        addRoom(n);
        ep.print("Room added successfully!");
    }

    /*
     * Show all customers
     */
    public void showCustomers() {
        ep.print("Customers: ");
        for (Object customer : customers) {
            Customer customer1 = (Customer) customer;
            customer1.print();
            ep.print("-------------------------------\n");
        }
        UtilityFunctions.waitForEnter();
    }

    /*
     * Show all rooms
     */

    public void showRooms() {
        ep.print("Rooms: ");
        for (Vector<Object> floor : rooms) {
            for (Object room : floor) {
                Room room1 = (Room) room;
                room1.print();
                ep.print("-------------------------------\n");
            }
        }
        UtilityFunctions.waitForEnter();
    }

}
