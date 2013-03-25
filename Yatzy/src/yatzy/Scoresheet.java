// 4. harjoitukset, tehtävä , Robert Brunberg
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package yatzy;

/**
 *
 * @author Robert
 */
public class Scoresheet {

    String[][] scoresheet;
    
    
    //About the scoresheet:
    
    /*There are 15 different dice combinations, one square
     * labeled "bonus", two squares labeled "total", and the players' 
     * names are in the first row.
     * 15+1+2+1 = 19
     */
    
    /*The left column contains the names of the dice combinations and the other
     * columns contains the scores of the players.
     */
    
    
    
    public Scoresheet(int numberOfPlayers){       
        scoresheet = new String[19][numberOfPlayers+1];
        
        scoresheet[0][0] = "Names";
        scoresheet[1][0] = "Ones";
        scoresheet[2][0] = "Twos";
        scoresheet[3][0] = "Threes";
        scoresheet[4][0] = "Fours";
        scoresheet[5][0] = "Fives";
        scoresheet[6][0] = "Sixes";
        scoresheet[7][0] = "Total";
        scoresheet[8][0] = "Bonus";
        scoresheet[9][0] = "One Pair";
        scoresheet[10][0] = "Two Pairs";
        scoresheet[11][0] = "Three of a Kind";
        scoresheet[12][0] = "Four of a Kind";
        scoresheet[13][0] = "Small Straight";
        scoresheet[14][0] = "Large Straight";
        scoresheet[15][0] = "Full House";
        scoresheet[16][0] = "Chance";
        scoresheet[17][0] = "Yatzy";
        scoresheet[18][0] = "Total";             
    }
    
    public void setPoints(int row, int column, int points){
        scoresheet[row][column] = String.valueOf(points);
    }
      
    public void setName(int row, int column, String name){
        scoresheet[row][column] = name;
    }
    
    public int getPoints(int row, int column){
        if(scoresheet[row][column] == null){
            return -1;
        }
        int points = Integer.parseInt(scoresheet[row][column]);
        return points;
    }
    
    public String getName(int row, int column){
        if(scoresheet[row][column] == null){
            return null;
        }
        String name = scoresheet[row][column];
        return name;
    }
    
    //Checking if a part of the scoresheet is full.
    public boolean scoresheetFull(int rowStart, int rowEnd, int columnStart, int columnEnd){    
        for(int i = rowStart; i <= rowEnd;i++){
            for(int j = columnStart; j <= columnEnd;j++){
                if(scoresheet[i][j] == null){
                    return false;
                }
            }
        }
        return true;
    }
    
    
    public void setBonusToPlayer(int n){
        int sum = 0;
        
        //Is the  upperSection for player n full?
        if(scoresheetFull(1,6,n,n)){
            for(int i = 1; i<=6;i++){
                sum += Integer.parseInt(scoresheet[i][n]);
            }
            scoresheet[7][n] = String.valueOf(sum);
            
            //The player gets a bonus of 50 if the sum is > 63.
            if(sum > 63){
                scoresheet[8][n] = String.valueOf("50");
            }else{
                scoresheet[8][n] = String.valueOf("0");
            }
        }       
    }
    
    //subtotal = 0 (subtotal = sum of UpperSection)
    //total = 1;   (total = final score)
    
    public void setTotalScore(int player, int subtotal){
        int sum = 0;
        int start = 0;
        int end = 0;
        int sumTotal = 0;
        
        if(subtotal == 0){
            start = 1;
            end = 6;
            sumTotal = 8;
        }
        
        if(subtotal == 1){
            start = 7;
            end = 17;
            sumTotal = 18;
        }
        
        //scoresheet[7][n] = scoresheet[1][n] + ... + scoresheet[6][n]
        if(scoresheetFull(start,end,player,player)){
            for(int i = start; i<=end;i++){
                sum += Integer.parseInt(scoresheet[i][player]);
            }
            scoresheet[sumTotal][player] = String.valueOf(sum);
        }       
    }
    
    //The game is over when the scoresheet is full.
    public boolean gameOver(){
        int columns = scoresheet[0].length-1;
              
        if(scoresheetFull(0,18,0,columns)){
            return true;
        }  
        return false;
    }         
}
