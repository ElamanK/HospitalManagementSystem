package database.bankdb.dao.mybatis;
import database.bankdb.dao.daointerfaces.ITransactionTypeDAO;
import database.bankdb.models.TransactionType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class TransactionTypeDAO implements ITransactionTypeDAO {

    private static final SqlSessionFactory SESSION_FACTORY = MyBatisDaoFactory.getSqlSessionFactory();


    @Override
    public void insertEntity(TransactionType entity) {
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()){
            ITransactionTypeDAO transactionsDAO = new database.bankdb.dao.jdbc.TransactionTypeDAO();
            transactionsDAO.insertEntity(entity);
            sqlSession.commit();
        }
    }

    @Override
    public TransactionType getEntityById(int id) {
        TransactionType transactionType;
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()){
            ITransactionTypeDAO transactionsDAO = new database.bankdb.dao.jdbc.TransactionTypeDAO();
            transactionType = transactionsDAO.getEntityById(id);
        }
        return transactionType;
    }

    @Override
    public void updateEntity(TransactionType entity) {
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()){
            ITransactionTypeDAO transactionsDAO = new database.bankdb.dao.jdbc.TransactionTypeDAO();
            transactionsDAO.updateEntity(entity);
            sqlSession.commit();
        }
    }

    @Override
    public void removeEntity(int id) {
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()){
            ITransactionTypeDAO transactionsDAO = new database.bankdb.dao.jdbc.TransactionTypeDAO();
            transactionsDAO.removeEntity(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<TransactionType> getAllEntities() {
        List<TransactionType> transactionTypeList;
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            ITransactionTypeDAO transactionTypeDAO = sqlSession.getMapper(ITransactionTypeDAO.class);
            transactionTypeList = transactionTypeDAO.getAllEntities();
        }
        return transactionTypeList;
    }

    @Override
    public double getTransactionFeeAmountById(int id) {
        TransactionType transactionType;
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()){
            ITransactionTypeDAO transactionTypeDAO = sqlSession.getMapper(ITransactionTypeDAO.class);
            transactionType = transactionTypeDAO.getEntityById(id);
        }
        return transactionType.getFee();
    }
}
