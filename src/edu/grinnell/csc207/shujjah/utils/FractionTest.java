package edu.grinnell.csc207.shujjah.utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class FractionTest {

	@Test
	public void testFractionString() {
		Fraction test = new Fraction("1/4");
		assertEquals("1", test.num.toString());
		assertEquals("4", test.denom.toString());
	}

	@Test
	public void testNegate() {
		Fraction test = new Fraction("3/2");
		assertEquals("-3/2", test.negate().toString());
	}

	@Test
	public void testMultiply() {
		Fraction test = new Fraction("1/2");
		Fraction stest = new Fraction("1/4");
		assertEquals("1/8", test.multiply(stest).toString());
	}

	@Test
	public void testSubtract() {
		Fraction test = new Fraction("7/2");
		Fraction stest = new Fraction("5/2");
		assertEquals("1/1", test.subtract(stest).toString());
	}

	@Test
	public void testDivide() {
		Fraction test = new Fraction("1/2");
		Fraction stest = new Fraction("3/1");
		assertEquals("1/6", test.divide(stest).toString());
	}

	@Test
	public void testPow() {
		Fraction test = new Fraction("1/2");
		assertEquals("8/1", test.pow(-3).toString());
	}
}
