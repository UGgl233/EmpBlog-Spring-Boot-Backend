package com.bht.humanresource.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name="employee")
public class Employee {
    @Id
    @Column(name="empid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer empId;

    private String name;

    private String job;

    @Column(name="manager")
    private Integer managerId;

    @JsonFormat(pattern="yyyy-MM-dd", timezone="EST")
    private Date hiredate;

    private BigDecimal salary;

    @Column(name="depid")
    private Integer depId;

    public Employee(){}

    public Employee(Integer empId, String name, String job, Integer managerId,
                    Date hiredate, BigDecimal salary, Integer depId) {
        this.empId = empId;
        this.name = name;
        this.job = job;
        this.managerId = managerId;
        this.hiredate = hiredate;
        this.salary = salary;
        this.depId = depId;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", managerId=" + managerId +
                ", hiredate=" + hiredate +
                ", salary=" + salary +
                ", depId=" + depId +
                '}';
    }
}
