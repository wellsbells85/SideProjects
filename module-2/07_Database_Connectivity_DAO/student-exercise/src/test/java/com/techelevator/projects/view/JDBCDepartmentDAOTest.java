package com.techelevator.projects.view;

import java.sql.SQLException;
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
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.jdbc.JDBCDepartmentDAO;


public class JDBCDepartmentDAOTest {

	private static SingleConnectionDataSource dataSource;
	private static final String NAME = "Test Department";
	private Long nextId;
	private JDBCDepartmentDAO dao;
	
	
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
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		SqlRowSet nextIdResult = jdbc.queryForRowSet("SELECT nextval('seq_department_id')");
		if (nextIdResult.next()) {
			nextId = nextIdResult.getLong(1);
		} else {
			throw new RuntimeException("Something went wrong while getting an id for the new city");
		}
		String sqlTestDepartmentInsert = "INSERT INTO department (department_id, name) VALUES (?,?)";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); // Get a new JDBCTemplate object to run the insert
		jdbcTemplate.update(sqlTestDepartmentInsert, nextId, NAME);
		dao = new JDBCDepartmentDAO(dataSource);
	}

	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	@Test
	public void test_get_all_departments_method() {
		List<Department> departmentList = new LinkedList<>();
		departmentList = dao.getAllDepartments();
		Department testDepartment = departmentList.get(departmentList.size() - 1);
		String testName = testDepartment.getName();
		Assert.assertNotNull(departmentList);
		Assert.assertEquals(testName, NAME);
	}
	
	@Test
	public void test_search_departments_by_name_method() {
		List<Department> departmentList = dao.searchDepartmentsByName(NAME);
		Department testDepartment = departmentList.get(departmentList.size() - 1);
		String testName = testDepartment.getName();
		Assert.assertNotNull(departmentList);
		Assert.assertEquals(1, departmentList.size());
		Assert.assertEquals(testName, NAME);
	}
	
	@Test
	public void test_save_department_and_get_department_by_id() {
		Department test = makeDepartmentObject(nextId, "Restest Name");
		dao.saveDepartment(test);
		Assert.assertNotEquals(NAME, dao.getDepartmentById(nextId).getName());
		Assert.assertEquals("Restest Name", dao.getDepartmentById(nextId).getName());
	}
	
	@Test
	public void test_create_department() {
		Department test = makeDepartmentObject(null, "Final Department");
		dao.createDepartment(test);
		List<Department> departmentList = new LinkedList<>();
		departmentList = dao.getAllDepartments();
		Department testDepartment = departmentList.get(departmentList.size() - 1);
		String testName = testDepartment.getName();
		Assert.assertNotNull(departmentList);
		Assert.assertEquals(testName, "Final Department");
	}
	
	
	private Department makeDepartmentObject(Long department_id, String name) {
		Department theDepartment = new Department();
		theDepartment.setId(department_id);
		theDepartment.setName(name);
		return theDepartment;
	}

		
} //end class
