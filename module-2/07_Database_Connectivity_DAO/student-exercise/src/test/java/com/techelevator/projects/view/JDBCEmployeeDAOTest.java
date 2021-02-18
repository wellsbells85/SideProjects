package com.techelevator.projects.view;

import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.projects.model.jdbc.JDBCDepartmentDAO;

public class JDBCEmployeeDAOTest {
	
	private static SingleConnectionDataSource dataSource;
	private JDBCDepartmentDAO dao;
	private static final String EMPLOYEE_ID = "DEFAULT";
	private static final String DEPARTMENT_ID = "DEFAULT";
	private static final String FIRST_NAME = "TestFirst";
	private static final String LAST_NAME = "TestLast";
	private static final String BIRTH_DATE = "1999-01-01";
	private static final String GENDER = "M";
	private static final String HIRE_DATE = "2021-01-01";
	

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
		String sqlInsertDummyDepartment = "INSERT INTO employee (employee_id, department_id, first_name, last_name, birth_date, gender, hire_date) "
										+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sqlInsertDummyDepartment, EMPLOYEE_ID, DEPARTMENT_ID, FIRST_NAME, LAST_NAME, BIRTH_DATE, GENDER, HIRE_DATE);
		dao = new JDBCDepartmentDAO(dataSource);
	}

	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
}
