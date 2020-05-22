package com.bht.humanresource.helper;

import com.bht.humanresource.dao.EmployeeRepository;
import com.bht.humanresource.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeHelper {
    @Autowired
    private EmployeeRepository repo;

    public Employee getEmployeeById(int id) {
        return repo.findByEmpId(id);
    }

    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    public void createEmployee(Employee temp) {
        repo.save(temp);
    }

    public void updateEmployee(int id, Employee temp) {
        Employee updateEmp = repo.findByEmpId(id);
        updateEmp.setEmpId(temp.getEmpId());
        updateEmp.setHiredate(temp.getHiredate());
        updateEmp.setJob(temp.getJob());
        updateEmp.setManagerId(temp.getManagerId());
        updateEmp.setName(temp.getName());
        updateEmp.setSalary(temp.getSalary());
        repo.save(updateEmp);
    }

    public void deleteEmployeeById(int id) {
        repo.deleteByDepId(id);
    }

    public void deleteAllEmployees() {
        repo.deleteAll();
    }

}
