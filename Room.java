import java.util.Scanner;
import HMS.Inputs;
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
        int floorNumber = Inputs.getInt("Enter floor number: ");
        int capacity = Inputs.getInt("Enter capacity: ");
        int price = Inputs.getInt("Enter price: ");
        int roomNumber = Inputs.getInt("Enter room number: ");
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
