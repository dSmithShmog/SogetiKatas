
import org.junit.*;
import org.junit.rules.ExpectedException;

import java.util.Random;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class StringCalculatorTest {
    private NewStringCalculator calc;
    @Rule public ExpectedException thrown = ExpectedException.none();

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

    @Test public void handlesCommasAndNewLinesAsDelimiters(){
        assertThat(6, equalTo(calc.calculateStringValue("1,2\n3")));
    }
    @Test public void givenManyNumsReturnsNumericValue(){
        String num = "";
        int sum = 0;
        String prefix = "";
        Random r = new Random();
        for(int i = 0; i < 50; i++){
            int x = r.nextInt(100);
            sum += x;
            num += prefix + Integer.toString(x);
            prefix = ",";
        }

        assertThat(sum, equalTo(calc.calculateStringValue(num)));
    }
    @Test public void givenNewDelimiterReturnsNumericValue(){
        assertThat(10, equalTo(calc.calculateStringValue("//;\n1,2\n3;4")));
    }
    @Test(expected = NegativeNumbersException.class)
    public void givenNegativeThrowsErrorAndShowNegatives(){
        calc.calculateStringValue("-1,-2");

    }
    @Test public void ignoresNumbersGreaterThan1000(){
        assertEquals(2, calc.calculateStringValue("1000,2"));
    }
}
