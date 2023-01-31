package database.bankdb.dao.mybatis;
import database.bankdb.dao.daointerfaces.ITransactionsDAO;
import database.bankdb.dao.mysql.TransactionsDAO;
import database.bankdb.models.Transaction;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class TransactionService implements ITransactionsDAO {

    private static final SqlSessionFactory SESSION_FACTORY = MyBatisDaoFactory.getSqlSessionFactory();

    @Override
    public void insertEntity(Transaction entity) {
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()){
            ITransactionsDAO transactionsDAO = new TransactionsDAO();
            transactionsDAO.insertEntity(entity);
            sqlSession.commit();
        }
    }

    @Override
    public Transaction getEntityById(int id) {
        Transaction transaction;
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()){
            ITransactionsDAO transactionsDAO = new TransactionsDAO();
            transaction = transactionsDAO.getEntityById(id);
        }
        return transaction;
    }

    @Override
    public void updateEntity(int id, Transaction entity) {
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()){
            ITransactionsDAO transactionsDAO = new TransactionsDAO();
            transactionsDAO.updateEntity(id,entity);
            sqlSession.commit();
        }
    }

    @Override
    public Transaction createEntity(Transaction entity) {
        return null;
    }

    @Override
    public void removeEntity(int id) {
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()){
            ITransactionsDAO transactionsDAO = new TransactionsDAO();
            transactionsDAO.removeEntity(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Transaction> getAllEntities() {
        List<Transaction> transactionsList;
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()){
            ITransactionsDAO transactionsDAO = new TransactionsDAO();
            transactionsList = transactionsDAO.getAllEntities();
        }
        return transactionsList;
    }

    @Override
    public double getTransactionAmountById(int id) {
        double amount;
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()){
            ITransactionsDAO transactionsDAO = new TransactionsDAO();
            amount = transactionsDAO.getTransactionAmountById(id);
        }
        return amount;
    }
}
