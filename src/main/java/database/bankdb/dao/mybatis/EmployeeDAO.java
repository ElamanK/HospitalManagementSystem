package database.bankdb.dao.mybatis;
import database.bankdb.dao.daointerfaces.IEmployeeDAO;
import database.bankdb.models.Employee;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class EmployeeDAO implements IEmployeeDAO {

    private static final SqlSessionFactory SESSION_FACTORY = MyBatisDaoFactory.getSqlSessionFactory();

    @Override
    public Employee getEntityById(int id) {
        Employee employee;
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IEmployeeDAO employeesDAO = sqlSession.getMapper(IEmployeeDAO.class);
            employee = employeesDAO.getEntityById(id);
        }
        return employee;
    }

    @Override
    public void updateEntity(Employee entity) {
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IEmployeeDAO employeesDAO = sqlSession.getMapper(IEmployeeDAO.class);
            employeesDAO.updateEntity(entity);
            sqlSession.commit();
        }
    }

    @Override
    public void removeEntity(int id) {
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IEmployeeDAO employeesDAO = sqlSession.getMapper(IEmployeeDAO.class);
            employeesDAO.removeEntity(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Employee> getAllEntities() {
        List<Employee> employees;
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IEmployeeDAO employeesDAO = sqlSession.getMapper(IEmployeeDAO.class);
            employees = employeesDAO.getAllEntities();
        }
        return employees;
    }

    @Override
    public void insertEntity(Employee employee) {
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IEmployeeDAO employeesDAO = sqlSession.getMapper(IEmployeeDAO.class);
            employeesDAO.insertEntity(employee);
            sqlSession.commit();
        }
    }
}
