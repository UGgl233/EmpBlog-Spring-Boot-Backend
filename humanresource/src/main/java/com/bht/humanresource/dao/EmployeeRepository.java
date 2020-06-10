package com.bht.humanresource.dao;

import com.bht.humanresource.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee findByEmpId(Integer empid);

    void deleteByDepId(Integer depid);

    @Transactional
    void deleteByEmpId(Integer empid);
}
