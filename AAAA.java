import java.util.*;
import HMS.*;
import HMS.EasyPrint;

/**
 * Hotel Management System: The objective of this project is to create a
 * comprehensive Hotel Management System
 * that offers a user-friendly system, optimizing the hotel's operational
 * efficiency and ensuring a seamless
 * experience for both staff and guests. This system will facilitate the
 * management of guest reservations,
 * room allocation, billing, and additional services. It will also enable
 * housekeeping tasks, ensuring the
 * overall satisfaction of guests during their stay. The system will provide
 * reporting and analytics features for
 * hotel managers to track occupancy rates, revenue, and maintenance logs.
 */
public class AAAA {

    /**
     * The list of all the rooms in the hotel.
     */
    private Vector<Vector<Object>> rooms; // Vector<Room>, the main vector will have some number of sub-vectors, each
                                          // sub-vector representing a floor.
    static EasyPrint ep = new EasyPrint();
    private Vector<Object> customers; // Vector<Customer>
    private Vector<Object> reservations; // Vector<Reservation>

    AAAA() {

    }

    public static void main(String[] args) {
        AAAA hotel = new AAAA();
        hotel.run();
    }

    public void run() {
        customers = new Vector<Object>();
        rooms = new Vector<Vector<Object>>();
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

        switch(choice) {
            case 1:
                Room room = Room.createRoom();
                ep.print(room.roomNumber);
                addRoom(room);
                break;
            case 2:
                Customer customer = Customer.createCustomer();
                addCustomer(customer);
                break;
            case 3:
                Reservation reservation = Reservation.createReservation(customers, rooms);
                checkInCustomer(reservation.customer);
                break;
            case 4:
                Customer customerObj= null;
                ep.print("Enter the customer id: ");
                int id = sc.nextInt();

                for (Object customer1 : customers) {
                    Customer customer2 = (Customer) customer1;
                    if (customer2.id == id) {
                        customerObj = customer2;
                        break;
                    }
                }
                checkOutCustomer(customerObj);
                break;


            case 5:
                displayAllRooms();
                break;
            case 6:
                displayAllCustomers();
                break;
            case 7:
                System.exit(0);
                break;
            default:
                ep.print("Invalid choice!");
                break;
        }

        run();  

        
    }
    /**
     * This function will be used to add a new room to the hotel.
     * 
     * @param room The room to be added.
     */
    public void addRoom(Room room) {
        int floor = room.floorNumber;
        while (floor > rooms.size()) {
            // Add new floor
            System.out.println("AHH");
            Vector<Object> newFloor = new Vector<Object>();
            rooms.add(newFloor);
        }
        // Add to existing floor
        Vector<Object> floorVector = rooms.get(floor - 1);
        // Check if room already exists
        for (Object room1 : floorVector) {
            Room room2 = (Room) room1;
            if (room2.roomNumber == room.roomNumber) {
                ep.print("Room already exists!");
                ep.print("Room number: " + room.roomNumber);
                ep.print("NOT adding room!");
                return;
            }
        }

        UtilityFunctions.sortVector(floorVector, (sortByFunction) -> {
            Room room1 = (Room) sortByFunction;
            return (float) room1.roomNumber;
        });

        ep.print("Room added successfully!");
    }

    /**
     * This function will be used to add a new customer to the hotel.
     * 
     * @param customer The customer to be added.
     */
    public void addCustomer(Customer customer) {
        customers.add(customer);
        ep.print("Customer added successfully!");
    }

    /**
     * This function will be used to check-in a customer to the hotel.
     * 
     * @param customer The customer to be checked-in.
     */
    public void checkInCustomer(Customer customer) {
        reservations.add(customer);
        ep.print("Customer checked-in successfully!");
    }

    /**
     * This function will be used to check-out a customer from the hotel.
     * 
     * @param customer The customer to be checked-out.
     */

    public void checkOutCustomer(Customer customer) {
        reservations.remove(customer);
        ep.print("Customer checked-out successfully!");
    }

    /**
     * This function will be used to display all the rooms in the hotel.
     */

    public void displayAllRooms() {
        ep.print("Displaying all rooms:");
        System.out.println(rooms.size());

        for (Vector<Object> floor : rooms) {
            for (Object room : floor) {
                Room room1 = (Room) room;
                ep.print("Room number: " + room1.roomNumber);
                ep.print("Floor number: " + room1.floorNumber);
                ep.print("Capacity: " + room1.capacity);
                ep.print("Price: " + room1.price);
            }
        }

    }

    /**
     * This function will be used to display all the customers in the hotel.
     */
    public void displayAllCustomers() {
        ep.print("Displaying all customers:");
        for (Object customer : customers) {
            Customer customer1 = (Customer) customer;
            ep.print("Name: " + customer1.name);
            ep.print("Dues: " + customer1.dues);
            ep.print("ID: " + customer1.id);
        }
    }

    /**
     * This function will be used to display all the reservations in the hotel.
     */
    public void displayAllReservations() {
        ep.print("Displaying all reservations:");
        for (Object reservation : reservations) {
            Reservation reservation1 = (Reservation) reservation;
            ep.print("Customer name: " + reservation1.customer.name);
            ep.print("Room number: " + reservation1.room.roomNumber);
            ep.print("Floor number: " + reservation1.room.floorNumber);
            ep.print("Price: " + reservation1.price);
        }
    }



}