package com.techelevator.country;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCCountryDAO implements CountryDAO {

	private JdbcTemplate countryDAO;

	public JDBCCountryDAO() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/world");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		this.countryDAO = new JdbcTemplate(dataSource);
	}

	@Override
	public boolean save(Country newCountry) {
		String sqlInsertNewCountry = "INSERT INTO country (code, name, continent, region, surfacearea, indepyear, population, lifeexpectancy, "
				+ "gnp, gnpold, localname, governmentform, headofstate, capital, code2) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		int result = countryDAO.update(sqlInsertNewCountry, newCountry.getCode(), newCountry.getName(),
				newCountry.getContinent(), newCountry.getRegion(), newCountry.getSurfacearea(),
				newCountry.getIndepyear(), newCountry.getPopulation(), newCountry.getLifeexpectancy(),
				newCountry.getGnp(), newCountry.getGnpold(), newCountry.getLocalname(), newCountry.getHeadofstate(),
				newCountry.getCapital(), newCountry.getCode2());
		return result == 1;
	}

	@Override
	public Country findCountryByCode(String countryCode) {
		if (countryCode == null || countryCode.length() != 3) { // test if countryCode is even valid
			return null;
		}
		String sqlFindCountryByCode = "SELECT * FROM country WHERE code = ?";
		SqlRowSet oneRow = countryDAO.queryForRowSet(sqlFindCountryByCode, countryCode);
		if(!oneRow.next()) {
			return null;
		} else {
			Country country = new Country();
			country.setCode(oneRow.getString("code"));
			country.setName(oneRow.getString("name"));
			country.setContinent(oneRow.getString("continent"));
			country.setRegion(oneRow.getString("region"));
			country.setSurfacearea(oneRow.getDouble("surfacearea"));
			country.setIndepyear(oneRow.getInt("indepyear"));
			country.setPopulation(oneRow.getLong("population"));
			country.setLifeexpectancy(oneRow.getDouble("surfacearea"));
			country.setGnp(oneRow.getDouble("gnp"));
			country.setGnpold(oneRow.getDouble("gnpold"));
			country.setLocalname(oneRow.getString("localname"));
			country.setGovernmentform(oneRow.getString("governmentform"));
			country.setHeadofstate(oneRow.getString("headofstate"));
			country.setCapital(oneRow.getInt("capital"));
			country.setCode2(oneRow.getString("code2"));
			return country;
		}
	} //end findCountryByCode()

	@Override
	public List<Country> findCountryByCountryCode(String[] countryCode) {
		List<Country> countryList = new ArrayList<>();
		return countryList;
	} //end findCountryByCountryCode()

	@Override
	public List<Country> findCountryByContinent(String continent) {
		List<Country> countryList = new ArrayList<>();
		return countryList;
	} //end findCountryByContinent()

	@Override
	public boolean update(Country changedCountry) {
		String sqlUpdateCountry = "UPDATE country SET name = ?, continent = ?, region = ?, surfacearea = ?, "
				+ "indepyear = ?, population = ?, lifeexpectancy = ? WHERE code = ?";
		int result = countryDAO.update(sqlUpdateCountry, changedCountry.getName(), changedCountry.getContinent(),
				changedCountry.getRegion(), changedCountry.getSurfacearea(), changedCountry.getIndepyear(),
				changedCountry.getPopulation(), changedCountry.getLifeexpectancy(), changedCountry.getGnp(),
				changedCountry.getGnpold(), changedCountry.getLocalname(), changedCountry.getHeadofstate(),
				changedCountry.getCapital(), changedCountry.getCode2(), changedCountry.getCode());
		return result == 1;
	} //end update()

	@Override
	public boolean delete(String countryCode) {
		if (countryCode == null || countryCode.length() != 3) { // test if countryCode is even valid
			return false;
		}
		String sqlDeleteCountry = "DELETE FROM country WHERE code = ?"; //attempt delete if countryCode is valid
		int result = countryDAO.update(sqlDeleteCountry, countryCode); //check that 1 row is deleted
		return result == 1; //return boolean true if 1 row was deleted, false otherwise
	} //end delete()

} //end class()
