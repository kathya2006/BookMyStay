public class Main{

    public static void main(String[] args) {

        System.out.println("Night Room Simulation");
        System.out.println();

        RoomDefinition single = new RoomDefinition("Single Room", 1, 2000.0);
        RoomDefinition doubleRoom = new RoomDefinition("Double Room", 2, 4000.0);
        RoomDefinition suite = new RoomDefinition("Suite Room", 4, 8000.0);

        single.printRoom();
        doubleRoom.printRoom();
        suite.printRoom();
    }
}

class LongTermReservation {

    private String name;
    private int duration;
    private double price;

    public LongTermReservation(String name, int duration, double price) {
        this.name = name;
        this.duration = duration;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public double getPrice() {
        return price;
    }
}

class RoomDefinition {

    private String name;
    private int max;
    private double pricePerNight;

    public RoomDefinition(String name, int max, double pricePerNight) {
        this.name = name;
        this.max = max;
        this.pricePerNight = pricePerNight;
    }

    public void printRoom() {
        System.out.println(name);
        System.out.println("Max: " + max);
        System.out.println("Price per night: " + pricePerNight);
        System.out.println();
    }
}

class Reservation {

    private String guestName;
    private int roomNumber;
    private int nights;

    public Reservation(String guestName, int roomNumber, int nights) {
        this.guestName = guestName;
        this.roomNumber = roomNumber;
        this.nights = nights;
    }

    public String getGuestName() {
        return guestName;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getNights() {
        return nights;
    }
}