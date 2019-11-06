package com.stackroute;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaxDigitInString {

	public static int getMaxDigit(String alphanumeric) {

		char[] inputArray = alphanumeric.toCharArray();

		List<Integer> digits=new ArrayList<>();
		for (char c : inputArray) {
			if (Character.isDigit(c)) {
				digits.add(Character.getNumericValue(c));
			}
		}
		if(digits.isEmpty()) {
			return -1;
		}
		
		digits.sort((d1,d2)->d2.compareTo(d1));
		
		
		return digits.get(0);
	}

	// Do not print anything other than what's expected/asked in problem
	public static void main(String[] args) {
		// Use Scanner to get input from console
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();

		int max=getMaxDigit(input);
		if(max==-1) {
			System.out.println("No digits in string");
		}
		else {
			System.out.println("Max digit : "+max);
		}
	}
}
