public class Hub {
    public static void main(String[] args){
        StringCalculator calc = new StringCalculator();
        //System.out.println(calc.add("//[;;][-]\n1;;2--4"));
        FizzBuzz fizz = new FizzBuzz();

        //addConverter, if called within the class itself, doesn't work in either the constructor or elsewhere
        //dont know why
        /*fizz.addConverter(3, "Fizz");
        fizz.addConverter(5, "Buzz");
        fizz.addConverter(7, "Pop");
        fizz.addConverter(1, "Fit");
        fizz.seeConversions();
        System.out.println(fizz.translateFizzBuzz(3));
        ArabicToRomaNumerals conv = new ArabicToRomaNumerals();
        System.out.println(conv.convertToRoman(1234));
        System.out.println(conv.convertArabic("XXIX"));*/
        BowlingScorer bowl = new BowlingScorer();
        System.out.println(bowl.scoreGame("5/5/5/5/5/5/5/5/5/5/5"));
    }
}
