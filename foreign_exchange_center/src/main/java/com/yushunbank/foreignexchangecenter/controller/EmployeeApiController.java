//package com.yushunbank.foreignexchangecenter.controller;
//
//import java.util.List;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.yushunbank.foreignexchangecenter.model.Employee;
//import com.yushunbank.foreignexchangecenter.service.EmployeeService;
//
//@RestController
//@RequestMapping("/api/employees")
//public class EmployeeApiController {
//	private EmployeeService employeeService;
//
//	public EmployeeApiController(EmployeeService employeeService) {
//		super();
//		this.employeeService = employeeService;
//	}
//	
//	
//	
//	
//	
//	
//	
//	// build create employee REST API
//	// [POST]http://localhoast:8888/api/employees +body value
//	@PostMapping()
//	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
//		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
//	}
//
//	// build get all employees REST API
//	// [GET]http://localhoast:8888/api/employees
//	@GetMapping
//	public List<Employee> getAllEmployees() {
//		
//		return employeeService.getAllEmployees();
//	}
//
//	// build get employee by id
//	// [GET]http://localhoast:8888/api/employees/1
//	@GetMapping("{id}")
//	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId) {
//		return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);
//	}
//
//	// build update employee REST API
//	// [PUT]http://localhoast:8888/api/employees/1
//	@PutMapping("{id}")
//	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id,@RequestBody Employee employee) {
//		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
//	}
//	
//	//build delete employee REST API
//	//[DELETE]http://localhoast:8888/api/employees/1
//	@DeleteMapping("{id}")
//	public ResponseEntity<String> deleteEmployee(@PathVariable("id")long id){
//		
//		//delete employee from DB
//		employeeService.deleteEmployee(id);
//		return new ResponseEntity<String>("Employee deleted successfully!", HttpStatus.OK);
//	}
//
//}
