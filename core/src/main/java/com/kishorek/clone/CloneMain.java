package com.kishorek.clone;

import com.kishorek.models.Department;
import com.kishorek.models.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;

public class CloneMain {

    Logger logger = Logger.getLogger(CloneMain.class.getName());

    public static void main(String[] args) throws CloneNotSupportedException {
        Employee employee = new Employee("E101", "John Doe", Department.FINANCE);
        employee.setAccesses(new ArrayList<String>(Arrays.asList(new String[]{"Main Gate", "Locker", "Office"})));
        System.out.println(employee);
        System.out.println(employee.hashCode());
        System.out.println(System.identityHashCode(employee));
        System.out.println(Integer.toHexString(System.identityHashCode(employee)));

        Employee refCopiedEmployee = employee;
        refCopiedEmployee.setId("E102");
        System.out.println(employee);
        System.out.println(refCopiedEmployee);
        System.out.println(refCopiedEmployee.hashCode());
        System.out.println(System.identityHashCode(refCopiedEmployee));
        System.out.println(Integer.toHexString(System.identityHashCode(refCopiedEmployee)));

        Employee clonedEmployee = (Employee) employee.clone();
        clonedEmployee.setId("E103");
        clonedEmployee.getAccesses().remove(0);

        System.out.println(employee);
        System.out.println(refCopiedEmployee);
        System.out.println(clonedEmployee);
        System.out.println(clonedEmployee.hashCode());
        System.out.println(System.identityHashCode(clonedEmployee));
        System.out.println(Integer.toHexString(System.identityHashCode(clonedEmployee)));
    }
}
