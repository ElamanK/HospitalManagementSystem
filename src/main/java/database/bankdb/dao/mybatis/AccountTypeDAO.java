package database.bankdb.dao.mybatis;
import database.bankdb.dao.daointerfaces.IAccountTypeDAO;
import database.bankdb.models.AccountType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import java.util.List;

public class AccountTypeDAO implements IAccountTypeDAO {

    private static final SqlSessionFactory SESSION_FACTORY = MyBatisDaoFactory.getSqlSessionFactory();

    @Override
    public void insertEntity(AccountType entity) {
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IAccountTypeDAO accountTypeDAO = sqlSession.getMapper(IAccountTypeDAO.class);
            accountTypeDAO.insertEntity(entity);
            sqlSession.commit();
        }
    }

    @Override
    public AccountType getEntityById(int id) {
        AccountType accountType;
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()){
            IAccountTypeDAO accountTypeDAO = sqlSession.getMapper(IAccountTypeDAO.class);
            accountType = accountTypeDAO.getEntityById(id);
        }
        return accountType;
    }

    @Override
    public void updateEntity(AccountType entity) {
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()){
            IAccountTypeDAO accountTypeDAO = new database.bankdb.dao.jdbc.AccountTypeDAO();
            accountTypeDAO.updateEntity(entity);
            sqlSession.commit();
        }

    }


    @Override
    public void removeEntity(int id) {
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IAccountTypeDAO accountTypeDAO = sqlSession.getMapper(IAccountTypeDAO.class);
            accountTypeDAO.removeEntity(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<AccountType> getAllEntities() {
        List<AccountType> accountTypeList;
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IAccountTypeDAO accountTypeDAO = sqlSession.getMapper(IAccountTypeDAO.class);
            accountTypeList = accountTypeDAO.getAllEntities();
        }
        return accountTypeList;
    }
}
