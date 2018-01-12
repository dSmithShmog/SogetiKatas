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
    @Test
    public void givenOneNumReturnsNumericValue(){
        assertThat(1, equalTo(calc.calculateStringValue("1")));
    }
    @Test
    public void givenTwoNumsReturnsNumericValue(){
        assertThat(3, equalTo(calc.calculateStringValue("1,2")));
    }


}
