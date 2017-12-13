import java.util.Collections;
import java.util.HashMap;

import java.util.Scanner;

/* '5' symbols cant be used to subtract or be repeated
   '1' symbols can only be subtracted from the next two bigger symbols and can only be repeated up to 3 times
 */
public class ArabicToRomaNumerals {

    //wanted to use a map but theres no good way to iterate through a map in a certain order that I'm aware of
    //This may need to be recursive, crap
    int[] arabic = {1, 5, 10, 50, 100, 500, 1000, 5000, 10000, 50000, 100000, 500000, 1000000};
    String[] roman = {"I", "V", "X", "L", "C", "D", "M", "Vbar", "Xbar", "Lbar", "Cbar", "Dbar", "Mbar"};
    HashMap<String, Integer> trans = new HashMap<>();


    protected int convertArabic(String a){
        int sum = 0;
        trans.put("I", 1);
        trans.put("V", 5);
        trans.put("X", 10);
        trans.put("L", 50);
        trans.put("C", 100);
        trans.put("D", 500);
        trans.put("M", 1000);
        trans.put("Vbar", 5000);
        trans.put("Xbar", 10000);
        trans.put("Lbar", 50000);
        trans.put("Cbar", 100000);
        trans.put("Dbar", 500000);
        trans.put("Mbar", 1000000);

        for(int i = 0; i < a.length(); i++){
            String temp1 = Character.toString(a.charAt(i));
            String temp2 = "";
            try {
                temp2 = Character.toString(a.charAt(i + 1));
            }
            catch(Exception e){
                System.out.println("");
            }
            if(i+1 < a.length() && trans.get(temp2) > trans.get(temp1)) sum -= trans.get(temp1);
            else sum += trans.get(temp1);
        }
        return sum;
    }
    private String convertRomanPiece(int a) {
        StringBuilder b = new StringBuilder();
        System.out.println("Number piece we're converting: " + a);


        //looking for subtractive model
        boolean subtract = false;
        for (int i = arabic.length - 1; i >= 0; i--) {
            //all the '5' symbols have odd indices and cant be used for subtraction
            if(arabic[i] == a) return roman[i];
            else if(arabic[i] < a) break; // number is already smaller, stop checking
            else if (i >= 2 && i % 2 == 0 && (arabic[i] - arabic[i - 2]) <= a) {
                b.append(roman[i - 2]);
                a += arabic[i - 2];
                b.append(roman[i]);
                a -= arabic[i];
                subtract = true;
                //System.out.println("minus 2 trigger\nCurrent num: "+a);
            } else if (i >= 1 && (i - 1) % 2 == 0 && (arabic[i] - arabic[i - 1]) <= a) {
                b.append(roman[i - 1]);
                a += arabic[i - 1];
                b.append(roman[i]);
                a -= arabic[i];
                subtract = true;
                //System.out.println("minus 1 trigger\nCurrent num: "+a);
            }
            //System.out.println("Current Roman: "+b.toString());
        }
        if (subtract) return b.toString();
        int index = 0;
        for (int i = arabic.length - 1; i >= 0; i--) {
            if (a - arabic[i] > 0) {
                index = i;
                break;
            }
        }
        int dupeCount = 0;
        while (a > 0) {
            b.append(roman[index]);
            a -= arabic[index];
            //if '5' symbol, cant dupe
            if(index%2 == 1){
                dupeCount = 0;
                index--;
            }
            else{
                //if already 3 dupes, stop duping, proper handling of subtractive approach might prevent this
                //from ever actually happening
                if(dupeCount >= 3){
                    dupeCount = 0;
                    index--;
                }
                else dupeCount++;
            }

        }


        return b.toString();
    }

    protected String convertToRoman(int a) {
        StringBuilder b = new StringBuilder();

        //the ugly way
        //brute force 98 = LXXXVVVIII but rules require that 98 = VCIII
        //finding an even slightly elegant way to do this has been a mother

        int count = 0;
        while(a > 0){
            b.insert(0,convertRomanPiece((a%10)*(int)Math.pow(10,count)));
            a /= 10;
            count++;
        }

        return b.toString();


    }
}
