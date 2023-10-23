import java.util.*;
import HMS.*;
public class Reservation {
    Customer customer;
    Room room;
    double price;

    Reservation(Customer customer, Room room, double price) {
        this.customer = customer;
        this.room = room;
        this.price = price;
    }

    public static Reservation createReservation(Vector<Customer> custom, Vector<Vector<Room>> room) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the customer id: ");
        int id = sc.nextInt();
        System.out.println("Enter the room number: ");
        int roomNumber = sc.nextInt();
        Customer customer = null;
        Room customerRoom = null;
        for (Vector<Room> floor1 : room) {
            for (Room room1 : floor1) {
                if (room1.roomNumber == roomNumber) {
                    customerRoom = room1;
                    break;
                }
            }
        }

        for (Object customer1 : custom) {
            Customer customer2 = (Customer) customer1;
            if (customer2.id == id) {
                customer = customer2;
                break;
            }
        }

        if (customer == null) {
            System.out.println("Customer does not exist!");
            UtilityFunctions.waitForEnter();
            return null;
        }

        if (customerRoom == null) {
            System.out.println("Room does not exist!");
            UtilityFunctions.waitForEnter();
            return null;
        }

        if (customerRoom.isOccupied) {
            System.out.println("Room is already occupied!");
            UtilityFunctions.waitForEnter();
            return null;
        }


        return new Reservation(customer, customerRoom, customerRoom.price);
    }

    public void printMinimal() {
        System.out.println("Room: ");
        room.print();
    }

    public void print() {
        EasyPrint ep = new EasyPrint();
        System.out.println("Customer: ");
        ep.print(customer.name);
        ep.print(customer.id);
        ep.print(customer.dues);
        ep.print("--------------------");
        System.out.println("Room: ");
        ep.print(room.roomNumber);
        ep.print(room.floorNumber);
        ep.print(room.capacity);
        ep.print(room.price);
        ep.print();
    }

}
