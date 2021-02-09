package com.techelevator;

public class ReserveAuction extends Auction {
	
	private int reservePrice;
	
	public ReserveAuction(String itemForSale, int reservePrice) {
		super(itemForSale);
		this.reservePrice = reservePrice;
	}
	
	@Override
	public boolean placeBid(Bid offeredBid) {
		boolean isCurrentWinningBid = false;
		
		if (/*offeredBid.getBidAmount() > currentHighBid.getBidAmount() &&*/ offeredBid.getBidAmount() >= reservePrice) { // I don't need this line of code because of inheritance
			isCurrentWinningBid = super.placeBid(offeredBid); // This line of code just goes out and runs the Superclass method, don't need to import all the private methods and variables
		}	
		return isCurrentWinningBid;
	}

}
