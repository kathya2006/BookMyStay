public class Main{

    public static void main(String[] args) {

        System.out.println("Room Inventory Listing");

        RoomInventory r1 = new RoomInventory("Single Room", 1, 1000.0, 5);
        RoomInventory r2 = new RoomInventory("Double Room", 2, 2000.0, 3);
        RoomInventory r3 = new RoomInventory("Suite Room", 4, 5000.0, 1);

        System.out.println();
        r1.printRoom();
        System.out.println();

        r2.printRoom();
        System.out.println();

        r3.printRoom();
    }
}

class RoomInventory {

    private String name;
    private int max;
    private double pricePerNight;
    private int numberOfRooms;

    public RoomInventory(String name, int max, double pricePerNight, int numberOfRooms) {
        this.name = name;
        this.max = max;
        this.pricePerNight = pricePerNight;
        this.numberOfRooms = numberOfRooms;
    }

    public void printRoom() {
        System.out.println(name);
        System.out.println("Max: " + max);
        System.out.println("Price per night: " + pricePerNight);
        System.out.println("Number of Rooms: " + numberOfRooms);
    }
}