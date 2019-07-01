package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import demo.entity.Employee;
import demo.service.EmployeeService;

import java.util.List;

@RestController
@CrossOrigin
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        List<Employee> employees = employeeService.getEmployees();
        return employees;
    }

    @GetMapping("/employees/{id}")
    public Employee getOneEmployee(@PathVariable Long id) {
        Employee employee = employeeService.getOneEmployee(id);
        return employee;
    }

    @PostMapping("/employees")
    Employee newEmployee(@RequestBody Employee newEmployee) {
        Employee employee = employeeService.createEmployee(newEmployee);
        return employee;
    }

    @PutMapping("/employees/{id}")
    Employee updateEmployee(@RequestBody Employee employee, @PathVariable Long id) {
        Employee result = employeeService.updateEmployee(employee, id);
        return result;
    }

    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
}