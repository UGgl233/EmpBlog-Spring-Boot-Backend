package com.bht.humanresource.model;

import com.bht.humanresource.model.compositeprimarykey.JobDepartmentCPK;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity(name="salary_report")
public class SalaryReport {

    @EmbeddedId
    private JobDepartmentCPK jobDepartmentCPK;

    @Column(name="salmin")
    private BigDecimal salaryMin;

    @Column(name="salmax")
    private BigDecimal salaryMax;

    @Column(name="salavg")
    private BigDecimal salaryAvg;

    @Column(name="saltotal")
    private BigDecimal salaryTotal;

    @Column(name="empcount")
    private BigDecimal empCount;

    @Column(name="updatetime")
    private Date updateTime;

    public SalaryReport() {}

    public SalaryReport(JobDepartmentCPK jobDepartmentCPK, BigDecimal salaryMin,
                        BigDecimal salaryMax, BigDecimal salaryAvg, BigDecimal salaryTotal,
                        BigDecimal empCount, Date updateTime) {
        this.jobDepartmentCPK = jobDepartmentCPK;
        this.salaryMin = salaryMin;
        this.salaryMax = salaryMax;
        this.salaryAvg = salaryAvg;
        this.salaryTotal = salaryTotal;
        this.empCount = empCount;
        this.updateTime = updateTime;
    }

    public JobDepartmentCPK getJobDepartmentCPK() {
        return jobDepartmentCPK;
    }

    public void setJobDepartmentCPK(JobDepartmentCPK jobDepartmentCPK) {
        this.jobDepartmentCPK = jobDepartmentCPK;
    }

    public BigDecimal getSalaryMin() {
        return salaryMin;
    }

    public void setSalaryMin(BigDecimal salaryMin) {
        this.salaryMin = salaryMin;
    }

    public BigDecimal getSalaryMax() {
        return salaryMax;
    }

    public void setSalaryMax(BigDecimal salaryMax) {
        this.salaryMax = salaryMax;
    }

    public BigDecimal getSalaryAvg() {
        return salaryAvg;
    }

    public void setSalaryAvg(BigDecimal salaryAvg) {
        this.salaryAvg = salaryAvg;
    }

    public BigDecimal getSalaryTotal() {
        return salaryTotal;
    }

    public void setSalaryTotal(BigDecimal salaryTotal) {
        this.salaryTotal = salaryTotal;
    }

    public BigDecimal getEmpCount() {
        return empCount;
    }

    public void setEmpCount(BigDecimal empCount) {
        this.empCount = empCount;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "SalaryReport{" +
                "jobDepartmentCPK=" + jobDepartmentCPK +
                ", salaryMin=" + salaryMin +
                ", salaryMax=" + salaryMax +
                ", salaryAvg=" + salaryAvg +
                ", salaryTotal=" + salaryTotal +
                ", empCount=" + empCount +
                ", updateTime=" + updateTime +
                '}';
    }
}
