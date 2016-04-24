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
        Term i1 = new Term(2, 3);
        Term i2 = new Term(2, 4);
        i2.times(i1);
        assertEquals(i2.getCoef(), 4, 0);
        assertEquals(i2.getExp(), 7);
        i2 = new Term(0, 1);
        i2.times(i1);
        assertEquals(i2.getCoef(), 0, 0);
        assertEquals(i2.getExp(), 4);
        i2 = new Term(-1, -1);
        i2.times(i1);
        assertEquals(i2.getCoef(), -2, 0);
        assertEquals(i2.getExp(), 2);

    }

    /**
     * Test of toString method, of class Term.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        assertEquals(new Term(1, 4).toString(), "+1,000000x^4");
        assertEquals(new Term(1, 1).toString(), "+1,000000x");
        assertEquals(new Term(0, 4).toString(), "+0,000000x^4");
        assertEquals(new Term(1, 0).toString(), "+1,000000");
        assertEquals(new Term(0, 0).toString(), "+0,000000");
    }

    /**
     * Test of equals method, of class Term.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        assertEquals(new Term(2, 4), new Term(2, 4));
        assertEquals(new Term(-0, 4), new Term(+0, 4));
        assertEquals(new Term(2, -0), new Term(2, +0));
    }

    /**
     * Test of scanTerm method, of class Term.
     */
    @Test
    public void testScanTerm() {
        System.out.println("scanTerm");
        assertEquals(Term.scanTerm(new Scanner("2 5")), new Term(2, 5));
        assertEquals(Term.scanTerm(new Scanner("-2 5")), new Term(-2, 5));
        assertEquals(Term.scanTerm(new Scanner("2 -5")), new Term(2, -5));
        assertEquals(Term.scanTerm(new Scanner("0 0")), new Term(0, 0));
    }

}
