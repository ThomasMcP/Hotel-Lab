import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class HotelTest {
    Hotel hotel;
    Bedroom bedroom;
    Guest guest;
    Guest guestB;
    Guest guestC;
    Bedroom bedroom2;
    ArrayList<Guest> guestsABC;

    @Before
    public void BeforeEach(){
        hotel = new Hotel("California", 7);
        bedroom = new Bedroom(4, 2, 15, 56.50, "Twin Double");
        guest = new Guest("Malcolm Finlayson");
        guestB = new Guest("Thomas McPhee");
        guestC = new Guest("Paul Wishart");
        bedroom2 = new Bedroom(7, 1, 15, 120, "Family");
        guestsABC = new ArrayList<Guest>();
        guestsABC.add(guest);
        guestsABC.add(guestB);
        guestsABC.add(guestC);
    }

    @Test
    public void canGetNameOfHotel(){
        assertEquals("California", hotel.getName());
    }

    @Test
    public void canGetNumberOfFloors(){
        assertEquals(7, hotel.getNumberOfFloors());
    }

    @Test
    public void numberOfBedroomsInitiallyZero(){
        assertEquals(0, hotel.getnumberOfRooms());
    }

    @Test
    public void canAddRoomToHotel(){
        hotel.addBedroom(bedroom);
        hotel.addBedroom(bedroom);
        assertEquals(2, hotel.getnumberOfRooms());
    }

    @Test
    public void canGetTotalCapacity(){
        hotel.addBedroom(bedroom);
        hotel.addBedroom(bedroom2);
        assertEquals(11, hotel.totalCapacity());
    }

    @Test
    public void canSeeRoomsPerFloor(){
        hotel.addBedroom(bedroom);
        hotel.addBedroom(bedroom2);
        assertEquals(1, hotel.roomsPerFloor(2));
        assertEquals(1, hotel.roomsPerFloor(1));
        assertEquals(0, hotel.roomsPerFloor(10));
    }

    @Test
    public void canSeeAllGuests(){
        hotel.addBedroom(bedroom);
        hotel.addBedroom(bedroom2);
        bedroom.bookRoom(guest);
        bedroom2.bookRoom(guestsABC);
        assertEquals(4, hotel.getNumberOfGuests());
    }

    @Test
    public void canSeeAllUnoccupiedRooms(){
        hotel.addBedroom(bedroom);
        hotel.addBedroom(bedroom2);
        bedroom.bookRoom(guest);
        assertEquals(1, hotel.getEmptyRooms().size());
    }

    @Test
    public void canSeeAllOccupiedRooms(){
        hotel.addBedroom(bedroom);
        hotel.addBedroom(bedroom2);
        bedroom.bookRoom(guest);
        bedroom2.bookRoom(guestsABC);
        assertEquals(2, hotel.getOccupiedRooms().size());
    }

    @Test
    public void canGetNightlyIncome(){
        hotel.addBedroom(bedroom);
        hotel.addBedroom(bedroom2);
        bedroom.bookRoom(guest);
        bedroom2.bookRoom(guestsABC);
        assertEquals(176.50, hotel.getNightlyIncome(), 0.01);
    }
}
