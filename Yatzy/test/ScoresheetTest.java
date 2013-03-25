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

import yatzy.Scoresheet;

/**
 *
 * @author User
 */


public class ScoresheetTest {
    
    Scoresheet scoresheet;
    
    public ScoresheetTest() {
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
    public void testSetPoints(){
        scoresheet = new Scoresheet(3);
        scoresheet.setPoints(3, 2, 12);     
        assertEquals(12, scoresheet.getPoints(3, 2));       
    }
    
    @Test
    public void testGetPoints(){
        scoresheet = new Scoresheet(3);     
        assertEquals(-1, scoresheet.getPoints(3, 2));       
    }
    
    @Test
    public void testSetNames(){
        scoresheet = new Scoresheet(5);
        scoresheet.setName(0, 1, "Robert");     
        assertEquals("Robert", scoresheet.getName(0,1));       
    }
    
    @Test
    public void testScoresheetFullNotFull(){
        scoresheet = new Scoresheet(5);
        scoresheet.setName(0, 1, "Robert");  
        assertEquals(false, scoresheet.scoresheetFull(0, 18, 0, 5));  
              
    }
    
    @Test
    public void testGameOver(){
        scoresheet = new Scoresheet(2);      
        for(int i = 0; i < 19;i++){
            for(int j = 0; j < 3;j++){
                scoresheet.setName(i, j, "Not empty anymore");
            }
        }
        assertEquals(true, scoresheet.gameOver());  
   }
    
    @Test
    public void testSetBonusNoBonus(){
        scoresheet = new Scoresheet(3);
        scoresheet.setPoints(1, 2, 3);
        scoresheet.setPoints(2, 2, 6); 
        scoresheet.setPoints(3, 2, 9); 
        scoresheet.setPoints(4, 2, 12); 
        scoresheet.setPoints(5, 2, 15); 
        scoresheet.setPoints(6, 2, 18); 
        
        scoresheet.setBonusToPlayer(2);
        
        assertEquals(0, scoresheet.getPoints(8, 2));  
   }
    
    @Test
    public void testSetBonus(){
        scoresheet = new Scoresheet(3);
        scoresheet.setPoints(1, 2, 4);
        scoresheet.setPoints(2, 2, 6); 
        scoresheet.setPoints(3, 2, 9); 
        scoresheet.setPoints(4, 2, 12); 
        scoresheet.setPoints(5, 2, 15); 
        scoresheet.setPoints(6, 2, 18); 
        
        scoresheet.setBonusToPlayer(2);
        
        assertEquals(50, scoresheet.getPoints(8, 2));  
   }
    
    @Test
    public void testSetBonusUpperSectionNotFull(){
        scoresheet = new Scoresheet(3);
        scoresheet.setBonusToPlayer(2);
        
        assertEquals(-1, scoresheet.getPoints(8, 2));  
   }
    
    @Test
    public void testSetTotalScoreNotFullTotal(){
        scoresheet = new Scoresheet(3);
        scoresheet.setTotalScore(1,0);
        
        assertEquals(-1, scoresheet.getPoints(8, 2));  
   }
    
    @Test
    public void testSetTotalScoreNotFullSubtotal(){
        scoresheet = new Scoresheet(3);
        scoresheet.setPoints(1, 2, 4);
        scoresheet.setPoints(2, 2, 6); 
        scoresheet.setPoints(3, 2, 9); 
        scoresheet.setPoints(4, 2, 12); 
        scoresheet.setPoints(5, 2, 15);
        scoresheet.setTotalScore(2,0);
        
        assertEquals(-1, scoresheet.getPoints(8, 2));  
   }
    
    @Test
    public void testSetTotalScoreFullSubtotal(){
        scoresheet = new Scoresheet(3);
        scoresheet.setPoints(1, 2, 4);
        scoresheet.setPoints(2, 2, 6); 
        scoresheet.setPoints(3, 2, 9); 
        scoresheet.setPoints(4, 2, 12); 
        scoresheet.setPoints(5, 2, 15);
        scoresheet.setPoints(6, 2, 24);
        scoresheet.setTotalScore(2,0);
        
        assertEquals(70, scoresheet.getPoints(8, 2));  
   }
    
    @Test
    public void testSetTotalScoreFullTotal(){
        scoresheet = new Scoresheet(3);
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
        
        assertEquals(325, scoresheet.getPoints(18, 2));  
   }
 

    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
