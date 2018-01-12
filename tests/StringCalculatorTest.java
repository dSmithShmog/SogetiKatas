import org.junit.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class StringCalculatorTest {
    private StringCalculator calc;
    @Before
    public void createStringCalculator(){
        calc = new StringCalculator();
    }
    @Test
    public void whenGivenNullStringReturn0(){
        assertThat(0, equalTo(calc.add(null)));
    }
}
