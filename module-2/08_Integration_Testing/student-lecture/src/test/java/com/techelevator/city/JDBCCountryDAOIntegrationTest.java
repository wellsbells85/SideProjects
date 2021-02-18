package com.techelevator.city;

import java.sql.SQLException;

import org.junit.*;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.country.Country;
import com.techelevator.country.JDBCCountryDAO;


public class JDBCCountryDAOIntegrationTest {
	
	private static SingleConnectionDataSource dataSource;
	private JDBCCountryDAO dao;
	private Country makeDummyCountry() {
		Country dummyCountry = new Country();
		
	}
	
	
	@BeforeClass
	public static void setupConnection() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/world");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		dataSource.setAutoCommit(false);
	}

	@AfterClass
	public static void closeConnection() throws SQLException {
		dataSource.destroy();
	}
	
	@Before
	public void setup_object_to_test() {
		dao = new JDBCCountryDAO();
	}
	
	
	@After
	public void rollback() {
		
	}
	
	@Test
	public void save_inserts_a_new_country() {
		
		
		roads.save(oldMen);
		
		Country foundCountry = roads.findCountryByCode("");
		Assert.assertNotNull(foundCountry);
		Assert.assertEquals(oldMen.toString(), foundCountry.toString());
		
		
	}
	
	
	

}
