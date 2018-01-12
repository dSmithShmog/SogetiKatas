import org.junit.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class StringCalculatorTest {
    private NewStringCalculator calc;
    @Before
    public void createStringCalculator(){
        calc = new NewStringCalculator();
    }
    @Test
    public void whenGivenNullStringReturnsZero(){
        assertThat(0, equalTo(calc.calculateStringValue(null)));
    }
    @Test
    public void GivenEmptyReturnsZero(){
        assertThat(0, equalTo(calc.calculateStringValue("")));
    }


}
