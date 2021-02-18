package com.techelevator.city;

import java.util.List;

public interface CityDAO {

	public boolean save(City newCity);

	public City findCityById(long id);

	public List<City> findCityByCountryCode(String countryCode);

	public List<City> findCityByDistrict(String district);

	public boolean update(City city);

	public boolean delete(long id);
}
