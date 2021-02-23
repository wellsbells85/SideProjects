package com.techelevator.locations;

import java.util.Scanner;

import org.springframework.web.client.RestTemplate;

public class App {

	private static final String API_URL = "http://localhost:3000/locations";

	public static void main(String[] args) {
		run();
	} // end main()

	private static void run() {
		Scanner scanner = new Scanner(System.in);
		printGreeting();
		String userInput = scanner.nextLine();
		int menuOption = 0;
		try {
			menuOption = Integer.parseInt(userInput);
		} catch (NumberFormatException e) {
			System.out.println("Error parsing the input for menu selection.");
		} // end try-catch
		System.out.println("");
		if (menuOption == 1) {
			RestTemplate restTemplate = new RestTemplate();
			Location[] locations = restTemplate.getForObject(API_URL, Location[].class);
			printLocations(locations);
			int locationId = 0;
			try {
				locationId = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException exception) {
				System.out.println("Error parsing the input for location id.");
			} // end try-catch
			if (locationId > 0 && locationId <= locations.length) {
				Location location = restTemplate.getForObject(API_URL + "/" + locationId, Location.class);
				printLocation(location);
			} else {
				System.out.println("Invalid Location Id.");
			} // end if if-else
		} else if (menuOption == 2) {
			scanner.close(); // close scanner
			System.exit(0); // exit class under normal circumstances
		} else {
			System.out.println("Invalid Selection, please try again."); // notify user to try another selection
		} // end if-else if-else
	} //end run()

	private static void printGreeting() {
		System.out.println("");
		System.out.println("Welcome to Tech Elevator Locations. Please make a selection: ");
		System.out.println("1: List Tech Elevator Locations");
		System.out.println("2: Exit");
		System.out.println("");
		System.out.print("Please choose an option: ");
	} // end printGreeting()

	private static void printLocations(Location[] locations) {
		System.out.println("--------------------------------------------");
		System.out.println("Locations");
		System.out.println("--------------------------------------------");
		for (Location location : locations) {
			System.out.println(location.getId() + ": " + location.getName());
		} // end for-loop
		System.out.println("");
		System.out.print("Please enter a location id to get the details: ");
	} // end printLocations()

	private static void printLocation(Location location) {
		System.out.println("");
		System.out.println("--------------------------------------------");
		System.out.println("Location Details");
		System.out.println("--------------------------------------------");
		System.out.println("Id: " + location.getId());
		System.out.println("Name: " + location.getName());
		System.out.println("Address: " + location.getAddress());
		System.out.println("City: " + location.getCity());
		System.out.println("State: " + location.getState());
		System.out.println("Zip: " + location.getZip());
	} // end printLocation()

} // end class App.java
