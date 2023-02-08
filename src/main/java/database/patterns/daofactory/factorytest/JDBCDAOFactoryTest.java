package database.patterns.daofactory.factorytest;

import database.bankdb.dao.daointerfaces.IBaseDAO;
import database.bankdb.models.AccountType;
import database.bankdb.models.Customer;
import database.bankdb.models.Employee;
import database.bankdb.models.Transaction;
import database.patterns.builder.EmployeeBuilder;
import database.patterns.daofactory.DBConnectionType;
import database.patterns.daofactory.DBFactoryGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class JDBCDAOFactoryTest {

    private static final Logger LOGGER = LogManager.getLogger(JDBCDAOFactoryTest.class);

    public static void main(String[] args) {

        IBaseDAO<Customer> customer = DBFactoryGenerator.getFactory(DBConnectionType.JDBC).getDAO("customer");
        LOGGER.info("Getting customer");
        LOGGER.info(customer.getEntityById(1));
        LOGGER.info("Getting all customer entities");
        customer.getAllEntities().forEach(LOGGER::info);

        IBaseDAO<Employee> employee = DBFactoryGenerator.getFactory(DBConnectionType.JDBC).getDAO("employee");
        List<Employee> listOfEmployees = employee.getAllEntities();
        listOfEmployees.forEach(e -> LOGGER.info(e));
        Employee emp = new EmployeeBuilder().setId(22).setFirstname("Employee").setLastname("Employee").build();
        LOGGER.info("Creating employee");
        employee.insertEntity(emp);
        LOGGER.info("Getting employee");
        LOGGER.info(employee.getEntityById(111));
        LOGGER.info("Removing employee");
        employee.removeEntity(111);

        IBaseDAO<Transaction> transaction = DBFactoryGenerator.getFactory(DBConnectionType.JDBC).getDAO("transaction");
        LOGGER.info("Getting all transaction entities");
        List<Transaction> transactionList = transaction.getAllEntities();
        transactionList.stream().forEach(t -> LOGGER.info(t));
        LOGGER.info("Getting transaction by id");
        Transaction transaction1 = transaction.getEntityById(1);
        LOGGER.info(transaction1);

        IBaseDAO<AccountType> accountType = DBFactoryGenerator.getFactory(DBConnectionType.JDBC).getDAO("account type");
        LOGGER.info("Getting all account type entities");
        List<AccountType> accountTypeList = accountType.getAllEntities();
        accountTypeList.stream().forEach(a -> LOGGER.info(a));

        LOGGER.info(accountType.getEntityById(1));


    }
}
