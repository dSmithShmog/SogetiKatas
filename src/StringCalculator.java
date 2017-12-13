import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private List findDelimiters(String nums){
        List<String> delimiters = new ArrayList<>();
        Pattern p = Pattern.compile("\\[(.*?)\\]", Pattern.DOTALL);
        Matcher m = p.matcher(nums);

        while(m.find()){
            System.out.println(m.group(1));
            delimiters.add(m.group(1));
        }
        return delimiters;
    }

    private String buildRegex(List<String> delimiters){
        StringBuilder b = new StringBuilder();
        String prefix = "";
        for(String x: delimiters){
            if(x.equals("-")) {
                b.append(prefix);
                b.append(x+"(?=(?:"+x+"))"); //account for negative numbers after '-' delimiter
            }
            else {
                b.append(prefix);
                b.append(x);
            }
            prefix = "|";
        }
        return b.toString();
    }

    protected int add(String nums){

        if(nums == null) return 0;
        List<String> delimiters = new ArrayList<>();
        String newNums;

        //if special delimiters, parse for them, save them, and remove them from the string
        if(nums.charAt(1) == '/'){
            //parse for delimiters of any length
            delimiters = findDelimiters(nums);
            //eliminate delimiter line from string
            newNums = nums.split("]\n", 2)[1];
        }
        else{
            newNums = nums;
            delimiters.add(",");
            delimiters.add("\n");
        }

        String[] split = newNums.split(buildRegex(delimiters));

        int sum = 0;
        List<Integer> negs = new ArrayList<>();

        for(String x: split){
            int num = Integer.parseInt(x);
            if(num < 0) negs.add(num);
            else if(num > 1000) continue;
            else sum += num;

        }
        //how to handle '-' as a delimiter?
        //it should handle itself I believe. It does not.
        //Solved: figured out how to use a lookaround in the regex

        if(negs.size() > 0){
            System.out.println("Exception: Negative Values");
            String prefix = "";
            for(int x: negs) {
                System.out.print(prefix+x);
                prefix = "- ";
            }
            System.out.println();
            return 0;
        }
        return sum;
    }


}
