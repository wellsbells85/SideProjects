package com.techelevator.projects.view;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.projects.model.Employee;
import com.techelevator.projects.model.jdbc.JDBCEmployeeDAO;

public class JDBCEmployeeDAOTest {
	
	private static SingleConnectionDataSource dataSource;
	private JDBCEmployeeDAO dao;
	private static final String FIRST_NAME = "TestFirst";
	private static final String LAST_NAME = "TestLast";
	private static final LocalDate BIRTH_DATE = LocalDate.parse("1999-01-01");
	private static final char GENDER = 'M';
	private static final LocalDate HIRE_DATE = LocalDate.parse("2021-01-01");
	

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
		String sqlInsertDummyDepartment = "INSERT INTO employee (employee_id, department_id, first_name, last_name, birth_date, gender, hire_date) "
										+ "VALUES (DEFAULT,DEFAULT, ?, ?, ?, ?, ?)";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sqlInsertDummyDepartment, FIRST_NAME, LAST_NAME, BIRTH_DATE, GENDER, HIRE_DATE);
		dao = new JDBCEmployeeDAO(dataSource);
	}

	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	@Test
	public void test_get_all_employees() {
		List<Employee> employeeList = new LinkedList<>();
		employeeList = dao.getAllEmployees();
		Employee testEmployee = employeeList.get(employeeList.size() - 1);
		String firstName = testEmployee.getFirstName();
		String lastName = testEmployee.getLastName();
		LocalDate birthDate = testEmployee.getBirthDay();
		char gender = testEmployee.getGender();
		LocalDate hireDate = testEmployee.getHireDate();
		Assert.assertNotNull(employeeList);
		Assert.assertEquals(firstName, FIRST_NAME);
		Assert.assertEquals(lastName, LAST_NAME);
		Assert.assertEquals(birthDate, BIRTH_DATE);
		Assert.assertTrue(gender == GENDER);
		Assert.assertEquals(hireDate, HIRE_DATE);
	}
	
	@Test
	public void test_search_employees_by_name() {
		List<Employee> employeeList = new LinkedList<>();
		employeeList = dao.searchEmployeesByName(FIRST_NAME, LAST_NAME);
		Employee testEmployee = employeeList.get(employeeList.size() - 1);
		String firstName = testEmployee.getFirstName();
		String lastName = testEmployee.getLastName();
		LocalDate birthDate = testEmployee.getBirthDay();
		char gender = testEmployee.getGender();
		LocalDate hireDate = testEmployee.getHireDate();
		Assert.assertNotNull(employeeList);
		Assert.assertEquals(1, employeeList.size());
		Assert.assertEquals(firstName, FIRST_NAME);
		Assert.assertEquals(lastName, LAST_NAME);
		Assert.assertEquals(birthDate, BIRTH_DATE);
		Assert.assertTrue(gender == GENDER);
		Assert.assertEquals(hireDate, HIRE_DATE);
	}
	
	@Test
	public void test_get_employees_by_department_id() {
		List<Employee> firstList = new LinkedList<>();
		firstList = dao.getEmployeesByDepartmentId(1);
	}
	
	@Test
	public void test_get_employees_without_projects() {
		
	}
	
	@Test
	public void test_get_employees_by_project_id() {
		
	}
	
	@Test
	public void test_change_employee_department() {
	
	}
	
	private void assertEmployeesAreEqual(Employee expected, Employee actual) {
		Assert.assertEquals(expected.getId(), actual.getId());
		Assert.assertEquals(expected.getDepartmentId(), actual.getDepartmentId());
		Assert.assertEquals(expected.getFirstName(), actual.getFirstName());
		Assert.assertEquals(expected.getLastName(), actual.getLastName());
		Assert.assertEquals(expected.getBirthDay(), actual.getBirthDay());
		Assert.assertEquals(expected.getGender(), actual.getGender());
		Assert.assertEquals(expected.getHireDate(), actual.getHireDate());
	}
	
} //end class
