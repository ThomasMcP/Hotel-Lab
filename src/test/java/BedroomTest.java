import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BedroomTest {
    Bedroom bedroom;
    Guest guest;

    @Before
    public void beforeEach(){
        bedroom = new Bedroom(4, 2, 15, 56.50, "Twin Double");
        guest = new Guest("Thomas McPhee");
    }

    @Test
    public void canGetCapacity(){
        assertEquals(4, bedroom.getCapacity());
    }

    @Test
    public void canGetFloorNumber(){
        assertEquals(2, bedroom.getFloorNumber());
    }

    @Test
    public void canGetRoomNumber(){
        assertEquals(15, bedroom.getRoomNumber());
    }

    @Test
    public void canGetDoorNumber(){
        assertEquals(215, bedroom.getDoorNumber());
    }

    @Test
    public void canGetNightlyRate(){
        assertEquals(56.50, bedroom.getNightlyRate(), 0.01);
    }

    @Test
    public void canGetType(){
        assertEquals("Twin Double", bedroom.getType());
    }

    @Test
    public void roomIntiallyUnoccupied(){
        assertFalse(bedroom.isOccupied());
    }

    @Test
    public void roomInitiallyEmpty(){
        assertEquals(0, bedroom.numberOfGuests());
    }

    @Test
    public void canBookSingleGuestInRoom() {
        assertFalse(bedroom.isOccupied());
        assertEquals(0, bedroom.numberOfGuests());
        bedroom.bookRoom(guest);
        assertTrue(bedroom.isOccupied());
        assertEquals(1, bedroom.numberOfGuests());
    }

    @Test
    public void cantBookMultiplePartiesInOneRoom() {
        assertFalse(bedroom.isOccupied());
        assertEquals(0, bedroom.numberOfGuests());
        bedroom.bookRoom(guest);
        bedroom.bookRoom(guest);
        bedroom.bookRoom(guest);
        assertTrue(bedroom.isOccupied());
        assertEquals(1, bedroom.numberOfGuests());
    }

    @Test
    public void canBookMultipleGuestsAtOnce() {
        ArrayList<Guest> guests = new ArrayList<>();
        guests.add(guest);
        guests.add(guest);
        guests.add(guest);
        assertFalse(bedroom.isOccupied());
        assertEquals(0, bedroom.numberOfGuests());
        bedroom.bookRoom(guests);
        assertTrue(bedroom.isOccupied());
        assertEquals(3, bedroom.numberOfGuests());
    }

    @Test
    public void cantBookAboveRoomCapacity() {
        ArrayList<Guest> guests = new ArrayList<>();
        guests.add(guest);
        guests.add(guest);
        guests.add(guest);
        guests.add(guest);
        guests.add(guest);
        assertFalse(bedroom.isOccupied());
        assertEquals(0, bedroom.numberOfGuests());
        bedroom.bookRoom(guests);
        assertFalse(bedroom.isOccupied());
        assertEquals(0, bedroom.numberOfGuests());
    }

    @Test
    public void canRemoveGuests(){
        assertFalse(bedroom.isOccupied());
        assertEquals(0, bedroom.numberOfGuests());
        bedroom.bookRoom(guest);
        assertTrue(bedroom.isOccupied());
        assertEquals(1, bedroom.numberOfGuests());
        bedroom.removeAllGuests();
        assertFalse(bedroom.isOccupied());
        assertEquals(0, bedroom.numberOfGuests());
    }

}
