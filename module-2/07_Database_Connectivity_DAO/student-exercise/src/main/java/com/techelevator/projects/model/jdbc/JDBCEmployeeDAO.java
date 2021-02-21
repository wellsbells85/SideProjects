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
		List<Employee> employeeList = new ArrayList<>();
		String sqlFindAllEmployees = "SELECT employee_id, department_id, first_name, last_name, birth_date, gender, hire_date FROM employee";	
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindAllEmployees);
		while(results.next()) {
			Employee employee = new Employee();
			employee.setId(results.getLong("employee_id"));
			employee.setDepartmentId(results.getLong("department_id"));
			employee.setFirstName(results.getString("first_name"));
			employee.setLastName(results.getString("last_name"));
			employee.setBirthDay(LocalDate.parse(results.getString("birth_date")));
			employee.setGender(results.getString("gender").charAt(0));
			employee.setHireDate(LocalDate.parse(results.getString("hire_date")));
			employeeList.add(employee);	
		} return employeeList;
	} //end getAllEmployees()

	@Override
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {
		List<Employee> employeeList = new ArrayList<>();
		String sqlFindAllEmployees = "SELECT employee_id, department_id, first_name, last_name, birth_date, gender, hire_date " +
									 "FROM employee WHERE first_name ILIKE ? AND last_name ILIKE ? ";	
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindAllEmployees, "%" + firstNameSearch + "%", "%" + lastNameSearch + "%");
		while(results.next()) {
			Employee employee = new Employee();
			employee.setId(results.getLong("employee_id"));
			employee.setDepartmentId(results.getLong("department_id"));
			employee.setFirstName(results.getString("first_name"));
			employee.setLastName(results.getString("last_name"));
			employee.setBirthDay(LocalDate.parse(results.getString("birth_date")));
			employee.setGender(results.getString("gender").charAt(0));
			employee.setHireDate(LocalDate.parse(results.getString("hire_date")));
			employeeList.add(employee);	
		} return employeeList;
	} //end searchEmployeesByName()

	@Override
	public List<Employee> getEmployeesByDepartmentId(long id) {
		List<Employee> employeeList = new ArrayList<>();
		String sqlFindAllEmployees = "SELECT employee_id, department_id, first_name, last_name, birth_date, gender, hire_date " +
				  					 "FROM employee WHERE department_id = ? ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindAllEmployees, id);
		while(results.next()) {
			Employee employee = new Employee();
			employee.setId(results.getLong("employee_id"));
			employee.setDepartmentId(results.getLong("department_id"));
			employee.setFirstName(results.getString("first_name"));
			employee.setLastName(results.getString("last_name"));
			employee.setBirthDay(LocalDate.parse(results.getString("birth_date")));
			employee.setGender(results.getString("gender").charAt(0));
			employee.setHireDate(LocalDate.parse(results.getString("hire_date")));
			employeeList.add(employee);	
		} return employeeList;
	} //end getEmployeesByDepartmentId()

	@Override
	public List<Employee> getEmployeesWithoutProjects() {
		List<Employee> employeeList = new ArrayList<>();
		String sqlFindAllEmployees = 	"SELECT employee_id, department_id, first_name, last_name, birth_date, gender, hire_date " +
										"FROM employee " +
										"LEFT JOIN project_employee USING(employee_id) " +
										"WHERE project_id IS NULL";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindAllEmployees);
		while(results.next()) {
			Employee employee = new Employee();
			employee.setId(results.getLong("employee_id"));
			employee.setDepartmentId(results.getLong("department_id"));
			employee.setFirstName(results.getString("first_name"));
			employee.setLastName(results.getString("last_name"));
			employee.setBirthDay(LocalDate.parse(results.getString("birth_date")));
			employee.setGender(results.getString("gender").charAt(0));
			employee.setHireDate(LocalDate.parse(results.getString("hire_date")));
			employeeList.add(employee);	
		} return employeeList;
	} //end getEmployeesWithoutProjects

	@Override
	public List<Employee> getEmployeesByProjectId(Long projectId) {
		List<Employee> employeeList = new ArrayList<>();
		String sqlFindAllEmployees = 	"SELECT employee_id, department_id, first_name, last_name, birth_date, gender, hire_date " +
										"FROM employee " +
										"JOIN project_employee USING(employee_id) " +
										"WHERE project_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindAllEmployees, projectId);
		while(results.next()) {
			Employee employee = new Employee();
			employee.setId(results.getLong("employee_id"));
			employee.setDepartmentId(results.getLong("department_id"));
			employee.setFirstName(results.getString("first_name"));
			employee.setLastName(results.getString("last_name"));
			employee.setBirthDay(LocalDate.parse(results.getString("birth_date")));
			employee.setGender(results.getString("gender").charAt(0));
			employee.setHireDate(LocalDate.parse(results.getString("hire_date")));
			employeeList.add(employee);	
		} return employeeList;
	} //end getEmployeesByProjectId()

	@Override
	public void changeEmployeeDepartment(Long employeeId, Long departmentId) {
		String sqlChangeEmployeeDepartment = "UPDATE employee SET department_id = ? WHERE employee_id = ?";
		jdbcTemplate.update(sqlChangeEmployeeDepartment, departmentId,  employeeId);
	} //end changeEmployeeDepartment()

} //end class
