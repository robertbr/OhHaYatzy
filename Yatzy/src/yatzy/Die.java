/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



package yatzy;

import java.util.Random;

/**
 *
 * @author robertbr
 */
public class Die {
    
    private int dieValue = 0;
    
    public Die(){
        Random ran = new Random();
        dieValue = ran.nextInt(6)+1;
    }
    public int getValue(){
        return dieValue;
    }
    
}
