import org.junit.Test;

public class BowlingTest {


    //this test doesnt seem to be in the spirit of testing b/c im using it to look for the exception itself
    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGivenIncorrectSparesGetsOutOfBounds(){
        Bowling b = new Bowling();
        b.score("// // // // // // // // // //");

    }
}
