package com.cms.example.dao;

import java.util.List;

import com.cms.example.model.Employee;

public interface EmployeeDao {

	public void addEmployee(Employee employee);
    public List<Employee> listEmployee();
    public void deleteEmployee(Employee employee);
    public Employee getEmployeeeById(int emid);
}
