package com.techelevator;

import org.junit.*;

public class SameFirstLastTest {
	
//    IsItTheSame([1, 2, 3]) → false
//    IsItTheSame([1, 2, 3, 1]) → true
//    IsItTheSame([1, 2, 1]) → true
	
	private SameFirstLast testObject;
	
	@Before
	public void instantiation() {
		this.testObject = new SameFirstLast();
	}
	
	@Test
	public void test_null() {
		Assert.assertFalse(testObject.isItTheSame(null));
	}
	
	@Test
	public void test_for_known_false_situation_array_length_five() {
		int[] input = {1, 2, 3, 4, 5};
		Assert.assertFalse(testObject.isItTheSame(input));
	}
	
	@Test
	public void test_for_known_true_situation_array_length_two() {
		int[] input = {1, 1};
		Assert.assertTrue(testObject.isItTheSame(input));
	}
	
	@Test
	public void test_for_known_true_situation_array_length_10() {
		int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9 ,1};
		Assert.assertTrue(testObject.isItTheSame(input));
	}
	
	
	
	
	
	
	
	
}
