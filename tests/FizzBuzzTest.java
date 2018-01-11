
import org.junit.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class FizzBuzzTest {
    private FizzBuzz f;

    @Test
    public void whenGivenUnorderedKeysValidates(){
        List<Integer> l = new ArrayList<>();
        l.add(3);
        l.add(1);
        HashMap<Integer,String> m = new HashMap<>();
        m.put(3, "Fizz");
        m.put(1, "Fuzz");
        f = new FizzBuzz(l, m);

        assertThat("FuzzFizz", equalTo(f.getAnswer(3)));
    }

    @Test
    public void whenGivenDefaultPerformsCorrectly(){
        f = new FizzBuzz();

        assertThat("FizzBuzz", equalTo(f.getAnswer(15)));
    }



}
