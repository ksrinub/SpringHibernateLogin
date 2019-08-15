package com.cms.example.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cms.example.dao.EmployeeDao;
import com.cms.example.model.Employee;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestContext.class})
@WebAppConfiguration
public class EmployeeControllerTest {
	@Mock
	private EmployeeDao employeeDao;
	
	@InjectMocks
	private  EmployeeController employeeController;
	
	private  MockMvc mockMvc;

	@Before
	public  void setUp() throws Exception {
		MockitoAnnotations.initMocks(EmployeeControllerTest.class);
		mockMvc=MockMvcBuilders.standaloneSetup(employeeController).build();
	}

	
	@Test
	public void testEmployeeList() throws Exception{
	  List<Employee> employees=new ArrayList<Employee>();	
	   
	  Employee emp1=new Employee();
	  emp1.setEmpId(222);
	  emp1.setEmpName("rohit");
	  emp1.setEmpAddress("Mp");
	  emp1.setSalary(10000d);
	  emp1.setAge(55);
	  
	  Employee emp2=new Employee();
	  emp2.setEmpId(333);
	  emp2.setEmpName("priya varrier");
	  emp2.setEmpAddress("AP");
	  emp2.setSalary(20000d);
	  emp2.setAge(22);
	  
	  employees.add(emp1);
	  employees.add(emp2); 
	  
	  when(employeeDao.listEmployee()).thenReturn((List<Employee>) employees);
	   mockMvc.perform(get("/employees"))
	          .andExpect(status().isOk())
	          .andExpect(view().name("employeeList"));
	   verify(employeeDao, times(1)).listEmployee();
       verifyNoMoreInteractions(employeeDao);
	     
	}
}
