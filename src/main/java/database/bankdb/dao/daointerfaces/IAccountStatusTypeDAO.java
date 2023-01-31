package database.bankdb.dao.daointerfaces;
import database.bankdb.models.AccountStatusType;

public interface IAccountStatusTypeDAO extends IBaseDAO<AccountStatusType>{
    String getAccountStatusById(int id);
}
