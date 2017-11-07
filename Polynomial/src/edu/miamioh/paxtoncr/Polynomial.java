/**
 * 
 */
package edu.miamioh.paxtoncr;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * @author Chris Paxton
 *
 */
public class Polynomial {

	ArrayList<Term> terms = new ArrayList<>();

	/**
	 * Creates a default Polynomial [0x^1]
	 */
	public Polynomial() {
		// create the polynomial 0x^1
		Term term = new Term(0, 1);
		terms.add(term);
	}

	/**
	 * Cerates a Polynomial with the given set of coefficients and exponents
	 * @param coefs
	 * @param exps
	 */
	public Polynomial(int[] coefs, int[] exps) {
		// create polynomial given coef/exponent pairs
		for (int i = 0; i < coefs.length; i++) {
			Term termToAdd = new Term(coefs[i], exps[i]);
			addTerm(termToAdd);
		}
	}

	/**
	 * Creates a copy of Polynomial p
	 * @param p
	 */
	public Polynomial(Polynomial p) {
		// create a deep copy of a polynomial
		for (Term t : p.terms) {
			addTerm(t);
		}
	}

	/**
	 * Creates Polynomial based on String [See Polynomial.parse(String)]
	 * @param poly
	 */
	public Polynomial(String poly) {
		this(Polynomial.parse(poly));
	}
	
	private Polynomial(ArrayList<Term> termsToAdd) {
		for (Term t : termsToAdd) {
			addTerm(t);
		}
	}
	
	private void addTerm(Term term) {
		// find match exponent
		// if one, add in term.coef. If that results in a 0 coef, remove the term
		// if no match, put term in proper spot.
		
		for(int i = 0; i < terms.size(); i++){
			
			if(terms.get(i).compareTo(term) == 0){
				terms.get(i).addTerm(term);
				return;
			}
			
		}

		terms.add(term);
		Collections.sort(terms);
	}

	/**
	 * Adds two Polynomials
	 * @param p
	 * @return Result of adding two Polynomials
	 */
	public Polynomial add(Polynomial p) {
		// return the addition of two polys
		ArrayList<Term> combined = new ArrayList<>(terms);
		combined.addAll(p.terms);
		return new Polynomial(combined);
	}

	/**
	 * Multiplies two polynomials
	 * @param p
	 * @return Result of multiplying two Polynomials
	 */
	public Polynomial multiply(Polynomial p) {
		// return the multiplication of two polys
		if(this.terms.size() == 1 && this.terms.get(0).getCoef() == 0){  // Handle default polynomial
			return new Polynomial();
		}
		
		ArrayList<Term> multiplied = new ArrayList<>();
		for(Term t1 : terms){
			for(Term t2 : p.terms){
				multiplied.add(Term.multiplyTerms(t1, t2));
			}
		}
		
		return new Polynomial(multiplied);
	}

	/**
	 * Negates the Polynomial
	 * @return Negated Polynomial
	 */
	public Polynomial negate() {
		// return the negation of poly, leave the original unchanged
		Polynomial negated;

		int[] coefs = new int[terms.size()];
		int[] exps = new int[terms.size()];

		for (int i = 0; i < terms.size(); i++) {
			coefs[i] = -terms.get(i).getCoef();
			exps[i] = terms.get(i).getExp();
		}
		
		negated = new Polynomial(coefs, exps);
		return negated;
	}

	/**
	 * Subtracts two polynomials
	 * @param p
	 * @return result of this Polynomial - p
	 */
	public Polynomial subtract(Polynomial p) {
		// return the subtraction of two polys
		return add(p.negate());
	}

	/**
	 * Computes the value of the Polynomial given an X value
	 * @param x
	 * @return Value given X
	 */
	public double evaluate(double x) {
		// evaluates the polynomial at a particular value
		double total = 0;
		for(Term term : terms){
			total += term.getCoef() * Math.pow(x, term.getExp());
		}
		return total;
	}

	/**
	 * Checks if two polynomials are equivalent
	 * @param other
	 * @return True if polynomials are equivalent. False otherwise.
	 */
	public boolean equals(Polynomial other) {
		// true iff the polynomials are logically equivalent
		boolean match = false;
		
		if(this.terms.size() == 1 && other.terms.size() == 1){  // Handle default polynol
			return terms.get(0).equals(other.terms.get(0));
		}

		for (Term term : terms) {
			if (term.getCoef() != 0) {
				match = false;
				for (Term otherTerm : other.terms) {
					if (otherTerm.equals(term)) {
						match = true;
					}
				}

				if (!match) {
					return match;
				}
			}

		}
		
		return match;
	}

	/**
	 * Returns the String representation of the Polynomial 
	 * @return 
	 */
	public String toString() {
		// crate canonical string representation
		
		if(terms.size() == 1 && terms.get(0).getCoef() == 0){  // default (poly = 0x^1) case
			return terms.get(0).toString().substring(1);  
		}
		
		String s = "";
		for(Term term : terms){
			if(term.getCoef()!= 0){
				s += term.toString();
			}
		}
		
		return s.substring(1).replaceAll("\\+-", "-");
	}

	/**
	 * Creates a new Polynomial from a string representation. If the String is invalid a default Polynomial (0x^1) is returned
	 * @param str String representation of a Polynomial
	 * @return A new Polynomial that matches the string
	 */
	public static Polynomial parse(String str) {
		// convert string representation to polynomial

		// replace each - with +- then split at
		ArrayList<Term> newTerms = new ArrayList<>();

		str = str.replaceAll("-", "\\+-");

		String[] termStrings = str.split("\\+");

		for (String term : termStrings) {
			String[] nums = term.split("x\\^");

			if (!nums[0].equals("")) {
				Term t;
				try {
					t = new Term(Integer.parseInt(nums[0]), Integer.parseInt(nums[1]));
				} catch (Exception e) {
					return new Polynomial();
				}
				newTerms.add(t);
			}
		}

		return new Polynomial(newTerms);
	}
}
