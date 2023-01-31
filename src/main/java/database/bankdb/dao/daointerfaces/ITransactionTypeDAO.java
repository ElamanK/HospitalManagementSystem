package database.bankdb.dao.daointerfaces;

import database.bankdb.models.TransactionType;

public interface ITransactionTypeDAO extends IBaseDAO<TransactionType>{
    double getTransactionFeeAmountById(int id);
}
