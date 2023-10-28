import java.util.*;
import HMS.*;
public class Reservation {
    Customer customer;
    Room room;
    double price;
    int totalDays;

    Reservation(Customer customer, Room room, double price) {
        this.customer = customer;
        this.room = room;
        this.price = price;
        this.totalDays = 1;
    }

    public static Reservation createReservation(Customer customer, Vector<Vector<Room>> room) {
        Scanner sc = new Scanner(System.in);
        int roomNumber = Inputs.getInt("Enter the room number: ");
        Room customerRoom = null;
        for (Vector<Room> floor1 : room) {
            for (Room room1 : floor1) {
                if (room1.roomNumber == roomNumber) {
                    customerRoom = room1;
                    break;
                }
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
        ep.horizontalLine();
        System.out.println("Room: ");
        ep.print(room.roomNumber);
        ep.print(room.floorNumber);
        ep.print(room.capacity);
        ep.print(room.price);
        ep.print();
    }

    public void addTotalDay() {
        totalDays++;
    }

}
