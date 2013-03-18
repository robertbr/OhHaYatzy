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

import yatzy.ScoreCalculator;

/**
 *
 * @author robertbr
 */

public class ScoreCalculatorTest {
    
    ScoreCalculator calc;
    
    public ScoreCalculatorTest() {
        
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
    public void testUpperSectionOnes(){
        calc = new ScoreCalculator(1,2,3,1,1);
        assertEquals(3,calc.UpperSection(1));       
    }
    
    @Test
    public void testUpperSectionSixes(){
        calc = new ScoreCalculator(6,6,4,6,6);
        assertEquals(24,calc.UpperSection(6));    
    }
    
    @Test
    public void testUpperSectionZero(){
        calc = new ScoreCalculator(6,6,4,6,6);
        assertEquals(0,calc.UpperSection(5));     
    }
    
    @Test
    public void testNOfAKindYatzy(){
        calc = new ScoreCalculator(4,4,4,4,4);
        assertEquals(50,calc.NOfAKind(5));      
    }
    
    @Test
    public void testNOfAKindNoYatzy(){
        calc = new ScoreCalculator(4,4,4,4,5);
        assertEquals(0,calc.NOfAKind(5));      
    }
    
    @Test
    public void testNOfAKindPairOfFours(){
        calc = new ScoreCalculator(4,4,4,4,4);
        assertEquals(8,calc.NOfAKind(2));     
    }
    
    @Test
    public void testNOfAKindPairOfSixes(){
        calc = new ScoreCalculator(6,4,6,4,6);
        assertEquals(12,calc.NOfAKind(2));      
    }
    
    @Test
    public void testNOfAKindThreeOfAKind(){
        calc = new ScoreCalculator(2,2,1,2,3);
        assertEquals(6,calc.NOfAKind(3));      
    }
    
    @Test
    public void testNOfAKindThreeOfAKindInYatzy(){
        calc = new ScoreCalculator(2,2,2,2,2);
        assertEquals(6,calc.NOfAKind(3));       
    }
    
    @Test
    public void testFullHouse(){
        calc = new ScoreCalculator(3,3,5,3,5);
        assertEquals(3*3+5*2,calc.FullHouse());        
    }
    
    @Test
    public void testFullHouseNoHouseButYatzy(){
        calc = new ScoreCalculator(3,3,3,3,3);
        assertEquals(0,calc.FullHouse());       
    }
    
    @Test
    public void testFullHouseNoHouseButThreeOfAKind(){
        calc = new ScoreCalculator(6,3,3,3,5);
        assertEquals(0,calc.FullHouse());       
    }
    
    @Test
    public void testChance(){
        calc = new ScoreCalculator(2,6,3,3,5);
        assertEquals(19,calc.Chance());      
    }
    
    @Test
    public void testTwoPairs(){
        calc = new ScoreCalculator(5,6,6,4,5);
        assertEquals(22,calc.TwoPairs());      
    }
    
    @Test
    public void testTwoPairsInAFullHand(){
        calc = new ScoreCalculator(5,4,4,5,5);
        assertEquals(18,calc.TwoPairs());     
    }
    
    @Test
    public void testStraightSmallStraight(){
        calc = new ScoreCalculator(1,3,5,2,4);
        assertEquals(15,calc.Straight(0));     
    }
    
    @Test
    public void testStraightNoSmallStraight(){
        calc = new ScoreCalculator(1,2,3,3,4);
        assertEquals(0,calc.Straight(0));     
    }
    
    @Test
    public void testStraightNoSmallStraightButBigStraight(){
        calc = new ScoreCalculator(2,3,4,6,5);
        assertEquals(0,calc.Straight(0));     
    }
    
    @Test
    public void testStraightBigStraight(){
        calc = new ScoreCalculator(2,6,4,3,5);
        assertEquals(21,calc.Straight(1));     
    }
    
    @Test
    public void testStraightNoBigStraight(){
        calc = new ScoreCalculator(2,6,4,4,5);
        assertEquals(0,calc.Straight(1));     
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
