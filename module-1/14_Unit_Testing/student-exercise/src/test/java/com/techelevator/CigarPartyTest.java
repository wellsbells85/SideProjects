package com.techelevator;

import org.junit.*;

public class CigarPartyTest {
	
	private CigarParty CigarParty = new CigarParty();
	
//    haveParty(30, false) → false
//    haveParty(50, false) → true
//    haveParty(70, true) → true
	
	@Test
	public void test_multiple_known_situations_for_cigar_party_validity() {
		Assert.assertFalse(CigarParty.haveParty(30, false));
		Assert.assertFalse(CigarParty.haveParty(90, false));
		Assert.assertTrue(CigarParty.haveParty(50, false));
		Assert.assertTrue(CigarParty.haveParty(70, true));
	}
	

}
