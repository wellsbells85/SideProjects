package com.techelevator;

import org.junit.*;

public class AnimalGroupNameTest {
	
		private AnimalGroupName agn; 
		
		@Before
		public void reinstantiate() {
			this.agn = new AnimalGroupName();
		}
		
	
//	   	 * GetHerd("giraffe") → "Tower"
//	     * GetHerd("") -> "unknown"
//	     * GetHerd("walrus") -> "unknown"
//	     * GetHerd("Rhino") -> "Crash"
//	     * GetHerd("rhino") -> "Crash"
//	     * GetHerd("elephants") -> "unknown"

	@Test
	public void giraffe_returns_Tower() {
		String input = "giraffe";
		
		String output = agn.getHerd(input.toLowerCase());

		Assert.assertEquals("Tower", output);
	}
	
	@Test
	public void empty_string_returns_unknown() {
		String input = "";
		
		String output = agn.getHerd(input.toLowerCase());
		
		Assert.assertEquals("unknown", output);
	}
	
	@Test
	public void null_returns_unknown() {
		String output = agn.getHerd(null);
		
		Assert.assertEquals("unknown", output);
	}
	
	@Test
	public void walrus_returns_unknown() {
		String input = "walrus";
		
		String output = agn.getHerd(input.toLowerCase());
		
		Assert.assertEquals("unknown", output);
	}
	
	@Test
	public void elephants_returns_unknown() {
		String input = "elephants";
		
		String output = agn.getHerd(input.toLowerCase());
		
		Assert.assertEquals("unknown", output);
	}
	
	@Test
	public void Rhino_returns_crash() {
		String input = "Rhino";
		
		String output = agn.getHerd(input.toLowerCase());
		
		Assert.assertEquals("Crash", output);
	}
	
	@Test
	public void rhino_returns_crash() {
		String input = "rhino";
		
		String output = agn.getHerd(input.toLowerCase());
		
		Assert.assertEquals("Crash", output);
	}
	

}
