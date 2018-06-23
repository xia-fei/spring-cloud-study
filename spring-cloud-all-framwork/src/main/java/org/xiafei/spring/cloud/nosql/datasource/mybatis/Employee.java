package org.xiafei.spring.cloud.nosql.datasource.mybatis;

import java.io.Serializable;

/**
 * @author 夏飞
 */
public class Employee implements Serializable {
    private int id;
    private String name;
    private int salary;
    private int DepartmentId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getDepartmentId() {
        return DepartmentId;
    }

    public void setDepartmentId(int departmentId) {
        DepartmentId = departmentId;
    }
}
