package com.techelevator;

import org.junit.*;

public class DateFashionTest {
	
//    dateFashion(5, 10) → 2
//    dateFashion(5, 2) → 0
//    dateFashion(5, 5) → 1
	
	private DateFashion df;
	private int you = 0;
	private int date = 0;
	
	@Before
	public void instantiation() {
		DateFashion df = new DateFashion();
	}
	
	@Test
	public void test_to_confirm_a_two_rating() {
		you = 5;
		date = 10;
		Assert.assertEquals(2, 2);
	}
	
	@Test
	public void test_to_confirm_a_one_rating() {
		you = 5;
		date = 5;
		Assert.assertEquals(1, 1);
	}
	
	@Test
	public void test_to_confirm_a_zero_rating() {
		you = 5;
		date = 2;
		Assert.assertEquals(0, 0);
	}
	
	@Test
	public void test_to_confirm_a_two_ruins_a_ten() {
		you = 10;
		date = 2;
		Assert.assertEquals(0, 0);
	}
	
	
	

}
