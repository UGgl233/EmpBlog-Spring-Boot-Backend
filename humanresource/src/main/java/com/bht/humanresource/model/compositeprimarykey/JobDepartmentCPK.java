package com.bht.humanresource.model.compositeprimarykey;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class JobDepartmentCPK implements Serializable {
    private String job;
    private String department;

    public JobDepartmentCPK() {
    }

    public JobDepartmentCPK(String job, String department) {
        this.job = job;
        this.department = department;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "JobDepartmentCPK{" +
                "job='" + job + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
