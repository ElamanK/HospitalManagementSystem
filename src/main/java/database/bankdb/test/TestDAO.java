package database.bankdb.test;
import database.bankdb.dao.mysql.*;
import database.bankdb.models.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;


public class TestDAO {

    private static final Logger LOGGER = LogManager.getLogger(TestDAO.class);

    public static void main(String[] args) {

        AccountsDAO accountsDAO = new AccountsDAO();
        LOGGER.info("Getting account by id");
        LOGGER.info(accountsDAO.getEntityById(1));

        LOGGER.info("Getting account current balance by id");
        LOGGER.info(accountsDAO.getCurrentBalanceById(1));

        LOGGER.info("Getting all accounts as list");
        LOGGER.info(accountsDAO.getAllEntities());

        Account accountToUpdate = new Account(3, 800, 2, 1);
        Account accountToCreate = new Account(4, 1500, 1, 2);

        LOGGER.info("UPDATING account");
        accountsDAO.updateEntity(1, accountToUpdate);

        LOGGER.info("INSERTING account");
        accountsDAO.createEntity(accountToCreate);

        LOGGER.info("DELETING account");
        accountsDAO.removeEntity(5);

        AccountTypeDAO accountTypeDAO = new AccountTypeDAO();
        AccountType accountTypeToCreate = new AccountType(1,"NEW Checking account");
        AccountType accountTypeToUpdate = new AccountType(2,"Updated savings account");

        LOGGER.info("Getting entity by id");
        LOGGER.info(accountTypeDAO.getEntityById(1));

        LOGGER.info("Creating account type entity");
        accountTypeDAO.createEntity(accountTypeToCreate);

        LOGGER.info("Updating account type entity");
        accountTypeDAO.updateEntity(1, accountTypeToUpdate);

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
        accountStatusTypeDAO.createEntity(accountStatusTypeToCreate);

        LOGGER.info("Removing entity by id");
        accountStatusTypeDAO.removeEntity(4);

        LOGGER.info("Getting all account status types");
        LOGGER.info(accountStatusTypeDAO.getAllEntities());

        CustomersDAO customersDAO = new CustomersDAO();

        LOGGER.info("Getting entity by id");
        LOGGER.info(customersDAO.getEntityById(2));

        LOGGER.info("Getting all customers information");
        LOGGER.info(customersDAO.getAllEntities());

        LOGGER.info("Getting customer phone by customer id");
        LOGGER.info(customersDAO.getPhoneById(3));

        LOGGER.info("Removing entity by id");
        customersDAO.removeEntity(4);

        LOGGER.info("Creating customer entity");
        Customer customerToCreate = new Customer(5,"Kevin","Chen","123 W Fargo ave",
                "kev12@gmail.com","123123123","2342789");
        customersDAO.createEntity(customerToCreate);

        LOGGER.info("Updating customer entity by id");
        Customer customerToUpdate = new Customer(2,"Sony","San","223 W Summerdale ave",
                "san12@gmail.com","123123123","2346789");
        customersDAO.updateEntity(1,customerToUpdate);

        EmployeeDAO employeeDAO = new EmployeeDAO();
        Employee empToCreate = new Employee("Merry","J");
        Employee empToUpdate = new Employee("Kelly","M");

        LOGGER.info("Creating employee");
        employeeDAO.createEntity(empToCreate);

        LOGGER.info("Getting entity by id");
        LOGGER.info(employeeDAO.getEntityById(5));

        LOGGER.info("Updating entity by id");
        employeeDAO.updateEntity(3,empToUpdate);

        LOGGER.info("Removing entity by id");
        employeeDAO.removeEntity(5);

        LOGGER.info("Getting all employees");
        LOGGER.info(employeeDAO.getAllEntities());

        TransactionsDAO transactionsDAO = new TransactionsDAO();

        LOGGER.info("Getting transaction amount by id");
        LOGGER.info(transactionsDAO.getTransactionAmountById(3));

        LOGGER.info("Creating transaction entity");
//        LocalDate localDate = LocalDate.now();
//        Date date = Date.valueOf(localDate);
        LocalDateTime now = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(now);

        Transaction transactionToCreate = new Transaction(timestamp, 666, 1266, 1, 2, 2);
        transactionsDAO.createEntity(transactionToCreate);

        LOGGER.info("Removing entity by id");
        transactionsDAO.removeEntity(3);

        LOGGER.info("Removing entity by id");
        Transaction transactionToUpdate = new Transaction(timestamp, 123, 567, 1, 2, 2);
        transactionsDAO.updateEntity(1, transactionToUpdate);

        LOGGER.info("Getting all transactions");
        LOGGER.info(transactionsDAO.getAllEntities());

        TransactionTypeDAO transactionTypeDAO = new TransactionTypeDAO();

        LOGGER.info("Getting entity");
        LOGGER.info(transactionTypeDAO.getEntityById(1));

        LOGGER.info("Getting transaction fee amount by id");
        LOGGER.info(transactionTypeDAO.getTransactionFeeAmountById(1));

        LOGGER.info("Creating entity");
        TransactionType transactionTypeToCreate = new TransactionType("wired transaction","slow transaction",00.50);
        transactionTypeDAO.createEntity(transactionTypeToCreate);
 }
}
