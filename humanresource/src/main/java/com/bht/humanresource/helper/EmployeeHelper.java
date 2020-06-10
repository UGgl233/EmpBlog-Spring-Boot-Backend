package com.bht.humanresource.helper;

import com.bht.humanresource.dao.EmployeeRepository;
import com.bht.humanresource.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Component
public class EmployeeHelper {

    private static int PAGE_SIZE = 5;

    @Autowired
    private EmployeeRepository repo;

    public Employee getEmployeeById(Integer id) {
        return repo.findByEmpId(id);
    }

    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    public List<Employee> getPageEmployees(Integer pageNumber) {
        Sort sort = new Sort(Sort.Direction.ASC, "empId");
        Pageable pageable = PageRequest.of(--pageNumber, PAGE_SIZE, sort);
        Page<Employee> users = repo.findAll(pageable);
        Iterator<Employee> employeeIterator =  users.iterator();
        List<Employee> list = new LinkedList<>();
        while(employeeIterator.hasNext()){
            list.add(employeeIterator.next());
        }
        return list;
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
