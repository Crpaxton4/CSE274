package edu.miamioh.paxtoncr;

public class TEST {

	public static void main(String[] args){
		int[] coefs1 = {1, 2, 3, 4};
		int[] coefs2 = {4, 3, 2, 1};
		int[] exps = {3, 2, 1, 0};
		
		Polynomial poly = new Polynomial(coefs1, exps);
		Polynomial poly2 = new Polynomial(coefs2, exps);
		
		Polynomial poly3 = poly.add(poly2);
		
		System.out.println(poly3);
	}
}
