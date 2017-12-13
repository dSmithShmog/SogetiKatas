public class BowlingScorer {
    //built under the assumption that '-' is no pins, '/' is spare, 'X' is strike,
    //and that there are no spaces between frames.
    //This means there are exactly 21 slots so to speak assuming a full game, it will work with any number
    protected int scoreGame(String a){

        char[] frames = a.toCharArray();
        for(int i = 0; i < frames.length; i++) if(frames[i] == '-') frames[i] = '0'; //quality of life change
        int sum = 0;
        for(int i = 0; i < frames.length; i++){

            if(frames[i] == '/'){
                sum += (10 - Character.getNumericValue(frames[i-1]));
                try{
                    sum += checkSpecialRole(frames[i+1], frames[i]);
                }
                catch(Exception e){
                    System.out.println("There was an exception:\n"+e);
                }
            }
            else if(frames[i] == 'X'){
                sum += 10;
                //not sure if the try tries this piece by piece or treats it as a single unit, important
                //I think it runs like anything else until an error occurs, anything else would be too heavy
                try{
                    sum += checkSpecialRole(frames[i+1], frames[i]);
                    sum += checkSpecialRole(frames[i+2], frames[i+1]);
                }
                catch(Exception e){
                    System.out.println("There was an exception:\n"+e);
                }
            }
            else sum += Character.getNumericValue(frames[i]);
        }
        return sum;
    }

    private int checkSpecialRole(char c, char d){
        if(c == 'X') return 10;
        else if(c == '/') return 10-Character.getNumericValue(d);
        else return Character.getNumericValue(c);
    }
}
