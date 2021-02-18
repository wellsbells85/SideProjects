package com.techelevator.city;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCCityDAO implements CityDAO {

	private JdbcTemplate jdbcTemplate;
	
	public JDBCCityDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void save(City newCity) {
		String sqlInsertCity = "INSERT INTO city(id, name, countrycode, district, population) " +
							   "VALUES(?, ?, ?, ?, ?)";
		newCity.setId(getNextCityId());
		jdbcTemplate.update(sqlInsertCity, newCity.getId(), newCity.getName(), newCity.getCountryCode(), //continues next line
							newCity.getDistrict(), newCity.getPopulation() ); //continued from previous line
	} //end save()
	
	@Override
	public City findCityById(long id) {
		City theCity = null;
		String sqlFindCityById = "SELECT id, name, countrycode, district, population "+
							   "FROM city "+
							   "WHERE id = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindCityById, id);
		
		if(results.next()) {
			theCity = mapRowToCity(results);
		} return theCity;
	} //end findCityById()

	@Override
	public List<City> findCityByCountryCode(String countryCode) {
		ArrayList<City> cities = new ArrayList<>();
		String sqlFindCityByCountryCode = "SELECT id, name, countrycode, district, population "+
										   "FROM city "+
										   "WHERE countrycode = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindCityByCountryCode, countryCode);
		
		while(results.next()) {
			City theCity = mapRowToCity(results);
			cities.add(theCity);
		} return cities;
	} //end findCityByCountryCode()

	@Override
	public List<City> findCityByDistrict(String district) {
		ArrayList<City> cities = new ArrayList<>();
		String sqlFindCityByDistrict = "SELECT id, name, countrycode, district, population "+
										   "FROM city "+
										   "WHERE district = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindCityByDistrict, district);
		
		while(results.next()) {
			City theCity = mapRowToCity(results);
			cities.add(theCity);
		} return cities;
	} //end findCityByDistrict()

	@Override
	public void update(City city) {
		String sqlUpdateCity = 	"UPDATE city " +
								"SET 	name = ?, " +
								"		countrycode = ?, " + 
								"		district = ?, " +
								"		population = ?, " +
								"WHERE 	id = ? ";
		
		jdbcTemplate.update(sqlUpdateCity, city.getName(), city.getCountryCode(), city.getDistrict(), city.getPopulation(), city.getId());
	} //end update()

	@Override
	public void delete(long id) {
		String sqlRemoveCity = "DELETE FROM city WHERE id = ? ";
		jdbcTemplate.update(sqlRemoveCity, id);	
	} //end delete()

	private long getNextCityId() {
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('seq_city_id')");
		if(nextIdResult.next()) {
			return nextIdResult.getLong(1);
		} else {
			throw new RuntimeException("Something went wrong while getting an id for the new city");
		}
	} //end getNextCityId()

	private City mapRowToCity(SqlRowSet results) {
		City theCity = new City();
		theCity.setId(results.getLong("id"));
		theCity.setName(results.getString("name"));
		theCity.setCountryCode(results.getString("countrycode"));
		theCity.setDistrict(results.getString("district"));
		theCity.setPopulation(results.getInt("population"));
		return theCity;
	} //end mapRowToCity()
	
} //end class
