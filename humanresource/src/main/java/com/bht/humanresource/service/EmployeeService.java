package com.bht.humanresource.service;

import com.bht.humanresource.helper.EmployeeHelper;
import com.bht.humanresource.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeHelper employeeHelper;

    public Employee getEmployeeById(Integer id) {
        return employeeHelper.getEmployeeById(id);
    }

    public List<Employee> getAllEmployees() {
        return employeeHelper.getAllEmployees();
    }

    public List<Employee> getPageEmployees(Integer pageNumber) {
        return employeeHelper.getPageEmployees(pageNumber);
    }

    public void createEmployee(Employee temp) {
        employeeHelper.createEmployee(temp);
    }

    public void updateEmployee(Integer id, Employee temp) {
        employeeHelper.updateEmployee(id, temp);
    }

    @Transactional
    public void deleteEmployeeById(Integer id) {
        employeeHelper.deleteEmployeeById(id);
    }
}
