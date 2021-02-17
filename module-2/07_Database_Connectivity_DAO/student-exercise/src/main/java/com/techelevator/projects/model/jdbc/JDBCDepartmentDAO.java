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
		ArrayList<Department> departments = new ArrayList<>();
		String sqlFindAllDepartments = "SELECT department_id, name" +
									   "FROM department";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindAllDepartments);
		if(results.next()) {
			Department theDepartment = mapRowToDepartment(results);
			departments.add(theDepartment);
		} return departments;
	}

	@Override
	public List<Department> searchDepartmentsByName(String nameSearch) {
		ArrayList<Department> departments = new ArrayList<>();
		String sqlFindDepartmentsByName = "SELECT department_id, name" +
										  "FROM department" +
										  "WHERE name = ? ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindDepartmentsByName, nameSearch);
		if(results.next()) {
			Department theDepartment = mapRowToDepartment(results);
			departments.add(theDepartment);
		}
		return departments;
	}

	@Override
	public void saveDepartment(Department updatedDepartment) {
		String sqlInsertDepartment = "INSERT INTO department(department_id, name) " +
									 "VALUES (?,?)";
		
		jdbcTemplate.update(sqlInsertDepartment, updatedDepartment.getId(), updatedDepartment.getName());
	}

	@Override
	public Department createDepartment(Department newDepartment) {
		String sqlInsertDepartment = "INSERT INTO department(department_id, name) " +
				 "VALUES (?,?)";

		newDepartment.setId(getNextDepartmentId());
		jdbcTemplate.update(sqlInsertDepartment, newDepartment.getId(), newDepartment.getName());
		return null;
	}

	@Override
	public Department getDepartmentById(Long id) {
		Department theDepartment = null;
		String sqlFindDepartmentById = "SELECT department_id, name" +
									   "FROM department" +
									   "WHERE department_id = ? ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindDepartmentById, id);
		if(results.next()) {
			theDepartment = mapRowToDepartment(results);
		} return theDepartment;
	}
	
	private long getNextDepartmentId() {
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('seq_department_id')");
		if(nextIdResult.next()) {
			return nextIdResult.getLong(1);
		} else {
			throw new RuntimeException("Something went wrong while getting an id for the new city");
		}
	}
	
	private Department mapRowToDepartment(SqlRowSet results) {
		Department theDepartment;
		theDepartment = new Department();
		theDepartment.setId(results.getLong("department_id"));
		theDepartment.setName(results.getString("name"));
		return theDepartment;
	}

}
