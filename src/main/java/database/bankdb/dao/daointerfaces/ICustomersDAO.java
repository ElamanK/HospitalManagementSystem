package database.bankdb.dao.daointerfaces;
import database.bankdb.models.Customer;

public interface ICustomersDAO extends IBaseDAO<Customer>{
    String getPhoneById(int id);
}
