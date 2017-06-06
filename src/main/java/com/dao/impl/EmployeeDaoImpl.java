package main.java.com.dao.impl;

import main.java.com.dao.EmployeeDao;
import main.java.com.model.Employee;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.List;


/**
 * Created by gayathri on 6/6/17.
 */
public class EmployeeDaoImpl implements EmployeeDao{

    private SessionFactory factory;
    private Session session;
    private Transaction transaction = null;

    /*
    Configure Hibernate stuffs
     */
    @Override
    public void configuration(){
        try {
            factory = new Configuration().configure().buildSessionFactory(); //creating configuration and session factory object

        }catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /*
    Method for save
     */
    @Override
    public void save(Employee employee) {
        System.out.println(">>>>>>>> Save function >>>>>>>>>>");
        session = factory.openSession(); //creating session object
        try {
            transaction = session.beginTransaction();  //creating transaction object
            session.save(employee);
            transaction.commit();
            System.out.println("Save successfully employee "+employee.getId());

        }catch (HibernateException e){
            if(transaction != null)
                transaction.rollback();
            System.out.println("Error occured when saving record employee "+employee.getId());
            System.out.println(e);

        }finally {
            session.close();
        }

    }

    /*
    Method for update
     */
    @Override
    public void update(Employee employee) {
        System.out.println("\n\n>>>>>>> Update function >>>>>>>>>>");
        session = factory.openSession();
        try {
            transaction = session.beginTransaction();
            Employee emp = (Employee)session.get(Employee.class, employee.getId());
            System.out.println("Old salary -: "+emp.getSalary());
            emp.setSalary(employee.getSalary());
            System.out.println("New Salary -: "+emp.getSalary());

            session.update(emp);
            transaction.commit();
            System.out.println("Update successfully employee "+employee.getId());

        }catch (HibernateException e){
            if(transaction != null)
                transaction.rollback();
            System.out.println("Error occured when updating record of employee "+employee.getId());
            System.out.println(e);
        }finally {
            session.close();
        }
    }

    /*
    Method for delete
     */
    @Override
    public void delete(Employee employee) {
        System.out.println("\n\n>>>>>>>>>> Delete function >>>>>>>>>>>>");
        session = factory.openSession();
        try{
            transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
            System.out.println("Delete successfully employee "+employee.getId());

        }catch (HibernateException e){
            if(transaction != null)
                transaction.rollback();
            System.out.println("Error occured when deleting record employee "+employee.getId());
            System.out.println(e);
        }
        finally {
            session.close();
        }
    }

    /*
    Method for fetch data
     */
    @Override
    public List<Employee> fetchData() {
        System.out.println("\n\n>>>>>>>>>> Fetching function >>>>>>>>>>>>");
        session = factory.openSession();
        List<Employee> employeeList = null;
        try{
            transaction = session.beginTransaction();
           /* Query query = session.createQuery("FROM emp558");
            employeeList = query.list();*/

           employeeList = session.createQuery("FROM Employee").list();
            transaction.commit();

        }catch (HibernateException e){
            if(transaction != null)
                transaction.rollback();
            System.out.println("Error occured when fetching data");
            System.out.println(e);

        }finally {
            session.close();
        }

        return employeeList;
    }
}
