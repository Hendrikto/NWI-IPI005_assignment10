package polynomial;

import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hendrik
 */
public class TermTest {

    public TermTest() {
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

    /**
     * Test of getExp method, of class Term.
     */
    @Test
    public void testGetExp() {
        System.out.println("getExp");
        assertEquals(new Term(1, 1).getExp(), 1);
        assertEquals(new Term(1, 0).getExp(), 0);
        assertEquals(new Term(1, -1).getExp(), -1);
    }

    /**
     * Test of getCoef method, of class Term.
     */
    @Test
    public void testGetCoef() {
        System.out.println("getCoef");
        assertEquals(new Term(1, 1).getCoef(), 1, 0);
        assertEquals(new Term(0, 1).getCoef(), 0, 0);
        assertEquals(new Term(-1, 1).getCoef(), -1, 0);
        assertEquals(new Term(0.5, 1).getCoef(), 0.5, 0);
    }

    /**
     * Test of plus method, of class Term.
     */
    @Test
    public void testPlus() {
        int exp = 4;
        System.out.println("plus");
        Term instance = new Term(2, exp);
        instance.plus(instance);
        assertEquals(instance.getCoef(), 4, 0);
        instance.plus(new Term(0, exp));
        assertEquals(instance.getCoef(), 4, 0);
        instance.plus(new Term(-2, exp));
        assertEquals(instance.getCoef(), 2, 0);
        assertEquals(instance.getExp(), exp);
    }

    /**
     * Test of times method, of class Term.
     */
    @Test
    public void testTimes() {
        System.out.println("times");
        Term t = null;
        Term instance = null;
        instance.times(t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Term.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Term instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Term.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object may_be_term = null;
        Term instance = null;
        boolean expResult = false;
        boolean result = instance.equals(may_be_term);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of scanTerm method, of class Term.
     */
    @Test
    public void testScanTerm() {
        System.out.println("scanTerm");
        Scanner s = null;
        Term expResult = null;
        Term result = Term.scanTerm(s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
