package com.niit.Rest_SkillMap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.model.Employee;
import com.niit.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeDAOController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping
	public ResponseEntity<Void> addEmployee(@RequestBody Employee employee){
		if(employeeService.getEmployee(employee.getEmpID())!=null) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		else {
			employeeService.addEmployee(employee);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
	}
	
	@PutMapping
	public ResponseEntity<Void> updateEmployee(@RequestBody Employee employee) {
		if(employeeService.getEmployee(employee.getEmpID())!=null) {
			employeeService.updateEmployee(employee);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{empID}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable("empID") int empID){
		if(employeeService.getEmployee(empID)!= null) {
			employeeService.deleteEmployee(empID);
			return new ResponseEntity<Void> (HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Void> (HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/{empID}")
	public ResponseEntity<Employee> getByID(@PathVariable("empID") int empID){
		if(employeeService.getById(empID) != null) {
			return new ResponseEntity<Employee> (employeeService.getById(empID), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Employee> (HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping
	public List<Employee> listAllEmployee(){
		List<Employee> employee = employeeService.listEmployee();
		return employee;
	}
	
}
