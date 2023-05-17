package in.ineuron.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.ineuron.model.Employee;

@Repository
public class EmployeeDaoImpl implements IEmployeeDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.save(employee);
    }

    public List<Employee> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Employee", Employee.class).getResultList();
    }


}