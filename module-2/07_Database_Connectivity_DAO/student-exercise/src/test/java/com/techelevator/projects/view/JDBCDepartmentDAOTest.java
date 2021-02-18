package com.techelevator.projects.view;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.projects.model.jdbc.JDBCDepartmentDAO;


public class JDBCDepartmentDAOTest {

	private static SingleConnectionDataSource dataSource;
	private static final String NAME = "Test Department";
	private static final String DEPARTMENT_ID = "DEFAULT";
	private JDBCDepartmentDAO dao;

	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/world");
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
		String sqlInsertDummyDepartment = "INSERT INTO department (department_id, name) VALUES (?, ?)";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sqlInsertDummyDepartment, DEPARTMENT_ID, NAME);
		dao = new JDBCDepartmentDAO(dataSource);
	}

	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	
	
	
	
	
	
	
}
