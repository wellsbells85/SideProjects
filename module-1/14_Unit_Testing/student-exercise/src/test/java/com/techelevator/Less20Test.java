package com.techelevator;

import org.junit.*;

public class Less20Test {
	
//	less20(18) → true
//    less20(19) → true
//    less20(20) → false
	
	private Less20 testObject = new Less20();

	@Test
	public void test_mulitple_inputs_against_known_expected_outputs() {
		Assert.assertTrue(testObject.isLessThanMultipleOf20(18));
		Assert.assertTrue(testObject.isLessThanMultipleOf20(19));
		Assert.assertTrue(testObject.isLessThanMultipleOf20(78));
		Assert.assertTrue(testObject.isLessThanMultipleOf20(99));
		Assert.assertFalse(testObject.isLessThanMultipleOf20(0));
		Assert.assertFalse(testObject.isLessThanMultipleOf20(10));
		Assert.assertFalse(testObject.isLessThanMultipleOf20(20));
		Assert.assertFalse(testObject.isLessThanMultipleOf20(100000));
		Assert.assertFalse(testObject.isLessThanMultipleOf20(100000000));
		
	}
	
	@Test
	public void test_shows_that_user_can_still_input_negatives_and_break_program() {
		Assert.assertTrue(testObject.isLessThanMultipleOf20(-87));	
	}
}
