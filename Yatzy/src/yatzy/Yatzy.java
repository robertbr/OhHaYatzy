
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
        Die noppa1 = new Die();
        System.out.println(noppa1.getValue());
        
        ScoreCalculator calc = new ScoreCalculator(6,6,4,6,6);
        System.out.println(calc.UpperSection(6));
    }

}
