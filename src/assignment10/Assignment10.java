package assignment10;

import polynomial.*;

/**
 *
 * @author Hendrik Werner // s4549775
 * @author Jasper Haasdijk // s4449754
 * @author Sjaak Smetsers
 */
public class Assignment10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Polynomial p1 = new Polynomial("3.0 1 2 3");
        Polynomial p2 = new Polynomial("4 0 5 3");
        Polynomial p3 = new Polynomial("4 0 -5 3");
        Polynomial p4 = new Polynomial("6 1");

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
    }

}
