import org.junit.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class BowlingTest {
    private Bowling b;
    private int gameScore;

    @Before
    public void createBowling(){
        b = new Bowling();
    }

    @Test //(expected = IndexOutOfBoundsException.class)
    public void whenGivenIncorrectSparesReturnsMinusOne(){
        gameScore = b.score("// // // // // // // // // //");

        assertThat(-1, equalTo(gameScore));
    }

    @Test
    public void whenGivenIncorrectSpikesReturnsMinusOne(){
        gameScore = b.score("XX X- X- X- X- X- X- X- X- --");

        assertThat(-1, equalTo(gameScore));
    }

    @Test
    public void whenGivenVoidReturnsMinusOne(){
        gameScore = b.score(null);

        assertThat(-1, equalTo(gameScore));
    }
}
