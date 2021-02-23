package com.techelevator;

import com.techelevator.services.ConsoleService;
import com.techelevator.services.HotelService;

public class App {

    private static final String API_BASE_URL = "http://localhost:3000";

    public static void main(String[] args) {
        int menuSelection = 999;
        int hotelId = -1;

        ConsoleService consoleService = new ConsoleService();
        HotelService hotelService = new HotelService(API_BASE_URL);

        while (menuSelection != 0) {
            menuSelection = consoleService.printMainMenu();
            if (menuSelection == 1) {
            	consoleService.printHotels(hotelService.listHotels()); //hotelService.listHotels() returns Hotel[] of variable length from web
            } else if (menuSelection == 2) {
            	consoleService.printReviews(hotelService.listReviews()); //hotelService.listReviews() returns Review[] of variable length from web
            } else if (menuSelection == 3) {
                consoleService.printHotel(hotelService.getHotelById(1));
            } else if (menuSelection == 4) {
                consoleService.printReviews(hotelService.getReviewsByHotelId(1));
            } else if (menuSelection == 5) {
                consoleService.printHotels(hotelService.getHotelsByStarRating(3));
            } else if (menuSelection == 6) {
                System.out.println("Not implemented - Create a custom Web API query here");
            } else if (menuSelection == 0) {
                consoleService.exit();
            } else {
                // anything else is not valid
                System.out.println("Invalid Selection");
            }
            // Press any key to continue...
            if(hotelId != 0) {
                consoleService.next();
            }
            // Ensure loop continues
            menuSelection = 999;
        }

        // if the loop exits, so does the program
        consoleService.exit();
    }

}
