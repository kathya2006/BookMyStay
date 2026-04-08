import java.util.LinkedList;
import java.util.Queue;

// Class to represent Reservation
class Reservation {
    private String guestName;
    private String roomType;

    // Constructor
    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    // Getter methods
    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }
}

// Class to manage booking request queue
class BookingRequestQueue {

    private Queue<Reservation> requestQueue;

    // Constructor
    public BookingRequestQueue() {
        requestQueue = new LinkedList<>();
    }

    // Add booking request
    public void addRequest(Reservation reservation) {
        requestQueue.offer(reservation);
    }

    // Get next booking request
    public Reservation getNextRequest() {
        return requestQueue.poll();
    }

    // Check if queue has pending requests
    public boolean hasPendingRequests() {
        return !requestQueue.isEmpty();
    }
}

// Main class
public class Main {

    public static void main(String[] args) {

        System.out.println("Booking Request Queue");
        System.out.println("--------------------------------");

        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        // Creating reservation requests
        Reservation r1 = new Reservation("Abhi", "Single");
        Reservation r2 = new Reservation("Subha", "Double");
        Reservation r3 = new Reservation("Vennathi", "Suite");

        // Adding requests to queue
        bookingQueue.addRequest(r1);
        bookingQueue.addRequest(r2);
        bookingQueue.addRequest(r3);

        // Processing queue
        while (bookingQueue.hasPendingRequests()) {
            Reservation current = bookingQueue.getNextRequest();

            System.out.println(
                    "Processing booking for Guest: "
                            + current.getGuestName()
                            + ", Room Type: "
                            + current.getRoomType()
            );
        }
    }
}