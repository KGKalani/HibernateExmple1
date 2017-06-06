package main.java.com.service.impl;

import main.java.com.dao.EmployeeDao;
import main.java.com.dao.impl.EmployeeDaoImpl;
import main.java.com.model.Employee;
import main.java.com.service.EmployeeService;

import java.util.List;

/**
 * Created by gayathri on 6/6/17.
 */
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDao employeeDao;

    public EmployeeServiceImpl(){
       employeeDao = new EmployeeDaoImpl();
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public void configuration() {
        employeeDao.configuration();
    }

    @Override
    public void save(Employee employee) {
        employeeDao.save(employee);
    }

    @Override
    public void update(Employee employee) {
        employeeDao.update(employee);
    }

    @Override
    public void delete(Employee employee) {
        employeeDao.delete(employee);
    }

    @Override
    public List<Employee> fetchData() {
        return employeeDao.fetchData();
    }
}
