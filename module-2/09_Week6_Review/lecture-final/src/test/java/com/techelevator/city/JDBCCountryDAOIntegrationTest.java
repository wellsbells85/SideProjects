package com.techelevator.city;

import java.sql.SQLException;

import org.junit.*;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.country.Country;
import com.techelevator.country.JDBCCountryDAO;

public class JDBCCountryDAOIntegrationTest {
	private static final String FAKE_COUNTRY_CODE = "OLD";
	private static SingleConnectionDataSource dataSourceThatCanBeRolledBack;
	
	private JDBCCountryDAO roads;

	
	@BeforeClass
	public static void setup_connection_once_and_only_once() {
		dataSourceThatCanBeRolledBack = new SingleConnectionDataSource();
		dataSourceThatCanBeRolledBack.setUrl("jdbc:postgresql://localhost:5432/world");
		dataSourceThatCanBeRolledBack.setUsername("postgres");
		dataSourceThatCanBeRolledBack.setPassword("postgres1");
		
		dataSourceThatCanBeRolledBack.setAutoCommit(false);		
	}
	
	@AfterClass
	public static void clean_up_after_yourself_plz() {
		dataSourceThatCanBeRolledBack.destroy();
	}
	
	@Before
	public void setup_object_under_test() {
		roads = new JDBCCountryDAO(dataSourceThatCanBeRolledBack);
	}
	
	@After
	public void walmart() throws SQLException {
		dataSourceThatCanBeRolledBack.getConnection().rollback();		
	}
	
	@Test
	public void save_inserts_a_new_country() {
		// ARRANGE: ... ?		
		Country oldMen = makeFakeCountry();
		
		// ACT: running the save() method
		roads.save(oldMen);
		
		// ASSERT: make sure it worked!
		Country foundCountry = roads.findCountryByCode(FAKE_COUNTRY_CODE);
		Assert.assertNotNull(foundCountry); // no country for old men
		Assert.assertEquals(oldMen.toString(), foundCountry.toString());
	}
	
	@Test
	public void delete_removes_a_country() {
		Country oldMen = makeFakeCountry();
		roads.save(oldMen);
		Country didIFindOldMen = roads.findCountryByCode(FAKE_COUNTRY_CODE);
		Assert.assertNotNull(didIFindOldMen); 
		Assert.assertEquals(oldMen.toString(), didIFindOldMen.toString());
		// PREGO! It's in there!
		
		// ACT
		boolean successfullyDeleted = roads.delete(FAKE_COUNTRY_CODE);		
		
		// ASSERT
		Assert.assertTrue(successfullyDeleted);
	}
	
	@Test
	public void update_updates_a_country() {
		Country oldMen = makeFakeCountry();
		roads.save(oldMen);

		// ACT
		oldMen.setIndepyear(2021); // Change the Java
		boolean succesfullyUpdated = roads.update(oldMen); // Change the Database
		
		// ASSERT
		Country didIFindOldMen = roads.findCountryByCode(FAKE_COUNTRY_CODE); // find whatever is now in the database
		Assert.assertTrue(succesfullyUpdated);
		Assert.assertEquals(oldMen.toString(), didIFindOldMen.toString());   // both should have 2021 now
	}
	
	private Country makeFakeCountry() {
		Country oldMen = new Country();
		oldMen.setCode(FAKE_COUNTRY_CODE);
		oldMen.setName("Tommy Lee Jones");
		oldMen.setHeadofstate("Javier Bardem");
		oldMen.setContinent("North America");
		oldMen.setRegion("Texas");                
		oldMen.setSurfacearea(0.0);      
		oldMen.setIndepyear(2007);          
		oldMen.setPopulation(4L);        
		oldMen.setLifeexpectancy(0.0);
		oldMen.setGnp(0.0);                      
		oldMen.setGnpold(0.0);                
		oldMen.setLocalname("Local Name");          
		oldMen.setGovernmentform("Lawlessness");
		oldMen.setHeadofstate("George W. Bush");      
		oldMen.setCapital(3800);              
		oldMen.setCode2("OM");                  

		return oldMen;
	}
}
