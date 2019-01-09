import java.util.ArrayList;

public class Bedroom {
    private int capacity, floorNumber, roomNumber;
    private double nightlyRate;
    private String type;
    private Boolean occupied;
    private ArrayList<Guest> guests;

    public Bedroom(int capacity, int floorNumber, int roomNumber, double nightlyRate, String type){
        this.capacity = capacity;
        this.floorNumber = floorNumber;
        this.roomNumber = roomNumber;
        this.nightlyRate = nightlyRate;
        this.type = type;
        this.occupied = false;
        this.guests = new ArrayList<>();
    }

    public int getCapacity(){
        return capacity;
    }

    public int getFloorNumber(){
        return this.floorNumber;
    }

    public int getRoomNumber() {
        return this.roomNumber;
    }

    public int getDoorNumber() {
        return (this.floorNumber * 100) + this.roomNumber;
    }

    public double getNightlyRate() {
        return nightlyRate;
    }

    public String getType() {
        return type;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public int numberOfGuests() {
        return guests.size();
    }

    public void bookRoom(ArrayList<Guest> guestParty) {
        if (!isOccupied() && guestParty.size() <= capacity) {
            for (Guest guest: guestParty) {
                addGuest(guest);
            }
            occupied = true;
        }
    }

    public void bookRoom(Guest guest) {
        if (!isOccupied()) {
            addGuest(guest);
            occupied = true;
        }
    }

    private void addGuest(Guest guest) {
        guests.add(guest);
    }

}
