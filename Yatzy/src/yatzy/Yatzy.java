
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package yatzy;

/**
 *
 * @author Robert
 */
public class Yatzy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scoresheet scoresheet = new Scoresheet(3);
        scoresheet.setName(0, 2, "Robert");
        scoresheet.setPoints(1, 2, 4);
        scoresheet.setPoints(2, 2, 6); 
        scoresheet.setPoints(3, 2, 9); 
        scoresheet.setPoints(4, 2, 12); 
        scoresheet.setPoints(5, 2, 15);
        scoresheet.setPoints(6, 2, 24);
        scoresheet.setTotalScore(2,0);
        scoresheet.setBonusToPlayer(2);
        scoresheet.setPoints(9, 2, 12);
        scoresheet.setPoints(10, 2, 22);
        scoresheet.setPoints(11, 2, 18);
        scoresheet.setPoints(12, 2, 24);
        scoresheet.setPoints(13, 2, 0);
        scoresheet.setPoints(14, 2, 21);
        scoresheet.setPoints(15, 2, 28);
        scoresheet.setPoints(16, 2, 30);
        scoresheet.setPoints(17, 2, 50);
        scoresheet.setTotalScore(2,1);
        
        
        for(int i = 1; i<19;i++){
            int test = scoresheet.getPoints(i, 2);
            System.out.println(test);
        }
    }
}
