/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import yatzy.Die;

/**
 *
 * @author robertbr
 */
public class DieTest {
    
    Die die;
    
    public DieTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test   
    public void testDieValueBetweenOneAndSix(){
        Boolean dieValueBetweenOneAndSix = true;
        //We throw the die 1000 times to check, then we know that it is probably true
        int i = 0;
        while(i<1000){
            die = new Die();
            if(die.getValue()<1 || die.getValue()>6){
                dieValueBetweenOneAndSix = false;
            }
            i++;
        }
        assertEquals(true,dieValueBetweenOneAndSix);
        
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
