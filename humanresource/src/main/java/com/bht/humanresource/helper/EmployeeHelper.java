package com.bht.humanresource.helper;

import com.bht.humanresource.dao.EmployeeRepository;
import com.bht.humanresource.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class EmployeeHelper {
    @Autowired
    private EmployeeRepository repo;

    public Employee getEmployeeById(Integer id) {
        return repo.findByEmpId(id);
    }

    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    public void createEmployee(Employee temp) {
        repo.saveAndFlush(temp);
    }

    public void updateEmployee(Integer id, Employee temp) {
        Employee updateEmp = repo.findByEmpId(id);
        updateEmp.setHiredate(temp.getHiredate());
        updateEmp.setJob(temp.getJob());
        updateEmp.setName(temp.getName());
        updateEmp.setSalary(temp.getSalary());
        repo.save(updateEmp);
    }

    @Transactional
    public void deleteEmployeeById(Integer id) {
        repo.deleteByEmpId(id);
    }

    public void deleteAllEmployees() {
        repo.deleteAll();
    }

}
