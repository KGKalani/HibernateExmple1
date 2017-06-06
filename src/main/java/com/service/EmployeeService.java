package main.java.com.service;

import main.java.com.model.Employee;

import java.util.List;

/**
 * Created by gayathri on 6/6/17.
 */
public interface EmployeeService {

    public void configuration();

    public void save(Employee employee);

    public void update(Employee employee);

    public void delete(Employee employee);

    public List<Employee> fetchData();
}
