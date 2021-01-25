package com.techelevator;

public class BuyItNowAuction extends Auction {
	
	private final int BUY_OUT_PRICE; //final because all Buy-It-Now auctions need this price. NOT static because each auction is different price!
	
	public BuyItNowAuction(String item, int buyOutPrice) {
		super(item);
		this.BUY_OUT_PRICE = buyOutPrice;
	}
	
	@Override
	public boolean placeBid(Bid offeredBid) {
		boolean isCurrentWinningBid = false;
		
		if(getHighBid().getBidAmount() < BUY_OUT_PRICE) {
			
			if(offeredBid.getBidAmount() >= BUY_OUT_PRICE ) {
				isCurrentWinningBid = super.placeBid(offeredBid);;
			}			
		}	return isCurrentWinningBid;
	}


}
