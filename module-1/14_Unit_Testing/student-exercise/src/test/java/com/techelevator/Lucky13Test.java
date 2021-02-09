package com.techelevator;

import org.junit.*;

public class Lucky13Test {
	
//	GetLucky([0, 2, 4]) → true 
//	GetLucky([1, 2, 3]) → false 
//	GetLucky([1, 2, 4]) → false
	
	private Lucky13 testObject;
	
	@Before
	public void instantiation() {
		this.testObject = new Lucky13();
	}
	
	@Test
	public void test_confirms_null_input() {
		Assert.assertTrue(testObject.getLucky(null));
	}
	
	@Test
	public void test_confirms_zero_length_array_input() {
		int[] input = {};
		Assert.assertTrue(testObject.getLucky(input));
	}
	
	@Test
	public void test_true_no_one_or_three() {
		int[] input = { 0, 2, 4 };
		Assert.assertTrue(testObject.getLucky(input));
	}
	
	@Test
	public void test_false_for_single_one() {
		int[] input = { 1, 2, 4 };
		Assert.assertFalse(testObject.getLucky(input));
	}
	
	@Test
	public void test_false_for_single_three() {
		int[] input = { 3, 2, 4 };
		Assert.assertFalse(testObject.getLucky(input));
	}
	
	@Test
	public void test_false_for_a_one_and_a_three() {
		int[] input = { 1, 2, 3 };
		Assert.assertFalse(testObject.getLucky(input));
	}
	
	
}
