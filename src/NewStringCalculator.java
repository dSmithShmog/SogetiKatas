import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewStringCalculator {

    protected int calculateStringValue(String num){
        if(num == null || num.equals("")) return 0;

        String[] nums = num.split(",|\n");
        int sum = 0;
        for(String x: nums){
            sum += Integer.parseInt(x);
        }
        System.out.println(sum);
        return sum;
    }
}
