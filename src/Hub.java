public class Hub {
    public static void main(String[] args){
        //StringCalculator calc = new StringCalculator();
        //System.out.println(calc.add("//[;;][-]\n1;;2--4"));

        ArabicToRomaNumerals conv = new ArabicToRomaNumerals();
        System.out.println(conv.convertToRoman(1234));
        System.out.println(conv.convertArabic("XXIX"));
        Bowling bowl = new Bowling();
        System.out.println(bowl.score("aaaaaaaaaaaaaaaaaaaa"));
    }
}
