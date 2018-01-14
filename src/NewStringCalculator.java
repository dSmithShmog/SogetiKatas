

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewStringCalculator {

    private List<String> delimiters = new ArrayList<>();

    protected int calculateStringValue(String num){

        if(num == null || num.equals("")) return 0;
        String[] numbers = formatStringInput(num);
        return addNumbers(numbers);
    }


    private int addNumbers(String[] nums) {
        int sum = 0;
        List<Integer> negs = new ArrayList<>();
        for(String x: nums){
            int num = Integer.parseInt(x);
            if(num < 0) negs.add(num);
            else sum += Integer.parseInt(x);
        }
        //im unfamiliar with best practices around implementing and handling exceptions
        //so I just extended runtime so I didnt have to check it basically everywhere
        if(negs.size() > 0) throw new NegativeNumbersException("Negative Number Exception: "+negs.toString());

        System.out.println(sum);
        return sum;
    }

    private String[] formatStringInput(String num){
        delimiters.add(",");
        delimiters.add("\n");
        if(num.charAt(0) == '/'){
            delimiters.add(num.substring(2,3));
            num = num.substring(4);
        }
        String[] nums = num.split(buildRegexPattern());
        return nums;
    }

    private String buildRegexPattern(){
        String prefix = "";
        StringBuilder b = new StringBuilder();
        for(String x: delimiters){
            b.append(prefix);
            b.append(x);
            prefix = "|";
        }
        return b.toString();
    }
}
