package com.bht.humanresource.controller;

import com.bht.humanresource.model.Employee;
import com.bht.humanresource.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public void setService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public EmployeeService getService() {
        return employeeService;
    }

    @RequestMapping(value="/employees", method= RequestMethod.GET)
    public List<Employee> getEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/employee/{id}")
    public void updateEmployee(@PathVariable int id, @RequestBody Employee temp) {
        employeeService.updateEmployee(id, temp);
    }

    @PostMapping("/employee")
    public void createEmployee(@RequestBody Employee temp) {
        employeeService.createEmployee(temp);
    }

    @DeleteMapping("/employee/{id}")
    public void deleteEmployeeById(@PathVariable int id) {
        employeeService.deleteEmployeeById(id);
    }
}
