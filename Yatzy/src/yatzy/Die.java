/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yatzy;

/**
 *
 * @author robertbr
 */
public class Die {
    
    private int dieValue = 0;
    
    public Die(){
        dieValue = (int) (6.0*Math.random()+1);
    }
    public int getValue(){
        return dieValue;
    }
    
}
