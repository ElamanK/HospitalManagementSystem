package database.bankdb.dao.mybatis;
import database.bankdb.dao.daointerfaces.IEmployeesDAO;
import database.bankdb.models.Employee;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class EmployeeService implements IEmployeesDAO {

    private static final SqlSessionFactory SESSION_FACTORY = MyBatisDaoFactory.getSqlSessionFactory();

    @Override
    public Employee getEntityById(int id) {
        Employee employee;
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IEmployeesDAO employeesDAO = sqlSession.getMapper(IEmployeesDAO.class);
            employee = employeesDAO.getEntityById(id);
        }
        return employee;
    }

    @Override
    public void updateEntity(int id, Employee entity) {
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IEmployeesDAO employeesDAO = sqlSession.getMapper(IEmployeesDAO.class);
            employeesDAO.updateEntity(id, entity);
            sqlSession.commit();
        }
    }

    @Override
    public Employee createEntity(Employee entity) {
        Employee employee;
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IEmployeesDAO employeesDAO = sqlSession.getMapper(IEmployeesDAO.class);
            employee = employeesDAO.createEntity(entity);
            sqlSession.commit();
        }
        return employee;
    }

    @Override
    public void removeEntity(int id) {
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IEmployeesDAO employeesDAO = sqlSession.getMapper(IEmployeesDAO.class);
            employeesDAO.removeEntity(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Employee> getAllEntities() {
        List<Employee> employees;
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IEmployeesDAO employeesDAO = sqlSession.getMapper(IEmployeesDAO.class);
            employees = employeesDAO.getAllEntities();
        }
        return employees;
    }

    @Override
    public void insertEntity(Employee employee) {
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IEmployeesDAO employeesDAO = sqlSession.getMapper(IEmployeesDAO.class);
            employeesDAO.insertEntity(employee);
            sqlSession.commit();
        }
    }
}
