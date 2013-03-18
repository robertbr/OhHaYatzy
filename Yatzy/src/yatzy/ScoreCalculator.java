/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yatzy;

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
    //We check how many dice with value i we got and what that combination is worth.
    public int UpperSection(int i){
        int value = 0;
        for(int die : diceValues){
            if(die == i){
            value = value+die;
            }   
        }
        return value;
    }
    
    // Yatzy = the dice have the same value.
    public int Yatzy(){
        int value = 0;
        for(int i = 1; i<=6;i++){
            if(UpperSection(i) == 5*i){
                value = 50;
            }
        }
        return value;
    }
}
