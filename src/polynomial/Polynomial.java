package polynomial;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * A skeleton class for representing Polynomials
 *
 * @author Sjaak Smetsers
 * @date 19-04-2016
 */
public class Polynomial {

    /**
     * A polynomial is a sequence of terms here kept in an List
     */
    List<Term> terms;

    /**
     * A constructor for creating the zero Polynomial zero is presented as an
     * empty list of terms and not as a single term with 0 as a coefficient
     */
    public Polynomial() {
        terms = new LinkedList<>();
    }

    /**
     * A Constructor creating a polynomial from the argument string.
     *
     * @param s a String representing a list of terms which is converted to a
     * scanner and passed to scanTerm for reading each individual term
     */
    public Polynomial(String s) {
        terms = new LinkedList<>();
        Scanner scan = new Scanner(s);

        for (Term t = Term.scanTerm(scan); t != null; t = Term.scanTerm(scan)) {
            terms.add(t);
        }
    }

    /**
     * The copy constructor for making a deep copy
     *
     * @param p the copied polynomial
     *
     */
    public Polynomial(Polynomial p) {
        terms = new LinkedList<>();
        for (Term t : p.terms) {
            terms.add(new Term(t));
        }
    }

    /**
     * A straightforward conversion of a Polynomial into a string based on the
     * toString for terms
     *
     * @return a readable string representation of this
     */
    @Override
    public String toString() {
        if (terms.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        ListIterator<Term> i = terms.listIterator();
        while (i.hasNext()) {
            sb.append(i.next()).append(' ');
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    /**
     * Add a polynomial to this.
     *
     * @param b the polynomial to add
     */
    public Polynomial plus(Polynomial b) {
        for (Term t : b.terms) {
            this.plus(t);
        }
        return this;
    }

    public void minus(Polynomial b) {
    }

    public void times(Polynomial b) {
    }

    public void divide(Polynomial b) {
    }

    @Override
    public boolean equals(Object otherPoly) {
        if (otherPoly == null || otherPoly.getClass() != getClass()) {
            return false;
        } else {
            Polynomial b = (Polynomial) otherPoly;
            if (terms.size() != b.terms.size()) {
                return false;
            }
            ListIterator<Term> iteratorA = terms.listIterator();
            ListIterator<Term> iteratorB = b.terms.listIterator();
            while (iteratorA.hasNext()) {
                if (!iteratorA.next().equals(iteratorB.next())) {
                    return false;
                }
            }
            return true;
        }
    }

    private void plus(Term b) {
        ListIterator<Term> i = terms.listIterator();
        Term a;
        while (i.hasNext()) {
            a = i.next();
            if (a.getExp() == b.getExp()) {
                a.plus(b);
                if (a.getCoef() == 0) {
                    i.remove();
                }
                return;
            } else if (a.getExp() > b.getExp()) {
                i.previous();
                i.add(b);
                return;
            }
        }
        i.add(b);
    }

}
