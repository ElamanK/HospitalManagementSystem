package data_base.bank_db.dao.dao_interfaces;
import data_base.bank_db.models.Transactions;
import java.util.List;

public interface ITransactionsDAO extends IBaseDAO<Transactions>{
    double getTransactionAmountById(int id);
}
