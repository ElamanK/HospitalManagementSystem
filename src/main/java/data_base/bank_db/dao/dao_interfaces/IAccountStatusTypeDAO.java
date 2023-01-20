package data_base.bank_db.dao.dao_interfaces;
import data_base.bank_db.models.AccountStatusType;
import java.util.List;

public interface IAccountStatusTypeDAO extends IBaseDAO<AccountStatusType>{
    String getAccountStatusById(int id);
}
