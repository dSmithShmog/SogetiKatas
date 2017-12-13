import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FizzBuzz {

    private static List<String> replace = new ArrayList<>();
    private static List<Integer> divisor = new ArrayList<>();

    public void FizzBuzz(){


    }

    public void FizzBuzz(List<String> r, List<Integer> d){
        this.replace = r;
        this.divisor = d;
    }


    protected void seeConversions(){
        for(int i = 0; i < replace.size(); i++) System.out.println(divisor.get(i) + " - " + replace.get(i));

    }

    protected void addConverter(int d, String r){
        //can easily make this actually based on active user input
        this.replace.add(r);
        this.divisor.add(d);
        int index = divisor.indexOf(d);
        while(true){
            if(index == 0) break;
            if(divisor.get(index-1) > d){
                Collections.swap(divisor, index, index-1);
                Collections.swap(replace, index, index-1);
                index--;
            }
            else break;
        }
    }

    protected String translateFizzBuzz(int score){
        StringBuilder b = new StringBuilder();

        String prefix = "";
        for(int i = 0; i < replace.size(); i++){
            if(score % divisor.get(i) == 0){
                b.append(prefix);
                b.append(replace.get(i));
                prefix = " ";
            }
        }
        if(b.length() == 0) return Integer.toString(score);
        return b.toString();
    }
}
