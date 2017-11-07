package edu.miamioh.paxtoncr;

import static org.junit.Assert.*;

import org.junit.Test;

public class PolynomialTest {

	@Test
	public void defaultConstructorTest() {
		Polynomial p = new Polynomial();
		assertTrue(p.toString().equals("0x^1"));
	}

	@Test
	public void arrayConstructorTest() {
		int[] coefs = { 2, 4, 6, 3 };
		int[] exps = { 3, 2, 1, 0 };
		Polynomial p = new Polynomial(coefs, exps);
		assertTrue(p.equals(new Polynomial("2x^3+4x^2+6x^1+3x^0")));
	}

	@Test
	public void copyConstructorTest() {
		int[] coefs = { 2, 4, 6, 3 };
		int[] exps = { 3, 2, 1, 0 };
		Polynomial p1 = new Polynomial(coefs, exps);
		Polynomial p2 = new Polynomial(p1);

		assertTrue(p1.equals(p2));
	}

	@Test
	public void addPloynomialsTest() {
		int[] coefs1 = { -3, 2, 15 };
		int[] coefs2 = { 1, -1, 6, -7 };
		int[] exps1 = { 3, 2, 0 };
		int[] exps2 = { 3, 2, 1, 0 };

		Polynomial p1 = new Polynomial(coefs1, exps1);
		Polynomial p2 = new Polynomial(coefs2, exps2);
		Polynomial expected = Polynomial.parse("-2x^3+1x^2+6x^1+8x^0");

		p1.add(p2);

		assertTrue(p1.equals(expected));
		
		p1 = new Polynomial();
		p2 = new Polynomial();
		expected = new Polynomial();
		
		p1.add(p2);

		assertTrue(p1.equals(expected));
		
	}

	@Test
	public void multiplyPolynomialsTest() {
		int[] coefs1 = { 1, 1 };
		int[] coefs2 = { 1, 1 };
		int[] exps = { 1, 0 };

		Polynomial p1 = new Polynomial(coefs1, exps);
		Polynomial p2 = new Polynomial(coefs2, exps);
		Polynomial expected = new Polynomial("1x^2+2x^1+1x^0");

		Polynomial result = p1.multiply(p2);

		assertTrue(result.equals(expected));
		
		p1 = new Polynomial();
		p2 = new Polynomial();
		expected = new Polynomial();
		
		result = p1.multiply(p2);
		
		assertTrue(result.equals(expected));
	}

	@Test
	public void negatePolynomialTest() {
		Polynomial p = new Polynomial("2x^2-1x^1+4x^0");
		Polynomial expected = new Polynomial("-2x^2+1x^1-4x^0");

		Polynomial negated = p.negate();

		assertTrue(negated.equals(expected));
		
		p = new Polynomial();
		expected = new Polynomial();
		
		negated = p.negate();
		
		assertTrue(negated.equals(expected));

		
	}

	@Test
	public void subtractPolynomialTest() {
		int[] coefs1 = { 1, 1, -1};
		int[] exps1 = { 1, 0, 3};
		int[] coefs2 = {1, 2, 3};
		int[] exps2 = { 2, 1, 3};

		Polynomial p1 = new Polynomial(coefs1, exps1);
		Polynomial p2 = new Polynomial(coefs2, exps2);
		Polynomial expected = new Polynomial("-4x^3-1x^2-1x^1+1x^0");

		Polynomial sub = p1.subtract(p2);

		assertTrue(sub.equals(expected));
		
		
		p1 = new Polynomial();
		p2 = new Polynomial();
		expected = new Polynomial();
		
		sub = p1.subtract(p2);
		
		assertTrue(sub.equals(expected));

	}

	 @Test
	 public void evaluatePolynomialTest() {
		 Polynomial p = new Polynomial("-4x^3-1x^2-1x^1+1x^0");
		 int x = 3;
		 double ans = -119;
		 
		 assertEquals(ans, p.evaluate(x), 0.001);
		 
		 p = new Polynomial();
		 ans = 0;
		 
		 assertEquals(ans, p.evaluate(x), 0.001);
	 }
	

	@Test
	public void equalityTest() {
		Polynomial p1 = new Polynomial("-12x^5+1x^4+4x^3-5x^2-27x^1+20x^0");
		Polynomial p2 = new Polynomial("-12x^5-5x^2+20x^0+1x^4+4x^3-27x^1");

		assertTrue(p1.equals(p2));
		
		p1 = new Polynomial();
		p2 = new Polynomial();
		
		assertTrue(p1.equals(p2));		
	}
}
