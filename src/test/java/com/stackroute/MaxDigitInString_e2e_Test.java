package com.stackroute;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.stackroute.MaxDigitInString;

@RunWith(Parameterized.class)
public class MaxDigitInString_e2e_Test {
	private static final String MSG_01 = "The main method should display the maximum digit from the input string in the required format. ";
	private static final String MSG_02 = "Main Method should display No Digits in String for Empty string or String with no digits";
	private static final String MSG_03 = "Special character also can be present in the input String.";

	private static final String MAXDIGIT = "Max digit : ";
	private static final String NODIGITS = "No digits in string";

	private PrintStream out;
	private ByteArrayOutputStream myOutStream;
	private InputStream in;
	private ByteArrayInputStream myInputStream;

	private String input;
	private String expected;
	private String message;

	public MaxDigitInString_e2e_Test(String input, String expected, String message) {
		this.input = input;
		this.expected = expected;
		this.message = message;
	}

	@Before
	public void setUp() {
		in = System.in;
		out = System.out;
		myOutStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(myOutStream));
	}

	@After
	public void tearDown() {
		System.setIn(in);
		System.setOut(out);
	}

	@Parameters(name = "{index}: Main Method Input ({0}) - Should display ({1})")
	public static Collection<Object[]> data() {
		Collection<Object[]> params = new ArrayList<>();
		params.add(new Object[] { "p5q6r7", MAXDIGIT + 7, MSG_01 });
		params.add(new Object[] { "pqr", NODIGITS, MSG_02 });
		params.add(new Object[] { "p1 q2 r3", MAXDIGIT + 3, MSG_01 + MSG_03 });
		return params;
	}

	@Test
	public void testMaxDigitInString_e2e() {
		myInputStream = new ByteArrayInputStream(input.getBytes());
		System.setIn(myInputStream);

		MaxDigitInString.main(null);
		String actual = myOutStream.toString().replaceAll("\\s+", "");
		assertThat(message, actual, is(expected.replaceAll("\\s+", "")));
	}
}