import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GuestTest {
    Guest guest;

    @Before
    public void beforeEach(){
        guest = new Guest("Paul Wishart");
    }

    @Test
    public void canGetName(){
        assertEquals("Paul Wishart", guest.getName());
    }

    @Test
    public void hasGymMembership(){
        assertEquals(false, guest.getGymMembership());
    }
}
