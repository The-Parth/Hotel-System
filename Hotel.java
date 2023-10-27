import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import HMS.EasyPrint;
import HMS.UtilityFunctions;


public class Hotel implements HotelInterface {
    Vector<Customer> customers;
    Vector<Vector<Room>> rooms;
    Vector<Reservation> reservations;

    static EasyPrint ep = new EasyPrint();

    Hotel(int floors) {
        customers = new Vector<Customer>();
        rooms = new Vector<Vector<Room>>();
        reservations = new Vector<Reservation>();

        for (int i = 0; i < floors; i++) {
            rooms.add(new Vector<Room>());
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
        ep.print("7. Advance a day");
        ep.print("8. Exit");
        ep.print("Enter your choice: ");
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
                Customer customers = searchCustomer();
                Reservation reservation = Reservation.createReservation(customers, rooms);
                if (reservation == null) {
                    break;
                }
                checkInCustomer(reservation);
                break;
            case 4:
                showReservations();
                ep.print("Enter the reservation number: ");
                int reservationNumber = sc.nextInt();
                Reservation reservation1 = reservations.get(reservationNumber - 1);
                checkOutCustomer(reservation1);
                break;

            case 5:
                showRooms();
                break;

            case 6:
                showCustomers();
                break;  
            case 7:
                advanceDay();
                break;
            case 8:
                System.exit(0);
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
            UtilityFunctions.waitForEnter();
            return;
        }
        Vector<Room> floor = rooms.get(floorNumber - 1);
        floor.add(room);
        ep.print("Room added successfully!");
        UtilityFunctions.waitForEnter();
    }

    /**
     * This function will be used to add a new customer to the hotel.
     */

    public void addCustomer() {
        Customer n = Customer.createCustomer();
        customers.add(n);

        // create a new vector and copy the elements of customers into it
        Vector<Object> customerObjects = new Vector<Object>(customers);

        // sort the new vector by debt
        UtilityFunctions.sortVector(customerObjects, (guest) -> {
            Customer customer = (Customer) guest;
            return (float) customer.dues;
        }, true);

        // copy the sorted elements back into the customers vector
        customers.clear();
        for (Object customer : customerObjects) {
            customers.add((Customer) customer);
        }

        ep.print("Customer added successfully!");
        UtilityFunctions.waitForEnter();
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
            ep.horizontalLine();
        }
        UtilityFunctions.waitForEnter();
    }

    /*
     * Show all rooms
     */

    public void showRooms() {
        ep.print("Rooms: ");
        for (Vector<Room> floor : rooms) {
            for (Room room : floor) {
                room.print();
                ep.horizontalLine();
            }
        }
        UtilityFunctions.waitForEnter();
    }

    /*
     * Check in a customer
     */
    public void checkInCustomer(Reservation reservation) {
        reservations.add(reservation);
        reservation.customer.setReservation(reservation);
        reservation.room.setOccupied(true);
        reservation.customer.addDues((int) (reservation.room.getCost()*1.3)); // 30% of the cost per day is registration fee
        ep.print("Customer checked in successfully!");
        UtilityFunctions.waitForEnter();
    }

    /*
     * Check out a customer
     */
    public void checkOutCustomer(Reservation reservation) {
        reservations.remove(reservation);
        reservation.customer.setReservation(null);
        reservation.room.setOccupied(false);
        ep.print("Customer checked out successfully!");
        UtilityFunctions.waitForEnter();
    }

    /*
     * Show all reservations
     */
    public void showReservations() {
        ep.print("Reservations: ");
        for (Object reservation : reservations) {
            ep.print("Reservation id: " + (reservations.indexOf(reservation) + 1));
            Reservation reservation1 = (Reservation) reservation;
            reservation1.print();
            ep.horizontalLine();
        }
        UtilityFunctions.waitForEnter();
    }

    public void advanceDay() {
        for (Object reservation : reservations) {
            Reservation reservation1 = (Reservation) reservation;
            reservation1.addTotalDay();
            reservation1.customer.addDues(reservation1.room.getCost());
        }
    }

    public Customer searchCustomer() {
        Scanner sc = new Scanner(System.in);
        ep.print("Enter the customer name: ");
        String namae = sc.nextLine();
        Vector<Customer> searched = new Vector<Customer>();
        Pattern p = Pattern.compile(namae, Pattern.CASE_INSENSITIVE);
        for (Object customer : customers) {
            Customer customer1 = (Customer) customer;
            Matcher m = p.matcher(customer1.name);
            if (m.find()) {
                searched.add(customer1);
            }
        }

        if (searched.size() == 0) {
            ep.print("No customers found!");
            UtilityFunctions.waitForEnter();
            return null;
        }

        ep.print("Customers found: ");
        for (Object customer : searched) {
            Customer customer1 = (Customer) customer;
            customer1.print();
            ep.horizontalLine();
        }

        ep.print("Enter the customer id: ");
        int id = sc.nextInt();
        for (Object customer : searched) {
            Customer customer1 = (Customer) customer;
            if (customer1.id == id) {
                ep.print("Customer selected!");
                return customer1;
            }
        }

        ep.print("Customer not found!");
        UtilityFunctions.waitForEnter();
        return null;

    }
}
