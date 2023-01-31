package database.bankdb.dao.daointerfaces;
import database.bankdb.models.Customer;

public interface ICustomerDAO extends IBaseDAO<Customer>{
    String getPhoneById(int id);
}
