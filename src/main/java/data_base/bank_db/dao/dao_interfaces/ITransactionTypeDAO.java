package data_base.bank_db.dao.dao_interfaces;

import data_base.bank_db.models.TransactionType;

public interface ITransactionTypeDAO extends IBaseDAO<TransactionType>{
    double getTransactionFeeAmountById(int id);
}
