package edu.grinnell.csc207.shujjah.utils;

import java.math.BigInteger;

//From the lab on classes

/**
 * A simple implementation of Fractions.
 * 
 * @author Samuel A. Rebelsky
 * @author YOUR NAME HERE
 * @author CSC152 2005S
 * @version 1.0 of February 2005
 */
// Tommy Pitcher worked with Zoe Wolter on the lab
// Camila Mateo worked with China
// Ameer Shujjah worked with Nick

public class Fraction {
	// +------------------+---------------------------------------------
	// | Design Decisions |
	// +------------------+
	/*
	 * (1) Denominators are always positive. Therefore, negative fractions are
	 * represented with a negative numerator. Similarly, if a fraction has a
	 * negative numerator, it is negative.
	 * 
	 * (2) Fractions are not necessarily stored in simplified form. To obtain a
	 * fraction in simplified form, one must call the simplify method.
	 */

	// +--------+-------------------------------------------------------
	// | Fields |
	// +--------+

	/** The numerator of the fraction. Can be positive, zero or negative. */
	BigInteger num;

	/** The denominator of the fraction. Must be non-negative. */
	BigInteger denom;

	// +--------------+-------------------------------------------------
	// | Constructors |
	// +--------------+

	/**
	 * Build a new fraction with numerator num and denominator denom.
	 * 
	 * Warning! Not yet stable.
	 */
	public Fraction(BigInteger num, BigInteger denom) {

		// Find the greatest common divisor and divide both the
		// numerator and denominator by that value
		BigInteger gcd = num.gcd(denom);
		this.num = num.divide(gcd);
		this.denom = denom.divide(gcd);
		if (num == BigInteger.valueOf(0)) {
			this.denom = BigInteger.valueOf(1);
		}// If the numerator is zero, assign 1 to the denominator

		if (denom.compareTo(BigInteger.valueOf(0)) == -1) {
			this.denom = denom.multiply(BigInteger.valueOf(-1));
			this.num = num.multiply(BigInteger.valueOf(-1));

		}// If the denominator is negative, switch the signs on both
			// the numerator and denominator

	}// Fraction(BigInteger, BigInteger)

	/**
	 * Build a new fraction with numerator num and denominator denom.
	 * 
	 * Warning! Not yet stable.
	 */
	public Fraction(int num, int denom) {

		this.num = BigInteger.valueOf(num);
		this.denom = BigInteger.valueOf(denom);
		BigInteger numerator = BigInteger.valueOf(num);
		BigInteger denominator = BigInteger.valueOf(denom);

		// Simplify the fraction

		// Find the greatest common divisor and divide both the
		// numerator and denominator by that value
		BigInteger gcd = numerator.gcd(denominator);
		this.num = numerator.divide(gcd);
		this.denom = denominator.divide(gcd);
		if (numerator == BigInteger.valueOf(0)) {
			this.denom = BigInteger.valueOf(1);
		}// If the numerator is zero, assign 1 to the denominator

		if (denominator.compareTo(BigInteger.valueOf(0)) == -1) {
			this.denom = denominator.multiply(BigInteger.valueOf(-1));
			this.num = numerator.multiply(BigInteger.valueOf(-1));
		}// If the denominator is negative, switch the signs on both
			// the numerator and denominator

	}// Fraction(int, int)

	/**
	 * Given any acceptable string that describes a fraction, build a new
	 * fraction using that string.
	 */
	public Fraction(String str) {
		int i;
		for (i = 0; i < str.length(); i++) {
			char temp = str.charAt(i);
			if (temp == '/')
				break;
		}
		if (i == str.length()) {
			this.num = BigInteger.valueOf(Integer.parseInt(str));
			this.denom = BigInteger.valueOf(1);
		} else {
			this.num = BigInteger
					.valueOf(Integer.parseInt(str.substring(0, i)));
			this.denom = BigInteger.valueOf(Integer.parseInt(str
					.substring(i + 1)));

		}
		// Simplify the fraction

		// Find the greatest common divisor and divide both the
		// numerator and denominator by that value
		BigInteger gcd = num.gcd(denom);
		this.num = num.divide(gcd);
		this.denom = denom.divide(gcd);
		if (num == BigInteger.valueOf(0)) {
			this.denom = BigInteger.valueOf(1);
		}// If the numerator is zero, assign 1 to the denominator

		if (denom.compareTo(BigInteger.valueOf(0)) == -1) {
			this.denom = denom.multiply(BigInteger.valueOf(-1));
			this.num = num.multiply(BigInteger.valueOf(-1));

		}// If the denominator is negative, switch the signs on both
			// the numerator and denominator
	}// Fraction(String)

