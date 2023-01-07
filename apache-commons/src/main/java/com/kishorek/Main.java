package com.kishorek;

import com.kishorek.models.Department;
import com.kishorek.models.Employee;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        Employee employee = new Employee("E101", "John Doe", Department.FINANCE);
        employee.setAccesses(new ArrayList<>(Arrays.asList(new String[]{"Main Gate", "Locker", "Office"})));
        System.out.println(employee);

        Employee clonedEmployee = (Employee) BeanUtils.cloneBean(employee);
        clonedEmployee.setId("E102");
        clonedEmployee.getAccesses().remove(0);
        System.out.println(clonedEmployee);
        System.out.println(employee);

        Employee employee2 = new Employee();
        BeanUtils.copyProperties(employee2, employee);
        employee2.getAccesses().remove(0);
        System.out.println(employee2);
        System.out.println(employee);
    }
}