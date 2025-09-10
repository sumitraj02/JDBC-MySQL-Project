package com.example.demo.dao;

import com.example.demo.model.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class EmployeeDAO {
    private final JdbcTemplate jdbcTemplate;

    public EmployeeDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // CREATE
    public int save(Employee emp) {
        String sql = "INSERT INTO employee(name, department, salary) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, emp.getName(), emp.getDepartment(), emp.getSalary());
    }

    // READ (All)
    public List<Employee> findAll() {
        String sql = "SELECT * FROM employee";
        RowMapper<Employee> rowMapper = (rs, rowNum) -> {
            Employee emp = new Employee();
            emp.setId(rs.getInt("id"));
            emp.setName(rs.getString("name"));
            emp.setDepartment(rs.getString("department"));
            emp.setSalary(rs.getDouble("salary"));
            return emp;
        };
        return jdbcTemplate.query(sql, rowMapper);
    }

    // READ (By ID)
    public Employee findById(int id) {
        String sql = "SELECT * FROM employee WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            Employee emp = new Employee();
            emp.setId(rs.getInt("id"));
            emp.setName(rs.getString("name"));
            emp.setDepartment(rs.getString("department"));
            emp.setSalary(rs.getDouble("salary"));
            return emp;
        });
    }

    // UPDATE
    public int update(Employee emp) {
        String sql = "UPDATE employee SET name=?, department=?, salary=? WHERE id=?";
        return jdbcTemplate.update(sql, emp.getName(), emp.getDepartment(), emp.getSalary(), emp.getId());
    }

    // DELETE
    public int delete(int id) {
        String sql = "DELETE FROM employee WHERE id=?";
        return jdbcTemplate.update(sql, id);
    }
}
