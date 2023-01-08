package com.kishorek.models;

import java.io.Serializable;
import java.security.KeyPair;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Employee implements Serializable {
    private String id;
    private String name;
    private Department dept;

    private List<String> accesses;

    public Employee(){

    }

    public Employee(String id, String name, Department dept) {
        this.id = id;
        this.name = name;
        this.dept = dept;
    }

    public List<String> getAccesses() {
        return accesses;
    }

    public void setAccesses(List<String> accesses) {
        this.accesses = accesses;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    /*@Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
*/
    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dept=" + dept +
                ", accesses=" + accesses +
                "}" +
                " Hash: " + System.identityHashCode(this) +
                " Hex: " + Integer.toHexString(System.identityHashCode(this));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id.equals(employee.id) && name.equals(employee.name) && dept == employee.dept;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, dept);
    }
}
