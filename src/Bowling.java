import java.util.List;

class Bowling {

    private boolean spare = false;
    private boolean strike = false;
    //context of a frame helps in skipping strikes second frame, counting spares, and knowing when the 10th frame is
    //but if I smash it all together the look ahead becomes way easier
    private int getThrowValue(char x){
        if(x == 'X') return 10;
        else if(x == '-') return 0;
        else return Character.getNumericValue(x);
    }

    //not currently in use because of disregard for context of 'frame' but could come into use
    private int getFrameValue(String frame){
        if(frame.equals("X-") || frame.charAt(1) == '/') return 10;
        else return frame.charAt(0) + frame.charAt(1);
    }

    //doesn't take all the ways to screw up a bowling scoreboard into account, just some cases
    protected boolean validateGame(String game){
        if(game.length() < 20) return false;
        for(int i = 0; i < game.length(); i++){
            if(i%2 == 0 && game.charAt(i) == '/' ) return false;
            else if(game.charAt(i) == 'X' && game.charAt(i+1) != '-') return false;
        }
        return true;
    }
    protected int score(String game){

        // assume a space delimeter
        game = game.replaceAll("\\s", "");
        int sum = 0;

        if(!validateGame(game)){
            System.out.println("Error: Invalid Input");
            return -1;
        }
        for(int i = 0; i < game.length(); i++){
            System.out.println("Current Sum: "+sum);
            if(i >= 19 ){ //if we're in the 10th frame
                if(game.charAt(i) == '/') sum += (10 - getThrowValue(game.charAt(i-1)));
                else sum += getThrowValue(game.charAt(i));
                continue;
            }
            if(game.charAt(i) == 'X'){
                sum += getThrowValue('X');

                sum += getThrowValue(game.charAt(i+2)); //assume '-' in second half of frame
                sum += getThrowValue(game.charAt(i+3));
            }
            else if(game.charAt(i) == '/'){
                sum += (10 - getThrowValue(game.charAt(i-1))); //only works if '/' conforms
                sum += getThrowValue(game.charAt(i+1));
            }
            else sum += getThrowValue(game.charAt(i));
        }
        return sum;
    }
}
