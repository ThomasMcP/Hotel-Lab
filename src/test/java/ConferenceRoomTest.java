import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ConferenceRoomTest {

    ConferenceRoom conferenceRoom;
    Guest guest;

    @Before
    public void beforeEach(){
        conferenceRoom = new ConferenceRoom("The Shire", 500, 45.50);
        guest = new Guest("Pawel");
    }

    @Test
    public void canGetName(){
        assertEquals("The Shire", conferenceRoom.getName());
    }

    @Test
    public void canGetCapacity(){
        assertEquals(500, conferenceRoom.getCapacity());
    }

    @Test
    public void canGetHourlyRate(){
        assertEquals(45.50, conferenceRoom.getHourlyRate(), 0.01);
    }

    @Test
    public void roomInitiallyUnoccupied(){
        assertFalse(conferenceRoom.isOccupied());
    }

    @Test
    public void roomInitiallyEmpty() {
        assertEquals(0, conferenceRoom.numberOfGuests());
    }

    @Test
    public void canAddGuest() {
        conferenceRoom.addGuest(guest);
        assertEquals(1, conferenceRoom.numberOfGuests());
    }

    @Test
    public void canRemoveAllGuests(){
        assertEquals(0, conferenceRoom.numberOfGuests());
        conferenceRoom.addGuest(guest);
        conferenceRoom.addGuest(guest);
        conferenceRoom.addGuest(guest);
        assertEquals(3, conferenceRoom.numberOfGuests());
        conferenceRoom.removeAllGuests();
        assertEquals(0, conferenceRoom.numberOfGuests());
    }
}
