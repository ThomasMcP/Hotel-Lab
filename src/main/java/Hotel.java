import java.util.ArrayList;
import java.util.BitSet;

public class Hotel {
    private ArrayList<Bedroom> bedrooms;
    private String name;
    private int numberOfFloors;

    public Hotel(String name, int numberOfFloors){
        this.name = name;
        this.numberOfFloors = numberOfFloors;
        this.bedrooms = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public int getnumberOfRooms() {
        return bedrooms.size();
    }

    public void addBedroom(Bedroom bedroom) {
        this.bedrooms.add(bedroom);
    }

    public int totalCapacity() {
        int sum = 0;
        for (Bedroom bedroom: this.bedrooms) {
            sum += bedroom.getCapacity();
        }
        return sum;
    }

    public int roomsPerFloor(int floorNumber) {
        int count = 0;
        for (Bedroom bedroom: this.bedrooms) {
            if (floorNumber == bedroom.getFloorNumber()){
                count ++;
            }
        }
        return count;
    }

    public int getNumberOfGuests() {
        int totalGuests = 0;
        for (Bedroom bedroom: this.bedrooms) {
            totalGuests += bedroom.numberOfGuests();
        }
        return totalGuests;
    }

    public ArrayList<Bedroom> getEmptyRooms() {
        ArrayList<Bedroom> foundRooms = new ArrayList<>();
        for (Bedroom bedroom: this.bedrooms) {
            if (!bedroom.isOccupied()){
                foundRooms.add(bedroom);
            }
        }
        return foundRooms;
    }


    public ArrayList<Bedroom> getOccupiedRooms() {
        ArrayList<Bedroom> foundRooms = new ArrayList<>();
        for (Bedroom bedroom: this.bedrooms) {
            if (bedroom.isOccupied()){
                foundRooms.add(bedroom);
            }
        }
        return foundRooms;
    }

    public double getNightlyIncome() {
        ArrayList<Bedroom> occupiedRooms = getOccupiedRooms();
        double sum = 0;
        for (Bedroom bedroom: occupiedRooms) {
            sum += bedroom.getNightlyRate();
        }
        return sum;
    }
}
