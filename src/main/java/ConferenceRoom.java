import java.util.ArrayList;

public class ConferenceRoom {

    private int capacity;
    private double hourlyRate;
    private String name;
    private Boolean occupied;
    private ArrayList<Guest> guests;

    public ConferenceRoom(String name, int capacity, double hourlyRate){
        this.name = name;
        this.capacity = capacity;
        this.hourlyRate = hourlyRate;
        this.occupied = false;
        this.guests = new ArrayList<Guest>();
    }

    public String getName(){
        return name;
    }

    public int getCapacity(){
        return capacity;
    }

    public double getHourlyRate(){
        return hourlyRate;
    }

    public Boolean isOccupied(){
        return occupied;
    }

    public int numberOfGuests(){
        return guests.size();
    }

    public void addGuest(Guest guest) {
        guests.add(guest);
    }


    public void removeAllGuests() {
        guests.clear();
    }
}
