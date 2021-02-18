package com.techelevator.country;

import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCCountryDAO implements CountryDAO {
	
	private JdbcTemplate countryDAO;
	
	public JDBCCountryDAO() {
		BasicDataSource elephantInTheRoom = new BasicDataSource();
		elephantInTheRoom.setUrl("jdbc:postgresql://localhost:5432/world");
		elephantInTheRoom.setUsername("postgres");
		elephantInTheRoom.setPassword("postgres1");
		
		this.countryDAO = new JdbcTemplate(elephantInTheRoom);
	}
	
	public JDBCCountryDAO(SingleConnectionDataSource genericDataSource) {
		this.countryDAO = new JdbcTemplate(genericDataSource);
	}

	@Override
	public boolean save(Country newCountry) {
		String sqlInsertStatement = "INSERT INTO country (code, name, continent, region, surfacearea, indepyear, population, lifeexpectancy, gnp, gnpold, localname, governmentform, headofstate, capital, code2) " + 
	                                            " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		String code = newCountry.getCode();
		String name = newCountry.getName();
		String continent = newCountry.getContinent();
		String region = newCountry.getRegion();      
		Double surfacearea = newCountry.getSurfacearea();   
		Integer indepyear = newCountry.getIndepyear();    
		Long population = newCountry.getPopulation();      
		Double lifeexpectancy = newCountry.getLifeexpectancy();
		Double gnp = newCountry.getGnp();           
		Double gnpold = newCountry.getGnpold();        
		String localname = newCountry.getLocalname();     
		String governmentform = newCountry.getGovernmentform();
		String headofstate = newCountry.getHeadofstate();
		Integer capital = newCountry.getCapital();      
		String code2 = newCountry.getCode2();		

		// SELECTs: .queryForRowSet()
		// INSERT/UPDATE/DELETEs: .update()
		int numberOfRowsInserted = countryDAO.update(sqlInsertStatement, code, name, continent, region, surfacearea, indepyear, population, lifeexpectancy, gnp, gnpold, localname, governmentform, headofstate, capital, code2);

		return numberOfRowsInserted == 1;
	}

	@Override
	public Country findCountryByCode(String countryCode) {
		if(countryCode == null || countryCode.length() != 3) {
			return null;
		}
		
		String sql = "SELECT * FROM country WHERE code = ?";
		SqlRowSet oneRow = countryDAO.queryForRowSet(sql, countryCode);
		
		if(!oneRow.next()) {
			// No country found!
			return null;
		} else {
			String code = oneRow.getString("code");
			String name = oneRow.getString("name");
			String continent = oneRow.getString("continent");			
			String region = oneRow.getString("region");
			Double surfacearea = oneRow.getDouble("surfacearea");
			Integer indepyear = oneRow.getInt("indepyear");
			Long population = oneRow.getLong("population");
			Double lifeexpectancy = oneRow.getDouble("lifeexpectancy");
			Double gnp = oneRow.getDouble("gnp");
			Double gnpold = oneRow.getDouble("gnpold");
			String localname = oneRow.getString("localname");
			String governmentform = oneRow.getString("governmentform");
			String headofstate = oneRow.getString("headofstate");
			Integer capital = oneRow.getInt("capital");
			String code2 = oneRow.getString("code2");
			
			// Build the new country!
			Country oneJavaObject = new Country();
			oneJavaObject.setCode(code);
			oneJavaObject.setName(name);
			oneJavaObject.setContinent(continent);
			oneJavaObject.setRegion(region);
			oneJavaObject.setSurfacearea(surfacearea);
			oneJavaObject.setIndepyear(indepyear);
			oneJavaObject.setPopulation(population);
			oneJavaObject.setLifeexpectancy(lifeexpectancy);
			oneJavaObject.setGnp(gnp);
			oneJavaObject.setGnpold(gnpold);
			oneJavaObject.setLocalname(localname);
			oneJavaObject.setGovernmentform(governmentform);
			oneJavaObject.setHeadofstate(headofstate);
			oneJavaObject.setCapital(capital);
			oneJavaObject.setCode2(code2);
			
			return oneJavaObject;
		}
		
	}

	@Override
	public List<Country> findCountryByContinent(String continent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Country> findCountryByCountryCode(String[] countryCodes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Country changedCountry) {
		String sqlUpdateStatement = "UPDATE country SET name=?, continent=?, region=?, surfacearea=?, indepyear=?, population=?, lifeexpectancy=?, gnp=?, gnpold=?, localname=?, governmentform=?, headofstate=?, capital=?, code2=? " + 
                " WHERE code = ?";

		String code = changedCountry.getCode();
		String name = changedCountry.getName();
		String continent = changedCountry.getContinent();
		String region = changedCountry.getRegion();      
		Double surfacearea = changedCountry.getSurfacearea();   
		Integer indepyear = changedCountry.getIndepyear();    
		Long population = changedCountry.getPopulation();      
		Double lifeexpectancy = changedCountry.getLifeexpectancy();
		Double gnp = changedCountry.getGnp();           
		Double gnpold = changedCountry.getGnpold();        
		String localname = changedCountry.getLocalname();     
		String governmentform = changedCountry.getGovernmentform();
		String headofstate = changedCountry.getHeadofstate();
		Integer capital = changedCountry.getCapital();      
		String code2 = changedCountry.getCode2();
		
		int numberOfRowsUpdated = countryDAO.update(sqlUpdateStatement, name, continent, region, surfacearea, indepyear, population, lifeexpectancy, gnp, gnpold, localname, governmentform, headofstate, capital, code2, code);
		return numberOfRowsUpdated == 1;
	}

	@Override
	public boolean delete(String countryCode) {
		if(countryCode == null || countryCode.length() != 3) {
			return false;
		}
		
		String sqlGoner = "DELETE FROM country WHERE code = ?";

		// SELECTs: .queryForRowSet()
		// INSERT/UPDATE/DELETEs: .update()
		int numberOfGoners = countryDAO.update(sqlGoner, countryCode);
		return numberOfGoners == 1;
	}

}
