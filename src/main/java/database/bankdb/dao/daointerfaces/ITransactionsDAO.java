package database.bankdb.dao.daointerfaces;
import database.bankdb.models.Transaction;

public interface ITransactionsDAO extends IBaseDAO<Transaction>{
    double getTransactionAmountById(int id);
}
