package com.techelevator.services;

import com.techelevator.models.City;
import com.techelevator.models.Hotel;
import com.techelevator.models.Review;
import org.springframework.web.client.RestTemplate;

public class HotelService {

    private final String API_BASE_URL;
    private RestTemplate restTemplate = new RestTemplate();
    
    public HotelService(String apiURL) {
        API_BASE_URL = apiURL;
    }

    public Hotel[] listHotels() {
    	// 1. Call the API (generate the appropriate request: GET /hotels)
    	// 2. Turn the response JSON into Java Objects
    	//		JSON String -> Java Objects: Deserialization
    	return restTemplate.getForObject(API_BASE_URL + "/hotels", Hotel[].class); //Hotel[].class tells Java to be able to figure out it's own size of an Array
    }

    public Review[] listReviews() {
    	return restTemplate.getForObject(API_BASE_URL + "/reviews", Review[].class);
    }

    public Hotel getHotelById(int id) {
    	try {
    		return restTemplate.getForObject(API_BASE_URL + "/hotels/" + id, Hotel.class);
        } catch (Exception e) {
        	return null;
        } //end try-catch
    } //end getHotelById()
        
    public Review[] getReviewsByHotelId(int hotelID) {
    	return restTemplate.getForObject(API_BASE_URL + "/hotels/" + hotelID + "/reviews", Review[].class);
    }

    public Hotel[] getHotelsByStarRating(int stars) {
    	return restTemplate.getForObject(API_BASE_URL + "/hotels?stars=" + stars, Hotel[].class);
    }

//    public City getWithCustomQuery(){
//        return restTemplate.getForObject("https://api.teleport.org/api/cities/geonameid:512", );
//    }

}
