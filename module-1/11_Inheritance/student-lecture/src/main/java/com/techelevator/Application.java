package com.techelevator;

public class Application {

    public static void main(String[] args) {

        // Create a new general auction
        System.out.println("Starting a general auction");
        System.out.println("-----------------");

        Auction generalAuction = new Auction("Tech Elevator T-shirt");

        generalAuction.placeBid(new Bid("Josh", 1));
        generalAuction.placeBid(new Bid("Fonz", 23));
        generalAuction.placeBid(new Bid("Rick Astley", 13));
        //....
        //....
        // This might go on until the auction runs out of time or hits a max # of bids
        
        
        
     // Create a new reserve auction
        System.out.println("\nStarting a reserve auction");
        System.out.println("-----------------");

        Auction reserveAuction = new ReserveAuction("Tech Elevator Sweatpants", 20);

        reserveAuction.placeBid(new Bid("Josh", 1));
        reserveAuction.placeBid(new Bid("Fonz", 23));
        reserveAuction.placeBid(new Bid("Rick Astley", 13));
        //....
        //....
        // This might go on until the auction runs out of time or hits a max # of bids
        
        
        // Create a new buy it now auction
        System.out.println("\nStarting a buy it now auction");
        System.out.println("-----------------");

        Auction buyItNowAuction = new BuyItNowAuction("Tech Elevator MacBook Air", 500);

        buyItNowAuction.placeBid(new Bid("Josh", 100));
        buyItNowAuction.placeBid(new Bid("Fonz", 750));
        buyItNowAuction.placeBid(new Bid("Rick Astley", 213));
        //....
        //....
        // This might go on until the auction runs out of time or hits a max # of bids



    }
}
