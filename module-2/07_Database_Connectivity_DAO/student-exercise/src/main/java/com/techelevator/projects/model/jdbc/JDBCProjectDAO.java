package com.techelevator.projects.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Project;
import com.techelevator.projects.model.ProjectDAO;

public class JDBCProjectDAO implements ProjectDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCProjectDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Project> getAllActiveProjects() {
		List<Project> projectList = new ArrayList<>();
		String sqlFindAllActiveProjects = "SELECT name, project_id FROM project WHERE to_date IS NULL";	
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindAllActiveProjects);
		while(results.next()) {
			Project project = new Project();
			project.setName(results.getString("name"));
			project.setId(results.getLong("project_id"));
			projectList.add(project);	
		} return projectList;
	}

	@Override
	public void removeEmployeeFromProject(Long projectId, Long employeeId) {
		String sqlRemoveEmployeeFromProject = "DELETE FROM project_employee WHERE project_id = ? AND employee_id = ?";	
		jdbcTemplate.update(sqlRemoveEmployeeFromProject, projectId , employeeId);
	}

	@Override
	public void addEmployeeToProject(Long projectId, Long employeeId) {
		String sqlAddEmployeeToProject = "INSERT INTO project_employee(project_id, employee_id) VALUES(?,?)";	
		jdbcTemplate.update(sqlAddEmployeeToProject, projectId , employeeId);
	}

}
