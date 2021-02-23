package com.techelevator.projects.view;

import java.util.List;
import java.sql.SQLException;

import org.junit.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.projects.model.Project;
import com.techelevator.projects.model.jdbc.JDBCProjectDAO;

public class JDBCProjectDAOTest {
	
	private static SingleConnectionDataSource dataSource;
	private JDBCProjectDAO dao;
//	private static final Long PROJECT_ID = Long.valueOf(2);	These were to be used for adding and removing from projects
//	private static final Long EMPLOYEE_ID = Long.valueOf(12); However, I don't know how to very the data since it's in another table
	
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/projects");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		dataSource.setAutoCommit(false);
	}

	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}

	@Before
	public void setup() {
		dao = new JDBCProjectDAO(dataSource);
	}

	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	@Test
	public void test_get_all_active_projects() {
		List<Project> projectList = dao.getAllActiveProjects();
		Assert.assertEquals(2, projectList.size());
	}
	
	@Test
	public void test_add_employee_and_remove_employee_from_test() {
		//don't know how to use Mockito to test methods like this yet
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
