package database.patterns.daofactory;

import com.hospital_management.exceptions.UnsupportedFactoryException;
import database.bankdb.dao.daointerfaces.IBaseDAO;
import database.bankdb.dao.mybatis.AccountTypeDAO;
import database.bankdb.dao.mybatis.CustomerDAO;
import database.bankdb.dao.mybatis.EmployeeDAO;
import database.bankdb.dao.mybatis.TransactionDAO;

public class MyBatisDAOFactory extends AbstractDAOFactory{
    @Override
    public IBaseDAO getDAO(String model) {
        switch (model){
            case "customer":
                return new CustomerDAO();
            case "employee":
                return new EmployeeDAO();
            case "transaction":
                return new TransactionDAO();
            case "account type":
                return new AccountTypeDAO();
            default:
                try {
                    throw new UnsupportedFactoryException("Model does not exist");
                } catch (UnsupportedFactoryException e) {
                    e.printStackTrace();
                }

        }

        return null;
 }
}