package com.cms.example.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cms.example.dao.EmployeeDao;
import com.cms.example.model.Employee;

@Controller
public class EmployeeController {
	
       @Autowired
       private EmployeeDao employeeDao;
      
     
       @RequestMapping(value="/save", method= RequestMethod.POST)
       public ModelAndView saveEmployee(HttpServletRequest request) {
    	   
    	   Employee employee = new Employee();
    	   employee.setEmpId(Integer.parseInt(request.getParameter("empid")));
    	   employee.setEmpName(request.getParameter("empname"));
    	   employee.setEmpAddress(request.getParameter("empaddress"));
    	   employee.setAge(Integer.parseInt(request.getParameter("empage")));
    	   employee.setSalary(Double.parseDouble(request.getParameter("empsalary")));
    	   
    	   employeeDao.addEmployee(employee);
    	   return new ModelAndView("index");   
       }
       
       @RequestMapping(value="/employees", method=RequestMethod.GET)
       public String listEmployee(Model model) {
    	   List<Employee> list = employeeDao.listEmployee();
    	   System.out.println(list);
    	   model.addAttribute("listemployees", list);
    	   return "employeeList";
       }
       
       @RequestMapping(value="/add", method=RequestMethod.GET)
       public ModelAndView addEmployee() {
    	   return new ModelAndView("addEmployee");
       }
       
       @RequestMapping(value="/delete", method=RequestMethod.GET)
       public ModelAndView deleteEmployee(@RequestParam("id")int empid, ModelMap map) {
    	   Employee employee = new Employee();
    	   employee.setEmpId(empid);
    	   employeeDao.deleteEmployee(employee);
    	   List<Employee> list = employeeDao.listEmployee();
    	   map.addAttribute("employee", list);
    	   return new ModelAndView("employeeList");
       }
       
       @RequestMapping(value="/edit", method=RequestMethod.GET)
       public ModelAndView editEmployee(@RequestParam("id")int empid, ModelMap map) {
    	   
    	   return new ModelAndView("editEmployee","eid",empid);
       }
 }
