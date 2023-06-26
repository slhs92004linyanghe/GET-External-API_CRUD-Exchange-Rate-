//package com.yushunbank.foreignexchangecenter.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.yushunbank.foreignexchangecenter.model.Employee;
//import com.yushunbank.foreignexchangecenter.service.EmployeeService;
//
//@Controller
//public class EmployeeViewController {
//	@Autowired
//	private EmployeeService employeeService ;
//	
//	@RequestMapping("/")
//	public String viewEmployeePage(Model model) {
//		List<Employee> listEmployees = employeeService.getAllEmployees();
//		model.addAttribute("listEmployees", listEmployees);
//		return "index";
//	}
//	@RequestMapping("/add")
//	public String showAddEmployeeForm(Model model) {
//		Employee employee = new Employee();
//		model.addAttribute("employee", employee);
//		return "added_employee";
//	}
//	
//	//處理th:action="@{/save} 使用到有added_employee.html
//	@RequestMapping(value = "/save",method = RequestMethod.POST)
//	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
//		employeeService.saveEmployee(employee);
//		return "redirect:/";
//	}
//	@RequestMapping("/edit/{id}")
//	public ModelAndView showEditEmpmloyee(@PathVariable(name="id") long id) {
//		ModelAndView mav = new ModelAndView("edit_employee");
//		Employee employee =employeeService.getEmployeeById(id);
//		mav.addObject("employee", employee);
//		return mav;
//	}
//	@RequestMapping("/delete/{id}")
//	public String deleteEditEmpmloyee(@PathVariable(name="id") long id) {
//		employeeService.deleteEmployee(id);
//		return "redirect:/";
//	}
//	
//	
//}
