package com.techelevator.city;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;


public class JDBCCityDAOIntegrationTest {

	private static final String TEST_COUNTRY = "XYZ";

	/* Using this particular implementation of DataSource so that
	 * every database interaction is part of the same database
	 * session and hence the same database transaction */
	private static SingleConnectionDataSource dataSource;
	private JDBCCityDAO dao;

	/* Before any tests are run, this method initializes the datasource for testing. */
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/world");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		/* The following line disables autocommit for connections
		 * returned by this DataSource. This allows us to rollback
		 * any changes after each test */
		dataSource.setAutoCommit(false);
	}

	/* After all tests have finished running, this method will close the DataSource */
	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}

	@Before
	public void setup() {
		// ARRANGE STEP for every test
		String sqlInsertCountry = "INSERT INTO country (code, name, continent, region, surfacearea, indepyear, population, lifeexpectancy, gnp, gnpold, localname, governmentform, headofstate, capital, code2) VALUES (?, 'Afghanistan', 'Asia', 'Southern and Central Asia', 652090, 1919, 22720000, 45.9000015, 5976.00, NULL, 'Afganistan/Afqanestan', 'Islamic Emirate', 'Mohammad Omar', 1, 'AF')";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); // Get a new JDBCTemplate object to run the insert
		jdbcTemplate.update(sqlInsertCountry, TEST_COUNTRY);     // Put the dummy country in the country table
		
		
		// Fresh object under test
		dao = new JDBCCityDAO(dataSource);
	}

	/* After each test, we rollback any changes that were made to the database so that
	 * everything is clean for the next test */
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}

	@Test
	public void save_new_city_and_read_it_back() throws SQLException {
		City dummyCity = makeCityObject("SQL Station", "South Dakota", TEST_COUNTRY, 65535); // ARRANGE

		dao.save(dummyCity); // ACT
		
		// ASSERT
		assertNotNull(dummyCity.getId()); // ID should have been given by the .save() method
		
		City savedCity = dao.findCityById(dummyCity.getId()); // Row should have been inserted -- find it!
		assertNotNull(savedCity);
		assertCitiesAreEqual(dummyCity, savedCity);
	}
	
	@Test
	public void returns_city_by_id() {
		// ARRANGE
		City dummyCity = makeCityObject("SQL Station", "South Dakota", TEST_COUNTRY, 65535); 
		dao.save(dummyCity);
		
		City theCity = dao.findCityById(dummyCity.getId()); // ACT
		
		assertNotNull(theCity);
		assertCitiesAreEqual(dummyCity, theCity);
		
	}

	@Test
	public void returns_cities_by_country_code() {
		// ARRANGE
		City dummyCity = makeCityObject("SQL Station", "South Dakota", TEST_COUNTRY, 65535); // 2^16 - 1
		dao.save(dummyCity);
		
		// ACT
		List<City> results = dao.findCityByCountryCode(TEST_COUNTRY);

		// ASSERT
		assertNotNull(results);
		assertEquals(1, results.size());
		City savedCity = results.get(0);
		assertCitiesAreEqual(dummyCity, savedCity);
	}

	@Test
	public void returns_multiple_cities_by_country_code() {

		// ARRANGE
		dao.save(makeCityObject("SQL Station", "South Dakota", TEST_COUNTRY, 65535));
		dao.save(makeCityObject("Postgres Point", "North Dakota", TEST_COUNTRY, 65535));

		// ACT
		List<City> results = dao.findCityByCountryCode(TEST_COUNTRY);

		assertNotNull(results);
		assertEquals(2, results.size());
	}

	@Test
	public void returns_cities_by_district() {
		// ARRANGE
		String testDistrict = "Tech Elevator";
		City theCity = makeCityObject("SQL Station", testDistrict, TEST_COUNTRY, 65535);
		dao.save(theCity);

		// ACT
		List<City> results = dao.findCityByDistrict(testDistrict);

		// ASSERT
		assertNotNull(results);
		assertEquals(1, results.size());
		City savedCity = results.get(0);
		assertCitiesAreEqual(theCity, savedCity);
	}
	
	@Test
	public void returns_multiple_cities_by_district() {
		// ARRANGE
		String testDistrict = "Tech Elevator";
		dao.save(makeCityObject("SQL Station", testDistrict, TEST_COUNTRY, 65535));
		dao.save(makeCityObject("Postgres Point", testDistrict, TEST_COUNTRY, 65535));

		// ACT
		List<City> results = dao.findCityByDistrict(testDistrict);

		assertNotNull(results);
		assertEquals(2, results.size());
	}
	
	@Test
	public void returns_changed_city() {
		// ARRANGE
		String firstTestDistrict = "Tech Elevator";
		String secondTestDistrict = "Tech Escalator";
		City theCity = makeCityObject("SQL Station", firstTestDistrict, TEST_COUNTRY, 65535);
		dao.save(theCity);
		
		theCity.setDistrict(secondTestDistrict);
		dao.update(theCity); // ACT
		
		
		City foundCity = dao.findCityById(theCity.getId());
		
		assertEquals(foundCity.getDistrict(), secondTestDistrict);
		assertCitiesAreEqual(foundCity, theCity);
	}
	
	@Test
	public void deletes_city() {
		// INSERT dummy data
		City dummyCity = makeCityObject("SQL Station", "District Of Champions", TEST_COUNTRY, 65535);
		dao.save(dummyCity);
		
		// Make sure it's in there
		List<City> citiesInXYZ = dao.findCityByCountryCode(TEST_COUNTRY);
		assertNotNull(citiesInXYZ);
		assertEquals(1, citiesInXYZ.size());
		
		
		dao.delete(dummyCity.getId()); // ACT
		
		
		// Make sure it's no longer in there
		citiesInXYZ = dao.findCityByCountryCode(TEST_COUNTRY);
		assertNotNull(citiesInXYZ);
		assertEquals(0, citiesInXYZ.size());
	}

	private City makeCityObject(String name, String district, String countryCode, int population) {
		City theCity = new City();
		theCity.setName(name);
		theCity.setDistrict(district);
		theCity.setCountryCode(countryCode);
		theCity.setPopulation(population);
		return theCity;
	}

	private void assertCitiesAreEqual(City expected, City actual) {
		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getName(), actual.getName());
		assertEquals(expected.getDistrict(), actual.getDistrict());
		assertEquals(expected.getCountryCode(), actual.getCountryCode());
		assertEquals(expected.getPopulation(), actual.getPopulation());
	}
}
