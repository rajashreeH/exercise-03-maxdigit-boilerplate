package com.stackroute;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class MaxDigitInStringTest {
	private static final String MSG_01 = "The method getMaxDigit should return the maximum digit from the input string";
	private static final String MSG_03 = "Special character also can be present in the String";

	private String input;
	private int expected;
	private String message;

	public MaxDigitInStringTest(String input, int expected, String message) {
		this.input = input;
		this.expected = expected;
		this.message = message;
	}

	@Parameters(name = "{index}: getMaxDigit({0}) - Should Return ({1})")
	public static Collection<Object[]> data() {
		Collection<Object[]> params = new ArrayList<>();
		params.add(new Object[] { "a1b2C9", 9, MSG_01 });
		params.add(new Object[] { "112233", 3, MSG_01 });
		params.add(new Object[] { " A1 B2 C3 ", 3, MSG_03 });
		return params;
	}

	@Test
	public void testGetMaxDigit() {
		assertThat(message, MaxDigitInString.getMaxDigit(input), is(expected));
	}
}