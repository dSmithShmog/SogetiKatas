import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewStringCalculator {

    protected int calculateStringValue(String num){
        if(num == null || num.equals("")) return 0;
        num = num.replaceAll(" ", "");
        String[] nums = num.split(",");
        int sum = 0;
        for(String x: nums){
            sum += Integer.parseInt(x);
        }
        return sum;
    }
}
