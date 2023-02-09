package database.bankdb.dao.daointerfaces;
import database.bankdb.models.Account;

public interface IAccountDAO extends IBaseDAO<Account> {
    double getCurrentBalanceById(int id);

}
