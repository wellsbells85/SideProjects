package com.techelevator;

import org.junit.*;

public class DateFashionTest {
	
//    dateFashion(5, 10) → 2
//    dateFashion(5, 2) → 0
//    dateFashion(5, 5) → 1
	
	private DateFashion testObject;
	
	@Before
	public void instantiation() {
		this.testObject = new DateFashion();
	}
	
	@Test
	public void test_to_confirm_a_two_rating() {
		Assert.assertEquals(2, testObject.getATable(5,10));
	}
	
	@Test
	public void test_to_confirm_a_one_rating() {
		Assert.assertEquals(1, testObject.getATable(5,5));
	}
	
	@Test
	public void test_to_confirm_a_zero_rating() {
		Assert.assertEquals(0, testObject.getATable(5,2));
	}
	
	@Test
	public void test_to_confirm_a_two_ruins_a_ten() {
		Assert.assertEquals(0, testObject.getATable(10,2));
	}
	
	
	

}
