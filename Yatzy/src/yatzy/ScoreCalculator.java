package yatzy;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author robertbr
 */
public class ScoreCalculator {
    
    private int[] diceValues = new int[5];
    
    
    public ScoreCalculator(int die1, int die2, int die3, int die4, int die5){       
        diceValues[0] = die1;
        diceValues[1] = die2;
        diceValues[2] = die3;
        diceValues[3] = die4;
        diceValues[4] = die5;
    }
    
    
    //UpperSection = Ones, Twos, Threes, Fours, Fives and Sixes
    //Threes: The sum of all dice showing the number 3.
    public int UpperSection(int i){
        int score = 0;
        for(int die : diceValues){
            if(die == i){
            score += die;
            }   
        }
        return score;
    }
    
    // Pair = two of a kind
    // Yatzy = five of a kind
    public int NOfAKind(int nOfAKind){
        int score = 0;
        for(int i = 1; i<=6;i++){
            if(UpperSection(i) >= nOfAKind*i){
                score = nOfAKind*i;
            }
        }
        if(score>0 && nOfAKind == 5){
            return 50;
        }
        return score;
    }
    
    //Two pairs = Two of a kind and two of a different kind 
    //e.g: 4,4,2,2,6 or 4,4,2,2,2 but not for example 6,6,6,6,4
    public int TwoPairs(){
        int NOfAKind2 = NOfAKind(2)/2; //Biggest Pair
        
        int NOfAKindDifferent = 0; //Smallest Pair
        for(int i = 1; i<=6;i++){
            if(UpperSection(i) >= 2*i){
                NOfAKindDifferent = i;
                break;
            }
        }
        
        if((NOfAKindDifferent != NOfAKind2) && NOfAKindDifferent !=0 && NOfAKind2 != 0){
            return 2*NOfAKindDifferent+2*NOfAKind2;
        }
        return 0;
        
    } 
    
    //Full House = Tree of a kind and two of a different kind
    //e.g: 4,4,4,2,2, but not for example 4,4,4,4,4
    public int FullHouse(){
        int NOfAKind3 = NOfAKind(3)/3;
        int NOfAKind2 = NOfAKind(2)/2;
        if((NOfAKind3 != NOfAKind2) && NOfAKind3 !=0 && NOfAKind2 != 0){
            return 3*NOfAKind3+2*NOfAKind2;
        }
        return 0;
        
    }
    
    
    
    //Small straight = 1,2,3,4,5 or 5,2,3,4,1 or ... (numbers 1-5 in arbitrary order) Score: 15
    //Large straight = 2,3,4,5,6 or 3,6,4,5,2 or ... (numbers 2-6 in arbitrary order) Score: 21
    
    //if small == 0 we are searching for a small straight if 
    //if small == 1 we are searching for a large straight if
    public int Straight(int small){
        
        int foundNumbers = 0;
        
        for(int i = 1+small; i<=5+small;i++){
            for(int j = 0; j<diceValues.length;j++){
                if(diceValues[j]==i){
                    foundNumbers++;
                    break;
                }
            }
        }
        
        if(foundNumbers == 5){
            if(small == 0){
                return 15;
            }else if(small == 1){
                return 21;
            }
        }
        return 0;
    }
    
    
    
    
    //Chance = sum of the diceValues
    public int Chance(){
        int score = 0;
        for(int die:diceValues){
            score += die;
        }
        return score;
    }
    
   
}
