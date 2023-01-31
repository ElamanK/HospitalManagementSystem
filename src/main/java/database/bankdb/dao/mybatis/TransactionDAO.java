package database.bankdb.dao.mybatis;
import database.bankdb.dao.daointerfaces.ITransactionDAO;
import database.bankdb.models.Transaction;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class TransactionDAO implements ITransactionDAO {

    private static final SqlSessionFactory SESSION_FACTORY = MyBatisDaoFactory.getSqlSessionFactory();

    @Override
    public void insertEntity(Transaction entity) {
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()){
            ITransactionDAO transactionsDAO = new database.bankdb.dao.jdbc.TransactionDAO();
            transactionsDAO.insertEntity(entity);
            sqlSession.commit();
        }
    }

    @Override
    public Transaction getEntityById(int id) {
        Transaction transaction;
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()){
            ITransactionDAO transactionsDAO = new database.bankdb.dao.jdbc.TransactionDAO();
            transaction = transactionsDAO.getEntityById(id);
        }
        return transaction;
    }

    @Override
    public void updateEntity(int id, Transaction entity) {
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()){
            ITransactionDAO transactionsDAO = new database.bankdb.dao.jdbc.TransactionDAO();
            transactionsDAO.updateEntity(id,entity);
            sqlSession.commit();
        }
    }


    @Override
    public void removeEntity(int id) {
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()){
            ITransactionDAO transactionsDAO = new database.bankdb.dao.jdbc.TransactionDAO();
            transactionsDAO.removeEntity(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Transaction> getAllEntities() {
        List<Transaction> transactionsList;
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()){
            ITransactionDAO transactionsDAO = new database.bankdb.dao.jdbc.TransactionDAO();
            transactionsList = transactionsDAO.getAllEntities();
        }
        return transactionsList;
    }

    @Override
    public double getTransactionAmountById(int id) {
        double amount;
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()){
            ITransactionDAO transactionsDAO = new database.bankdb.dao.jdbc.TransactionDAO();
            amount = transactionsDAO.getTransactionAmountById(id);
        }
        return amount;
    }
}
