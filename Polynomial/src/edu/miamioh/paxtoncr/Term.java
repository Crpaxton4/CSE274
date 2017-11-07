/**
 * 
 */
package edu.miamioh.paxtoncr;

/**
 * @author Chris Paxton
 *
 */
public class Term implements Comparable<Term> {

	private int exp;
	private int coef;

	/**
	 * @param coef
	 * @param exp
	 */
	public Term(int coef, int exp) {
		this.coef = coef;
		this.exp = exp;
	}

	public void addTerm(Term t) {
		if (t.compareTo(this) == 0) {
			this.coef += t.coef;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("+%dx^%d", coef, exp);
	}

	/**
	 * @return
	 */
	public int getExp() {
		return exp;
	}

	/**
	 * @return
	 */
	public int getCoef() {
		return coef;
	}

	@Override
	public int compareTo(Term other) {
		if (this.exp > other.exp)
			return -1;
		
		else if (this.exp < other.exp)
			return 1;
		
		else
			return 0;
	}

	public static Term multiplyTerms(Term t1, Term t2) {
		int newExp = t1.exp + t2.exp;
		int newCoef = t1.coef * t2.coef;
		Term result = new Term(newCoef, newExp);
		
		return result;
	}
	
	public static Term addTerms(Term t1, Term t2){
		int exp = t1.getExp();
		int newCoef = t1.coef + t2.coef;
		Term result = new Term(newCoef, exp);
		return result;
	}
	
	public boolean equals(Term other){
		if(this.coef == other.coef && this.exp == other.exp){
			return true;
		}
		
		return false;
	}

}
