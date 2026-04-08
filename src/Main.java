import java.util.*;

// --- Class 1: Reservation (Guest Data) ---
class Reservation {
    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() { return guestName; }
    public String getRoomType() { return roomType; }
}

// --- Class 2: RoomInventory (Stock Management) ---
class RoomInventory {
    private Map<String, Integer> availability = new HashMap<>();

    public RoomInventory() {
        availability.put("Single", 5);
        availability.put("Double", 3);
        availability.put("Suite", 2);
    }

    public int getAvailableCount(String type) {
        return availability.getOrDefault(type, 0);
    }

    public void reduceInventory(String type) {
        availability.put(type, availability.get(type) - 1);
    }
}

// --- Class 3: RoomAllocationService (The New Logic) ---
class RoomAllocationService {
    private Set<String> allocatedRoomIds;
    private Map<String, Set<String>> assignedRoomsByType;

    public RoomAllocationService() {
        allocatedRoomIds = new HashSet<>();
        assignedRoomsByType = new HashMap<>();
    }

    public void allocateRoom(Reservation reservation, RoomInventory inventory) {
        String type = reservation.getRoomType();

        if (inventory.getAvailableCount(type) > 0) {
            String roomId = generateRoomID(type);
            inventory.reduceInventory(type);

            System.out.println("Booking confirmed for Guest: " + reservation.getGuestName() +
                    ", Room ID: " + roomId);
        } else {
            System.out.println("Booking failed for " + reservation.getGuestName() +
                    ": No " + type + " rooms available.");
        }
    }

    private String generateRoomID(String roomType) {
        // Creates a unique ID like "Single-1", "Single-2", etc.
        assignedRoomsByType.putIfAbsent(roomType, new HashSet<>());
        int nextNumber = assignedRoomsByType.get(roomType).size() + 1;
        String newId = roomType + "-" + nextNumber;

        assignedRoomsByType.get(roomType).add(newId);
        allocatedRoomIds.add(newId);
        return newId;
    }
}

// --- Class 4: Main Execution Class ---
public class Ma {
    public static void main(String[] args) {
        System.out.println("Room Allocation Processing");
        System.out.println("----------------------------------------------");

        // 1. Setup Inventory and Allocation Service
        RoomInventory inventory = new RoomInventory();
        RoomAllocationService allocationService = new RoomAllocationService();

        // 2. Setup a Queue of requests (as per Use Case 5)
        Queue<Reservation> requestQueue = new LinkedList<>();
        requestQueue.offer(new Reservation("Abhi", "Single"));
        requestQueue.offer(new Reservation("Subha", "Single")); // Note: Snapshot shows Subha as Single-2
        requestQueue.offer(new Reservation("Vennathi", "Suite"));

        // 3. Process the Queue (FIFO)
        while (!requestQueue.isEmpty()) {
            Reservation currentRequest = requestQueue.poll();
            allocationService.allocateRoom(currentRequest, inventory);
        }
    }
}