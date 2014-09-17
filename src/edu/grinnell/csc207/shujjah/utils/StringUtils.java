package edu.grinnell.csc207.shujjah.utils;

import java.util.ArrayList;
	// Citations:
	// http://stackoverflow.com/questions/1921181/java-arraylist-of-string-arrays
	// http://stackoverflow.com/questions/4042434/convert-arraylist-containing-strings-to-an-array-of-strings-in-java
public class StringUtils {
	/**
	 * Splits the input string at the given character and outputs the resulting
	 * substrings in an array of strings.
	 */
	public static String[] splitAt(String str, char split) {

		// Initialize an ArrayList of Strings, a String buffer
		// and a temp char
		ArrayList<String> substrs = new ArrayList<String>(); 
		String buffer = "";
		char temp;
		// Loop through all the characters in the string
		for (int i = 0; i < str.length(); i++) {
			temp = str.charAt(i);
			if (temp == split) {
				substrs.add(buffer);
				buffer = "";
			}// Add the substring to the ArrayList when the temp char equals
				// the split char
			else {
				buffer += temp;
			}// Else keep adding characters to the buffer
		}

		// Add the last buffer to the ArrayList
		substrs.add(buffer);

		// Convert the ArrayList to an array
		String[] finalArray = substrs.toArray(new String[substrs.size()]);
		return finalArray;
	}// splitAt(String,char)

	/**
	 * Splits the input string following the CSV policies.
	 */
	public static String[] splitCSV(String str) {
		// Initialize an ArrayList of Strings, a String buffer,
		// a temp char and an int to keep track of the number of quotes
		ArrayList<String> substrs = new ArrayList<String>();
		String buffer = "";
		char temp;
		int numQuotes = 0;

		// Loop over all the characters in the string
		for (int i = 0; i < str.length(); i++) {
			temp = str.charAt(i);
			if (temp == '"') {
				if ((i + 1) < str.length() && str.charAt(i + 1) == '"') {
					buffer += temp;
					i++;
				}// If there are two consecutive quotes, add one to the buffer
					// and skip the next
				else {
					numQuotes++;
				}// If there is only one quote, increment numQuotes
			}// If there is a quote
			else if (temp == ',' && (numQuotes % 2 == 0)) {
				substrs.add(buffer);
				buffer = "";
			} // If there is a comma, and numQuotes is even, add the buffer to
				// the ArrayList and empty the buffer
			else {
				buffer += temp;
			}// Else add the character to the buffer
		} // End the for loop

		// Add the last buffer the ArrayList
		substrs.add(buffer);
		// Convert the ArrayList to an array
		String[] substrsArray = substrs.toArray(new String[substrs.size()]);
		return substrsArray;
	} // End splitCSV(String)
} // End Class

