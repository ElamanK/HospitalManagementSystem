package data_base.bank_db.dao.dao_interfaces;
import data_base.bank_db.models.Accounts;
import java.util.List;

public interface IAccountsDAO extends IBaseDAO<Accounts> {
    double getCurrentBalanceById(int id);

}
