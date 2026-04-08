public class Main {

    public static void main(String[] args) {

        RoomInventory r1 = new RoomInventory("Single Room", 1, 1000.0, 5);
        RoomInventory r2 = new RoomInventory("Double Room", 2, 2000.0, 3);
        RoomInventory r3 = new RoomInventory("Suite Room", 4, 5000.0, 1);

        RoomInventoryList list = new RoomInventoryList();
        list.addRoom(r1);
        list.addRoom(r2);
        list.addRoom(r3);

        list.printRooms();
    }
}

class RoomInventory {

    String name;
    int max;
    double pricePerNight;
    int available;

    public RoomInventory(String name, int max, double pricePerNight, int available) {
        this.name = name;
        this.max = max;
        this.pricePerNight = pricePerNight;
        this.available = available;
    }

    public void printRoom() {
        System.out.println(name);
        System.out.println("Max: " + max);
        System.out.println("Price per night: " + pricePerNight);
        System.out.println("Available: " + available);
    }
}

class RoomInventoryList {

    RoomInventory[] rooms = new RoomInventory[10];
    int count = 0;

    public void addRoom(RoomInventory room) {
        rooms[count++] = room;
    }

    public void printRooms() {
        for (int i = 0; i < count; i++) {
            rooms[i].printRoom();
            System.out.println();
        }
    }
}