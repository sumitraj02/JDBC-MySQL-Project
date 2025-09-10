package com.example.demo.controller;


import com.example.demo.dao.EmployeeDAO;
import com.example.demo.model.Employee;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeDAO employeeDAO;

    public EmployeeController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    // CREATE
    @PostMapping
    public String addEmployee(@RequestBody Employee emp) {
        employeeDAO.save(emp);
        return "Employee added successfully!";
    }

    // READ ALL
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeDAO.findAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable int id) {
        return employeeDAO.findById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public String updateEmployee(@PathVariable int id, @RequestBody Employee emp) {
        emp.setId(id);
        employeeDAO.update(emp);
        return "Employee updated successfully!";
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id) {
        employeeDAO.delete(id);
        return "Employee deleted successfully!";
    }
}

