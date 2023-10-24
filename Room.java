import java.util.Scanner;
public class Room {
    int roomNumber;
    int floorNumber;
    int capacity;
    int price;
    boolean isOccupied;

    Room(int roomNumber, int floorNumber, int capacity, int price) {
        this.roomNumber = roomNumber;
        this.floorNumber = floorNumber;
        this.capacity = capacity;
        this.price = price;
        this.isOccupied = false;
    }

    public static Room createRoom() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter floor number: ");
        int floorNumber = sc.nextInt();
        System.out.println("Enter capacity: ");
        int capacity = sc.nextInt();
        System.out.println("Enter price: ");
        int price = sc.nextInt();
        System.out.println("Enter room number: ");
        int roomNumber = sc.nextInt();
        return new Room(roomNumber, floorNumber, capacity, price);
    }

    public void print() {
        System.out.println("Room number: " + roomNumber);
        System.out.println("Floor number: " + floorNumber);
        System.out.println("Capacity: " + capacity);
        System.out.println("Price: " + price);
    }

    public void setOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    public int getCost() {
        return price;
    }
}
