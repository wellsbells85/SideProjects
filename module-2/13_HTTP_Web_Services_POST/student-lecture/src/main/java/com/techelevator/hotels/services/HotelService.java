package com.techelevator.hotels.services;

import com.techelevator.hotels.models.Hotel;
import com.techelevator.hotels.models.Reservation;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

public class HotelService {

	private final String BASE_URL;
	private final RestTemplate restTemplate = new RestTemplate();
	private final ConsoleService console = new ConsoleService();

	public HotelService(String url) {
		BASE_URL = url;
	}

	/**
	 * Create a new reservation in the hotel reservation system
	 *
	 * @param newReservation
	 * @return Reservation
	 */
	public Reservation addReservation(String newReservation) {
		//TODO: Implement method 
		//Hotel ID, Full Name, Checkin Date, Checkout Date, Number of Guests
		//Example: 1, John Smith, 10/10/2020, 10/14/2020, 2
		Reservation incomingReservation = makeReservation(newReservation);
		if(incomingReservation == null) {
			return null;
		} //end if-catch on null Reservation objects
		//Step 1: Make Headers
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		//Step 2: Make the HTTP box
		HttpEntity<Reservation> entity = new HttpEntity<>(incomingReservation, headers);
		//Step 3: Send to the Internet
		String url = BASE_URL + "hotels/" + incomingReservation.getHotelID() + "/reservations";
		
		Reservation confirmed = null;
		try {
			confirmed = restTemplate.postForObject(url, entity, Reservation.class);
		} catch(RestClientResponseException rcre) {
			console.printError("ServerError!\n" + rcre.getRawStatusCode() + ": " + rcre.getStatusText());
		} catch(ResourceAccessException rae) {
			console.printError("It's not a truck. It's a series of tubes.");
		} //end try-catch-catch
		return confirmed;
	} //end addReservation()

	/**
	 * Updates an existing reservation by replacing the old one with a new
	 * reservation
	 *
	 * @param CSV
	 * @return
	 */
	public Reservation updateReservation(String CSV) {
		Reservation changedReservation = makeReservation(CSV);
		if(changedReservation == null) {
			return null;
		} //end if-catch on null Reservation
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Reservation> update = new HttpEntity<>(changedReservation, headers);
		String url = BASE_URL + "reservations/" + changedReservation.getId();
		try {
			restTemplate.put(url, update);
		}catch(RestClientResponseException rcre) {
			console.printError("Reservation could not be updated!");
			return null;
		} catch(ResourceAccessException rae) {
			console.printError("Couldn't connect to Hotel Server! Please try again later.");
			return null;
		} //end try-catch-catch
		return changedReservation;
	}

	/**
	 * Delete an existing reservation
	 *
	 * @param id
	 */
	public void deleteReservation(int id) {
		// TODO: Implement method
		String url = BASE_URL + "reservations/" + id;
		try {
			restTemplate.delete(url);
		}catch(RestClientResponseException rcre) {
			console.printError("Reservation could not be updated!");
		} catch(ResourceAccessException rae) {
			console.printError("Couldn't connect to Hotel Server! Please try again later.");
		} //end try-catch-catch
	}

	/* DON'T MODIFY ANY METHODS BELOW */

	/**
	 * List all hotels in the system
	 *
	 * @return
	 */
	public Hotel[] listHotels() {
		Hotel[] hotels = null;
		try {
			hotels = restTemplate.getForObject(BASE_URL + "hotels", Hotel[].class);
		} catch (RestClientResponseException ex) {
			// handles exceptions thrown by rest template and contains status codes
			console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText());
		} catch (ResourceAccessException ex) {
			// i/o error, ex: the server isn't running
			console.printError(ex.getMessage());
		}
		return hotels;
	}

	/**
	 * Get the details for a single hotel by id
	 *
	 * @param id
	 * @return Hotel
	 */
	public Hotel getHotel(int id) {
		Hotel hotel = null;
		try {
			hotel = restTemplate.getForObject(BASE_URL + "hotels/" + id, Hotel.class);
		} catch (RestClientResponseException ex) {
			console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText());
		} catch (ResourceAccessException ex) {
			console.printError(ex.getMessage());
		}
		return hotel;
	}

	/**
	 * List all reservations in the hotel reservation system
	 *
	 * @return Reservation[]
	 */
	public Reservation[] listReservations() {
		Reservation[] reservations = null;
		try {
			reservations = restTemplate.getForObject(BASE_URL + "reservations", Reservation[].class);
		} catch (RestClientResponseException ex) {
			console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText());
		} catch (ResourceAccessException ex) {
			console.printError(ex.getMessage());
		}
		return reservations;
	}

	/**
	 * List all reservations by hotel id.
	 *
	 * @param hotelId
	 * @return Reservation[]
	 */
	public Reservation[] listReservationsByHotel(int hotelId) {
		Reservation[] reservations = null;
		try {
			reservations = restTemplate.getForObject(BASE_URL + "hotels/" + hotelId + "/reservations",
					Reservation[].class);
		} catch (RestClientResponseException ex) {
			console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText());
		} catch (ResourceAccessException ex) {
			console.printError(ex.getMessage());
		}
		return reservations;
	}

	/**
	 * Find a single reservation by the reservationId
	 *
	 * @param reservationId
	 * @return Reservation
	 */
	public Reservation getReservation(int reservationId) {
		Reservation reservation = null;
		try {
			reservation = restTemplate.getForObject(BASE_URL + "reservations/" + reservationId, Reservation.class);
		} catch (RestClientResponseException ex) {
			console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText());
		} catch (ResourceAccessException ex) {
			console.printError(ex.getMessage());
		}
		return reservation;
	}

	private Reservation makeReservation(String CSV) {
		if(CSV == null) {
			return null;
		}
		String[] parsed = CSV.split(",");

		// invalid input (
		if (parsed.length < 5 || parsed.length > 6) {
			return null;
		}

		// Add method does not include an id and only has 5 strings
		if (parsed.length == 5) {
			// Create a string version of the id and place into an array to be concatenated
			String[] withId = new String[6];
			String[] idArray = new String[] { new Random().nextInt(1000) + "" };
			// place the id into the first position of the data array
			System.arraycopy(idArray, 0, withId, 0, 1);
			System.arraycopy(parsed, 0, withId, 1, 5);
			parsed = withId;
		}

		return new Reservation(Integer.parseInt(parsed[0].trim()), Integer.parseInt(parsed[1].trim()), parsed[2].trim(),
				parsed[3].trim(), parsed[4].trim(), Integer.parseInt(parsed[5].trim()));
	}

}
