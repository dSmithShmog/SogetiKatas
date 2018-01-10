import java.util.*;
import java.util.stream.Collectors;

class FizzBuzz {
    private List<Integer> orderedKeys = new ArrayList<>();
    private Map<Integer, String> translations = new HashMap<>();

    public FizzBuzz(){
        this.translations.put(3, "Fizz");
        this.translations.put(5, "Buzz");
        this.translations.put(7, "Pop");
        this.orderedKeys.add(3);
        this.orderedKeys.add(5);
        this.orderedKeys.add(7);
    }

    public FizzBuzz(List<Integer> a, Map<Integer, String> b){
        this.orderedKeys = a;
        this.translations = b;
        Collections.sort(orderedKeys); //verify input
    }

    protected String getAnswer(int num){
        StringBuilder b = new StringBuilder();
        for(Integer i: orderedKeys){
            if(num % i == 0) b.append(translations.get(i));
        }
        return b.toString();
    }

    //allowing external changes to private fields seems bad practice, but how else can I allow for changes?
    //although you still cant acces it directly
    protected void addTranslation(int num, String translation){
        if(translations.containsKey(num)) translations.remove(num);
        if(!orderedKeys.contains(num)){
            orderedKeys.add(num);
            Collections.sort(orderedKeys);
        }
        this.translations.put(num, translation);
    }
}
