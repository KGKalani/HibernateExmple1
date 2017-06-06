package main.java.com.controller;

import main.java.com.dao.EmployeeDao;
import main.java.com.dao.impl.EmployeeDaoImpl;
import main.java.com.model.Employee;
import main.java.com.service.EmployeeService;
import main.java.com.service.impl.EmployeeServiceImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Created by gayathri on 6/5/17.
 */
public class Main {
    public static void main(String[] args) {
        List<Employee> employeeList;
        EmployeeService employeeService = new EmployeeServiceImpl();

        /*
        Set up hibernate configurations
         */
        employeeService.configuration();

        /*
        Save new record
         */
        int id = 1;
        String name = "Bob";
        Float salary = 20000f;

        Employee e1 = new Employee(id,name,salary);
        employeeService.save(e1);

        Employee e2 = new Employee(2, "Alise", 25000f);
        employeeService.save(e2);

        /*
        Update a record
         */
        id = 1;
        salary = 21000f;

        e1.setSalary(salary);
        employeeService.update(e1);


         /*
        Fetching data before dalate
         */
        employeeList = employeeService.fetchData();
        System.out.println();
        for(Employee employee: employeeList){
            System.out.println("ID -: " +employee.getId());
            System.out.println("Name -: " +employee.getName());
            System.out.println("Salary -: " +employee.getSalary());
            System.out.println();
        }

        /*
        Delete a record
         */
        employeeService.delete(e1);

        /*
        Fetching data after dalate
         */
        employeeList = employeeService.fetchData();
        System.out.println();
        for(Employee employee: employeeList){
            System.out.println("ID -: " +employee.getId());
            System.out.println("Name -: " +employee.getName());
            System.out.println("Salary -: " +employee.getSalary());
            System.out.println();
        }
    }
}
