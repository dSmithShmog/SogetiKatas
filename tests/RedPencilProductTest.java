import org.junit.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class RedPencilProductTest {
    private RedPencilProduct red;

    @Before
    public void createRedPencil(){
        red = new RedPencilProduct(100);
    }

    @Test
    public void RedPencilLastsTwentyNineDays(){
        red.changeSale(.6);

        for(int i =0; i < 29; i++) red.checkIn();

        assertTrue(red.getRedPencil());
    }

    @Test
    public void whenGivenLessThanFiveSaleNotRedPencil(){
        red.changeSale(.4);

        assertFalse(red.getRedPencil());
    }
    @Test
    public void whenGivenGreaterThanThirtySaleNotRedPencil(){
        red.changeSale(.31);

        assertFalse(red.getRedPencil());
    }

    @Test
    public void whenCheckIn30TurnsOffRedPencilSale(){
        red.changeSale(.6);

        for(int i = 0; i < 30; i++) red.checkIn();

        assertFalse(red.getRedPencil());
    }

}
