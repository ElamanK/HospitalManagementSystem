package database.bankdb.dao.daointerfaces;
import database.bankdb.models.Account;

public interface IAccountsDAO extends IBaseDAO<Account> {
    double getCurrentBalanceById(int id);

}
