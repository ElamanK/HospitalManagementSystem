package database.bankdb.dao.mybatis;
import database.bankdb.dao.daointerfaces.ICustomerDAO;
import database.bankdb.models.Customer;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import java.util.List;

public class CustomerDAO implements ICustomerDAO {

    private static final SqlSessionFactory SESSION_FACTORY = MyBatisDaoFactory.getSqlSessionFactory();


    @Override
    public void insertEntity(Customer entity) {
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            ICustomerDAO customersDAO = sqlSession.getMapper(ICustomerDAO.class);
             customersDAO.insertEntity(entity);
            sqlSession.commit();
        }
    }

    @Override
    public Customer getEntityById(int id) {
        Customer customer;
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            ICustomerDAO customersDAO = sqlSession.getMapper(ICustomerDAO.class);
            customer = customersDAO.getEntityById(id);
        }
        return customer;
    }

    @Override
    public void updateEntity(Customer entity) {
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            ICustomerDAO customersDAO = sqlSession.getMapper(ICustomerDAO.class);
            customersDAO.updateEntity(entity);
            sqlSession.commit();
        }
    }


    @Override
    public void removeEntity(int id) {
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            ICustomerDAO customersDAO = sqlSession.getMapper(ICustomerDAO.class);
            customersDAO.removeEntity(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Customer> getAllEntities() {
        List<Customer> customers;
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            ICustomerDAO customersDAO = sqlSession.getMapper(ICustomerDAO.class);
            customers = customersDAO.getAllEntities();
        }
        return customers;
    }

    @Override
    public String getPhoneById(int id) {
        Customer customer;
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            ICustomerDAO customersDAO = sqlSession.getMapper(ICustomerDAO.class);
            customer = customersDAO.getEntityById(id);
        }
        return customer.getPhone();
    }
}
