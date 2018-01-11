import org.junit.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class RedPencilProductTest {
    private RedPencilProduct red;



    @Test
    public void whenSaleOf10ReturnsValidPrice(){
        red = new RedPencilProduct(100);
        red.changeSale(.10);

        assertThat(90, equalTo(red.getCurrentPrice()));
    }

    @Test
    public void whenSaleInRangeTurnsOnRedPencil(){
        red = new RedPencilProduct(100);
        red.changeSale(.10);

        assertThat(true, equalTo(red.getRedPencil()));
    }
    @Test
    public void whenCheckIn30TurnsOffRedPencilSale(){
        red = new RedPencilProduct(100);
        red.changeSale(.6);

        for(int i = 0; i < 30; i++) red.checkIn();

        assertThat(false, equalTo(red.getRedPencil()));
    }
    @Test
    public void RedPencilLastsTwentyNineDays(){
        red = new RedPencilProduct(100);
        red.changeSale(.6);

        for(int i =0; i < 29; i++) red.checkIn();

        assertThat(true, equalTo(red.getRedPencil()));
    }

    @Test
    public void whenGivenLessThanFiveSaleNotRedPencil(){
        red = new RedPencilProduct(100);
        red.changeSale(.4);

        assertThat(false, equalTo(red.getRedPencil()));
    }
    @Test
    public void whenGivenGreaterThanThirtySaleNotRedPencil(){
        red = new RedPencilProduct(100);
        red.changeSale(.31);

        assertThat(false, equalTo(red.getRedPencil()));
    }

}
