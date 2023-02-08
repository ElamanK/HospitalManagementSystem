package database.bankdb.test;
import database.bankdb.dao.jdbc.*;
import database.bankdb.models.*;
import database.patterns.builder.EmployeeBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Timestamp;
import java.time.LocalDateTime;


public class JDBCTest {

    private static final Logger LOGGER = LogManager.getLogger(JDBCTest.class);

    public static void main(String[] args) {

        AccountDAO accountDAO = new AccountDAO();
        LOGGER.info("Getting account by id");
        LOGGER.info(accountDAO.getEntityById(1));

        LOGGER.info("Getting account current balance by id");
        LOGGER.info(accountDAO.getCurrentBalanceById(1));

        LOGGER.info("Getting all accounts as list");
        LOGGER.info(accountDAO.getAllEntities());

        Account accountToUpdate = new Account(3, 800, 2, 1);
        Account accountToCreate = new Account(4, 1500, 1, 2);

        LOGGER.info("UPDATING account");
        accountDAO.updateEntity(accountToUpdate);

        LOGGER.info("INSERTING account");
        accountDAO.insertEntity(accountToCreate);

        LOGGER.info("DELETING account");
        accountDAO.removeEntity(5);

        AccountTypeDAO accountTypeDAO = new AccountTypeDAO();
        AccountType accountTypeToCreate = new AccountType(1,"NEW Checking account");
        AccountType accountTypeToUpdate = new AccountType(2,"Updated savings account");

        LOGGER.info("Getting entity by id");
        LOGGER.info(accountTypeDAO.getEntityById(1));

        LOGGER.info("Creating account type entity");
        accountTypeDAO.insertEntity(accountTypeToCreate);

        LOGGER.info("Updating account type entity");
        accountTypeDAO.updateEntity(accountTypeToUpdate);

        LOGGER.info("Getting all account types");
        LOGGER.info(accountTypeDAO.getAllEntities());

        LOGGER.info("Removing entity by id");
        accountTypeDAO.removeEntity(1);

        AccountStatusTypeDAO accountStatusTypeDAO = new AccountStatusTypeDAO();

        LOGGER.info("Getting account status by id");
        LOGGER.info(accountStatusTypeDAO.getAccountStatusById(1));

        LOGGER.info("Getting entity by id");
        LOGGER.info(accountStatusTypeDAO.getEntityById(2));

        LOGGER.info("Creating entity");
        AccountStatusType accountStatusTypeToCreate = new AccountStatusType("Pending");
        accountStatusTypeDAO.insertEntity(accountStatusTypeToCreate);

        LOGGER.info("Removing entity by id");
        accountStatusTypeDAO.removeEntity(4);

        LOGGER.info("Getting all account status types");
        LOGGER.info(accountStatusTypeDAO.getAllEntities());

        CustomerDAO customerDAO = new CustomerDAO();

        LOGGER.info("Getting entity by id");
        LOGGER.info(customerDAO.getEntityById(2));

        LOGGER.info("Getting all customers information");
        LOGGER.info(customerDAO.getAllEntities());

        LOGGER.info("Getting customer phone by customer id");
        LOGGER.info(customerDAO.getPhoneById(3));

        LOGGER.info("Removing entity by id");
        customerDAO.removeEntity(4);

        LOGGER.info("Creating customer entity");
        Customer customerToCreate = new Customer(5,"Kevin","Chen","123 W Fargo ave",
                "kev12@gmail.com","123123123","2342789");
        customerDAO.insertEntity(customerToCreate);

        LOGGER.info("Updating customer entity by id");
        Customer customerToUpdate = new Customer(1,2,"Sony","San","223 W Summerdale ave",
                "san12@gmail.com","123123123","2346789");
        customerDAO.updateEntity(customerToUpdate);

        EmployeeDAO employeeDAO = new EmployeeDAO();
        Employee empToCreate = new EmployeeBuilder().setFirstname("NEW").setLastname("Test").build();
        Employee empToUpdate = new EmployeeBuilder().setId(1).setFirstname("test").setLastname("Test").build();

        LOGGER.info("Creating employee");
        employeeDAO.insertEntity(empToCreate);

        LOGGER.info("Getting entity by id");
        LOGGER.info(employeeDAO.getEntityById(5));

        LOGGER.info("Updating entity by id");
        employeeDAO.updateEntity(empToUpdate);

        LOGGER.info("Removing entity by id");
        employeeDAO.removeEntity(5);

        LOGGER.info("Getting all employees");
        LOGGER.info(employeeDAO.getAllEntities());

        TransactionDAO transactionsDAO = new TransactionDAO();

        LOGGER.info("Getting transaction amount by id");
        LOGGER.info(transactionsDAO.getTransactionAmountById(3));

        LOGGER.info("Creating transaction entity");
        LocalDateTime now = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(now);

        Transaction transactionToCreate = new Transaction(timestamp, 666, 1266, 1, 2, 2);
        transactionsDAO.insertEntity(transactionToCreate);

        LOGGER.info("Removing entity by id");
        transactionsDAO.removeEntity(3);

        LOGGER.info("Removing entity by id");
        Transaction transactionToUpdate = new Transaction(1,timestamp, 123, 567, 1, 2, 2);
        transactionsDAO.updateEntity(transactionToUpdate);

        LOGGER.info("Getting all transactions");
        LOGGER.info(transactionsDAO.getAllEntities());

        TransactionTypeDAO transactionTypeDAO = new TransactionTypeDAO();

        LOGGER.info("Getting entity");
        LOGGER.info(transactionTypeDAO.getEntityById(1));

        LOGGER.info("Getting transaction fee amount by id");
        LOGGER.info(transactionTypeDAO.getTransactionFeeAmountById(1));

        LOGGER.info("Creating entity");
        TransactionType transactionTypeToCreate = new TransactionType("test transaction","slow transaction",00.50);
        transactionTypeDAO.insertEntity(transactionTypeToCreate);
 }
}
