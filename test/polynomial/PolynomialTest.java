package polynomial;

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
public class PolynomialTest {

    public PolynomialTest() {
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
     * Test of toString method, of class Polynomial.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        assertEquals(new Polynomial("3.0 1 2 3").toString(), "+3,000000x +2,000000x^3");
        assertEquals(new Polynomial("4 0 5 3").toString(), "+4,000000 +5,000000x^3");
        assertEquals(new Polynomial("4 0 -5 3").toString(), "+4,000000 -5,000000x^3");
        assertEquals(new Polynomial("6 1").toString(), "+6,000000x");
        assertEquals(new Polynomial("").toString(), "");
    }

    /**
     * Test of plus method, of class Polynomial.
     */
    @Test
    public void testPlus() {
        System.out.println("plus");
        Polynomial i = new Polynomial("1 0");
        i.plus(new Polynomial(""));
        assertEquals(i, new Polynomial("1 0"));
        i.plus(new Polynomial("2 0"));
        assertEquals(i, new Polynomial("3 0"));
        i.plus(new Polynomial("-3 0"));
        assertEquals(i, new Polynomial(""));
        i.plus(new Polynomial("1 0 5 6"));
        assertEquals(i, new Polynomial("1 0 5 6"));
        i = new Polynomial("1 0");
        i.plus(new Polynomial("1 0 3 4"));
        assertEquals(i, new Polynomial("2 0 3 4"));
        i = new Polynomial("1 1");
        i.plus(new Polynomial("1 0"));
        assertEquals(i, new Polynomial("1 0 1 1"));
        i = new Polynomial("1 0 1 1");
        i.plus(new Polynomial("1 2"));
        assertEquals(i, new Polynomial("1 0 1 1 1 2"));
        Polynomial a = new Polynomial("4 2 -3 3");
        Polynomial b = new Polynomial("2 1 1 2");
        Polynomial c = new Polynomial("1 3");
        assertEquals(new Polynomial(a).plus(b), new Polynomial(b).plus(a));
        assertEquals(new Polynomial(a).plus(b).plus(c), new Polynomial(b).plus(c).plus(a));
    }

    /**
     * Test of minus method, of class Polynomial.
     */
    @Test
    public void testMinus() {
        System.out.println("minus");
        Polynomial b = null;
        Polynomial instance = new Polynomial();
        instance.minus(b);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of times method, of class Polynomial.
     */
    @Test
    public void testTimes() {
        System.out.println("times");
        Polynomial i = new Polynomial("1 2 2 3");
        assertEquals(i, i);
        assertEquals(new Polynomial(i).times(new Polynomial("1 0")), i);
        assertEquals(new Polynomial(i).times(new Polynomial("2 0")), new Polynomial("2 2 4 3"));
        assertEquals(new Polynomial(i).times(new Polynomial("1 1")), new Polynomial("1 3 2 4"));
    }

    /**
     * Test of divide method, of class Polynomial.
     */
    @Test
    public void testDivide() {
        System.out.println("divide");
        // not implemented as per specification
    }

    /**
     * Test of equals method, of class Polynomial.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Polynomial i = new Polynomial("4 0 -5 3");
        assertTrue(new Polynomial("").equals(new Polynomial("")));
        assertTrue(new Polynomial("6 0").equals(new Polynomial("6 0")));
        assertTrue(i.equals(new Polynomial("4 0 -5 3")));
        assertTrue(i.equals(i));
        assertFalse(new Polynomial("").equals(new Polynomial("1 0")));
        assertFalse(new Polynomial("1 0").equals(new Polynomial("6 0")));
        assertFalse(i.equals(new Polynomial("4 1 -5 3")));
    }

    /**
     * Test of distributivity. Involves the plus and times methods.
     */
    @Test
    public void testDistributivity() {
        System.out.println("distributivity");
        Polynomial a = new Polynomial("-1 2");
        Polynomial b = new Polynomial("3 2");
        Polynomial c = new Polynomial("2 2");
        assertEquals(
                new Polynomial(a).times(new Polynomial(b).plus(c)),
                new Polynomial(new Polynomial(a).times(b))
                        .plus(new Polynomial(a).times(c))
        );
    }

}
