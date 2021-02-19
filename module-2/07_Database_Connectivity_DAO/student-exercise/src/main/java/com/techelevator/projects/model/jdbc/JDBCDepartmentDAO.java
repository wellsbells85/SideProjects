package com.techelevator.projects.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.DepartmentDAO;

public class JDBCDepartmentDAO implements DepartmentDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCDepartmentDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Department> getAllDepartments() {
		List<Department> departments = new ArrayList<>();
		String sqlFindAllDepartments = "SELECT name, department_id FROM department";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindAllDepartments);
		while (results.next()) {
			Department department = new Department();
			department.setName(results.getString("name"));
			department.setId(results.getLong("department_id"));
			departments.add(department);
		}
		return departments;
	} // end getAllDepartments()

	@Override
	public List<Department> searchDepartmentsByName(String nameSearch) {
		List<Department> departments = new ArrayList<>();
		String sqlFindDepartmentsByName = "SELECT name, department_id FROM department WHERE name ILIKE ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindDepartmentsByName, "%" + nameSearch + "%");
		while (results.next()) {
			Department department = new Department();
			department.setName(results.getString("name"));
			department.setId(results.getLong("department_id"));
			departments.add(department);
		}
		return departments;
	} // end searchDepartmentsByName()

	@Override
	public void saveDepartment(Department updatedDepartment) {
		String sqlUpdateDepartment = "UPDATE department SET name = ? WHERE department_id = ?";
		jdbcTemplate.update(sqlUpdateDepartment, updatedDepartment.getName(), updatedDepartment.getId());
	} // end saveDepartment()

	@Override
	public Department createDepartment(Department newDepartment) {
		String sqlInsertDepartment = "INSERT INTO department(department_id, name) " + "VALUES (?,?)";
		newDepartment.setId(getNextDepartmentId());
		jdbcTemplate.update(sqlInsertDepartment, newDepartment.getId(), newDepartment.getName());
		return newDepartment;
	} // end createDepartment()

	@Override
	public Department getDepartmentById(Long id) {
		Department department = new Department();
		String sqlFindDepartmentsById = "SELECT name, department_id FROM department WHERE department_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindDepartmentsById, id);
		while (results.next()) {
			department.setName(results.getString("name"));
			department.setId(results.getLong("department_id"));
		}
		return department;
	} // end getDepartmentById()

	private long getNextDepartmentId() {
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('seq_department_id')");
		if (nextIdResult.next()) {
			return nextIdResult.getLong(1);
		} else {
			throw new RuntimeException("Something went wrong while getting an id for the new city");
		}
	} // end getNextDepartmentId()

} // end class