	// +---------+------------------------------------------------------
	// | Methods |
	// +---------+

	/**
	 * Negate the given fraction.
	 */
	public Fraction negate() {
		BigInteger negate = BigInteger.valueOf(-1);
		BigInteger resultNumerator = this.num.multiply(negate);
		BigInteger resultDenominator = this.denom;
		return new Fraction(resultNumerator, resultDenominator);
	}// negate()

	/**
	 * Express this fraction as a double.
	 */
	public double doubleValue() {
		return this.num.doubleValue() / this.denom.doubleValue();
	}// doubleValue()

	/**
	 * Multiply this fraction with the input fraction.
	 */
	public Fraction multiply(Fraction multiplyme) {
		BigInteger resultNumerator;
		BigInteger resultDenominator;

		// Multiply the numerators and the denominators together.
		resultDenominator = this.denom.multiply(multiplyme.denom);
		resultNumerator = this.num.multiply(multiplyme.num);

		return new Fraction(resultNumerator, resultDenominator);
	}// multiply(Fraction)

	/**
	 * Subtract the input fraction from this fraction.
	 */
	public Fraction subtract(Fraction subtrahend) {
		BigInteger resultNumerator;
		BigInteger resultDenominator;

		resultDenominator = this.denom.multiply(subtrahend.denom);
		resultNumerator = (this.num.multiply(subtrahend.denom))
				.subtract(subtrahend.num.multiply(this.denom));

		return new Fraction(resultNumerator, resultDenominator);
	}// subtract(Fraction)

	/**
	 * Divide this fraction with the input fraction.
	 */
	public Fraction divide(Fraction divider) {
		BigInteger resultNumerator;
		BigInteger resultDenominator;

		resultDenominator = this.denom.multiply(divider.num);
		resultNumerator = this.num.multiply(divider.denom);
		return new Fraction(resultNumerator, resultDenominator);
	}// divide(Fraction)

	/**
	 * Add the fraction other to this fraction.
	 */
	public Fraction add(Fraction addMe) {
		BigInteger resultNumerator;
		BigInteger resultDenominator;

		// The denominator of the result is the
		// product of this object's denominator
		// and addMe's denominator
		resultDenominator = this.denom.multiply(addMe.denom);
		// The numerator is more complicated
		resultNumerator = (this.num.multiply(addMe.denom)).add(addMe.num
				.multiply(this.denom));

		// Return the computed value
		return new Fraction(resultNumerator, resultDenominator);
	}// add(Fraction)

	/**
	 * Raise this fraction to the given exponent.
	 */
	public Fraction pow(int expt) {
		BigInteger resultNumerator;
		BigInteger resultDenominator;
		if (expt < 0) {
			int temp = expt * -1;
			resultNumerator = this.num.pow(temp);
			resultDenominator = this.denom.pow(temp);
			return new Fraction(resultDenominator, resultNumerator);
		}// if exponent is negative

		resultNumerator = this.num.pow(expt);
		resultDenominator = this.denom.pow(expt);
		return new Fraction(resultNumerator, resultDenominator);
	}// pow(int)

	/**
	 * Convert this fraction to a string for ease of printing.
	 */
	public String toString() {
		// Special case: It's zero
		if (this.num.equals(BigInteger.ZERO)) {
			return "0";
		} // if it's zero

		// Lump together the string represention of the numerator,
		// a slash, and the string representation of the denominator
		// return this.num.toString().concat("/").concat(this.denom.toString());
		return this.num + "/" + this.denom;
	} // toString()
} // class Fraction

