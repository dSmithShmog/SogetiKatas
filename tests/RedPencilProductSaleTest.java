import org.junit.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class RedPencilProductSaleTest{
    private RedPencilProduct red;
    @Before
    public void createRedPencil(){
        red = new RedPencilProduct(100);
    }
    @Test
    public void when10ReturnsValidSale(){
        red.changeSale(.10);

        assertThat(.1, equalTo(red.getSale()));
    }
    @Test
    public void when10ReturnsValidPrice(){
        red.changeSale(.10);

        assertThat(90.0, equalTo(red.getCurrentPrice()));
    }



}