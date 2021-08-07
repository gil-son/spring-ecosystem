package com.springbootcamel.controller;

import java.util.List;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springbootcamel.model.Employee;

@RestController
public class EmployeeController {
	
	@Autowired
	ProducerTemplate producerTemplate;
	
	
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public List<Employee> getAllEmployees() {
		List<Employee> employees = producerTemplate.requestBody("direct:select", null, List.class);
		return employees;

	}
	
	@RequestMapping(value = "/employees", consumes = "application/json", method = RequestMethod.POST)
	public boolean insertEmployee(@RequestBody Employee emp) {
		producerTemplate.requestBody("direct:insert", emp, List.class);
		return true;
	}
	

}
