package database.bankdb.dao.mybatis;
import database.bankdb.dao.daointerfaces.ICustomersDAO;
import database.bankdb.models.Customer;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import java.util.List;

public class CustomerService implements ICustomersDAO {

    private static final SqlSessionFactory SESSION_FACTORY = MyBatisDaoFactory.getSqlSessionFactory();


    @Override
    public void insertEntity(Customer entity) {
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            ICustomersDAO customersDAO = sqlSession.getMapper(ICustomersDAO.class);
             customersDAO.insertEntity(entity);
            sqlSession.commit();
        }
    }

    @Override
    public Customer getEntityById(int id) {
        Customer customer;
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            ICustomersDAO customersDAO = sqlSession.getMapper(ICustomersDAO.class);
            customer = customersDAO.getEntityById(id);
        }
        return customer;
    }

    @Override
    public void updateEntity(int id, Customer entity) {
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            ICustomersDAO customersDAO = sqlSession.getMapper(ICustomersDAO.class);
            customersDAO.updateEntity(id,entity);
            sqlSession.commit();
        }
    }

    @Override
    public Customer createEntity(Customer entity) {
        return null;
    }

    @Override
    public void removeEntity(int id) {
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            ICustomersDAO customersDAO = sqlSession.getMapper(ICustomersDAO.class);
            customersDAO.removeEntity(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Customer> getAllEntities() {
        List<Customer> customers;
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            ICustomersDAO customersDAO = sqlSession.getMapper(ICustomersDAO.class);
            customers = customersDAO.getAllEntities();
        }
        return customers;
    }

    @Override
    public String getPhoneById(int id) {
        Customer customer;
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            ICustomersDAO customersDAO = sqlSession.getMapper(ICustomersDAO.class);
            customer = customersDAO.getEntityById(id);
        }
        return customer.getPhone();
    }
}
