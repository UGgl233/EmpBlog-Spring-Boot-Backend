package com.bht.humanresource.service;

import com.bht.humanresource.helper.EmployeeHelper;
import com.bht.humanresource.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeHelper employeeHelper;

    public Employee getEmployeeById(int id) {
        return employeeHelper.getEmployeeById(id);
    }

    public List<Employee> getAllEmployees() {
        return employeeHelper.getAllEmployees();
    }

    public void createEmployee(Employee temp) {
        employeeHelper.createEmployee(temp);
    }

    public void updateEmployee(int id, Employee temp) {
        employeeHelper.updateEmployee(id, temp);
    }

    public void deleteEmployeeById(int id) {
        employeeHelper.deleteEmployeeById(id);
    }
}
