import java.util.Vector;

public interface HotelInterface {
    // Outlines the functions that a hotel must implement
    Vector<Customer> customers = new Vector<Customer>();
    Vector<Vector<Room>> rooms = new Vector<Vector<Room>>();
    Vector<Reservation> reservations = new Vector<Reservation>();

    public void run();
    public void addRoom(Room room);
    public void addRoom();
    public void addCustomer();
    public void showCustomers();
    public void showRooms();
    public void checkInCustomer(Reservation reservation);
    public void checkOutCustomer(Reservation reservation);
    public void showReservations();
    
}
