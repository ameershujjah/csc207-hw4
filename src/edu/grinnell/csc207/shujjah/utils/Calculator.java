package edu.grinnell.csc207.shujjah.utils;

import java.math.BigInteger;

public class Calculator {
	/**
	 * Given a string, evaluate the expression in the string and return a
	 * BigInteger
	 */
	public static BigInteger eval0(String str) {

		// Initialize an empty array of strings for the numbers,
		// an array of characters for the operators, opIterator and
		// numIterator to keep track of the aforementioned arrays.
		// Also initialize a String buffer and a temp char.
		char temp;
		String[] numbers = new String[str.length()];
		char[] operators = new char[str.length() / 2];
		int opIterator = 0;
		int numIterator = 0;
		String buffer = "";

		// Loop through all the characters in the string.
		for (int i = 0; i < str.length(); i++) {
			temp = str.charAt(i);
			if (temp == ' ') {
				numbers[numIterator] = buffer;
				buffer = "";
				numIterator++;
			}// If temp is an empty space, add the buffer to the String array
				// and empty the buffer.
			else if (temp == '+' || temp == '-' || temp == '*' || temp == '/'
					|| temp == '^') {
				operators[opIterator] = temp;
				opIterator++;
				i++;
			}// If temp is one of the operands, add it to the operands array and
				// increment i to skip the white space
			else {
				buffer += temp;
			}// Else add the character to the buffer
		} // End for loop

		// Add the final buffer to the String array
		numbers[numIterator] = buffer;

		// Convert the first number from a string to a bigInteger
		BigInteger result = BigInteger.valueOf(Integer.parseInt(numbers[0]));

		// Loop through all the operands to calculate the result
		for (int i = 1; i <= opIterator; i++) {
			Integer operand = Integer.parseInt(numbers[i]);
			// Using a switch statement, do the operations contained in the
			// operators array
			switch (operators[i - 1]) {
			case '+':
				result = result.add(BigInteger.valueOf(operand));
				break;
			case '-':
				result = result.subtract(BigInteger.valueOf(operand));
				break;
			case '*':
				result = result.multiply(BigInteger.valueOf(operand));
				break;
			case '/':
				result = result.divide(BigInteger.valueOf(operand));
				break;
			case '^':
				result = result.pow(operand);
				break;
			} // End switch statement
		} // End calculation for loop

		return result;
	} // End eval0(String)

	/**
	 * Given a string, evaluate the expression in the string and return a
	 * Fraction
	 */
	public static Fraction eval1(String str) {

		// Initialize an empty array of strings for the fractions,
		// an array of characters for the operators, opIterator and
		// fracIterator to keep track of the aforementioned arrays.
		// Also initialize a String buffer and a temp char and a
		// boolean to differentiate the fraction from the operand /.
		String[] fractions = new String[str.length()];
		char[] operators = new char[str.length()];
		int opIterator = 0;
		int fracIterator = 0;
		String buffer = "";
		char temp;
		boolean fracSwitch = false;

		// Iterate over all the characters in the string.
		for (int i = 0; i < str.length(); i++) {
			temp = str.charAt(i);
			if (temp == ' ') {
				fracSwitch = false;
				fractions[fracIterator] = buffer;
				buffer = "";
				fracIterator++;
			}// If temp is an empty space, add the buffer to the String array
				// and empty the buffer
			else if (temp == '/' && fracSwitch) {
				buffer += temp;
			}// If temp is a /, and fracSwitch is true, add it to the buffer
			else if (temp == '+' || temp == '-' || temp == '*' || temp == '/'
					|| temp == '^' && !fracSwitch) {
				System.out.println(opIterator);
				operators[opIterator] = temp;
				opIterator++;
				i++;
			}// If temp is an operand, add it to the operators array and
				// increment it to skip the white space
			else {
				buffer += temp;
				fracSwitch = true;
			}// Else add the temp to the buffer
		}// End for loop

		// Add the last buffer to the fractions array
		fractions[fracIterator] = buffer;

		// Convert the first fraction in the fractions strings into a
		// Fraction object.
		Fraction result = new Fraction(fractions[0]);

		// Loop through all the operands
		for (int i = 1; i <= opIterator; i++) {
			Fraction operand = new Fraction(fractions[i]);

			// Switch statement to do the operations
			switch (operators[i - 1]) {
			case '+':
				result = result.add(operand);
				break;
			case '-':
				result = result.subtract(operand);
				break;
			case '*':
				result = result.multiply(operand);
				break;
			case '/':
				result = result.divide(operand);
				break;
			case '^':
				result = result.pow(Integer.parseInt((fractions[i])));
				break;
			} // End switch statement
		} // End calculation for-loop
		return result;
	}// eval1(String)
}// End Class
