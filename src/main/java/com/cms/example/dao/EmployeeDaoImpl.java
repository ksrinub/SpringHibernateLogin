package com.cms.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cms.example.model.Employee;

@Repository("employeeDao")
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public void addEmployee(Employee employee) {

		
		    hibernateTemplate.saveOrUpdate(employee);
		
	}
	

	public List<Employee> listEmployee() {
		
		List<Employee> list = hibernateTemplate.loadAll(Employee.class);
		
		return list;
	}
	
	public void deleteEmployee(Employee employee) {
		hibernateTemplate.delete(employee);
	}

	public Employee getEmployeeeById(int empid) {
		Employee employee=(Employee)hibernateTemplate.load(Employee.class,empid);
		
		return employee;
	}

	
	
}
