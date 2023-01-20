package data_base.bank_db.dao.dao_interfaces;
import data_base.bank_db.models.Customers;
import java.util.List;

public interface ICustomersDAO extends IBaseDAO<Customers>{
    String getPhoneById(int id);
}
