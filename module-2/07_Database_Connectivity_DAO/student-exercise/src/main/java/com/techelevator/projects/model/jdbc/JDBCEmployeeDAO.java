package com.techelevator.projects.model.jdbc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Employee;
import com.techelevator.projects.model.EmployeeDAO;

public class JDBCEmployeeDAO implements EmployeeDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCEmployeeDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		ArrayList<Employee> employees = new ArrayList<>();
		String sqlFindAllEmployees = "SELECT employee_id, department_id, first_name, last_name, birth_date, gender, hire_date " +
									 "FROM employee";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindAllEmployees);
		if(results.next()) {
			Employee theEmployee = mapRowToEmployee(results);
			employees.add(theEmployee);
		} return employees;
	}

	@Override
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {
		ArrayList<Employee> employees = new ArrayList<>();
		String sqlFindAllEmployees = "SELECT employee_id, department_id, first_name, last_name, birth_date, gender, hire_date " +
									 "FROM employee " +
									 "WHERE first_name = ? " +
									 "AND last_name = ? ";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindAllEmployees, firstNameSearch, lastNameSearch);
		if(results.next()) {
			Employee theEmployee = mapRowToEmployee(results);
			employees.add(theEmployee);
		} return employees;
	}

	@Override
	public List<Employee> getEmployeesByDepartmentId(long id) {
		ArrayList<Employee> employees = new ArrayList<>();
		String sqlFindAllEmployees = "SELECT employee_id, department_id, first_name, last_name, birth_date, gender, hire_date " +
									 "FROM employee " +
									 "WHERE department_id = ? ";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindAllEmployees, id);
		if(results.next()) {
			Employee theEmployee = mapRowToEmployee(results);
			employees.add(theEmployee);
		} return employees;
	}

	@Override
	public List<Employee> getEmployeesWithoutProjects() {
		return new ArrayList<>();
	}

	@Override
	public List<Employee> getEmployeesByProjectId(Long projectId) {
		return new ArrayList<>();
	}

	@Override
	public void changeEmployeeDepartment(Long employeeId, Long departmentId) {
		
	}
	
	private Employee mapRowToEmployee(SqlRowSet results) {
		Employee theEmployee;
		theEmployee = new Employee();
		theEmployee.setId(results.getLong("employee_id"));
		theEmployee.setDepartmentId(results.getLong("department_id"));
		theEmployee.setFirstName(results.getString("first_name"));
		theEmployee.setLastName(results.getString("last_name"));
		theEmployee.setGender(results.getString("gender").charAt(0));
		try {
			theEmployee.setBirthDay(LocalDate.parse(results.getString("birth_date")));
		} catch (Exception e){	
		} //end try-catch
		try {
			theEmployee.setHireDate(LocalDate.parse(results.getString("hire_date")));
		} catch (Exception e){	
		} //end try-catch
		return theEmployee;
	}

}
