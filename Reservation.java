import java.util.*;
public class Reservation {
    Customer customer;
    Room room;
    double price;

    Reservation(Customer customer, Room room, double price) {
        this.customer = customer;
        this.room = room;
        this.price = price;
    }

    public static Reservation createReservation(Vector<Object> custom, Vector<Vector<Object>> room) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the customer id: ");
        int id = sc.nextInt();
        System.out.println("Enter the room number: ");
        int roomNumber = sc.nextInt();
        System.out.println("Enter the floor number: ");
        int floorNumber = sc.nextInt();
        System.out.println("Enter the price per day: ");
        double price = sc.nextDouble();
        Customer customer = null;
        Vector<Object> floor = room.get(floorNumber - 1);

        for (Object customer1 : custom) {
            Customer customer2 = (Customer) customer1;
            if (customer2.id == id) {
                customer = customer2;
                break;
            }
        }

        Room room1 = null;
        for (Object room2 : floor) {
            Room room3 = (Room) room2;
            if (room3.roomNumber == roomNumber) {
                room1 = room3;
                break;
            }
        }

        return new Reservation(customer, room1, price);
    }
}
