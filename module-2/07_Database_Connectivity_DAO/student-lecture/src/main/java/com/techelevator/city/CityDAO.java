package com.techelevator.city;

import java.util.List;

public interface CityDAO {

	//Retrieve
	public City findCityById(long id);
	public List<City> findCityByCountryCode(String countryCode);
	public List<City> findCityByDistrict(String district);
	
	//Insert
	public void save(City newCity);
	
	//Update
	public void update(City city);
	
	//Delete
	public void delete(long id);
}
