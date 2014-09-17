package edu.grinnell.csc207.shujjah.utils;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testEval0() {
		assertEquals(BigInteger.valueOf(0), Calculator.eval0("0"));
		assertEquals(BigInteger.valueOf(2), Calculator.eval0("1 + 1"));
		assertEquals(BigInteger.valueOf(4), Calculator.eval0("1 + 2 + 1"));
		assertEquals(BigInteger.valueOf(9), Calculator.eval0("1 + 2 * 3"));
	}

	@Test
	public void testEval1() {
		assertEquals("1/4", Calculator.eval1("1/2 * 1/2").toString());
		assertEquals("1/8", Calculator.eval1("1/2 ^ 3").toString());
		assertEquals("3/2", Calculator.eval1("1 + 1/2").toString());
		assertEquals("1/6", Calculator.eval1("1/2 / 3").toString());
		assertEquals("5/2", Calculator.eval1("4 - 3/2").toString());
	}
}
