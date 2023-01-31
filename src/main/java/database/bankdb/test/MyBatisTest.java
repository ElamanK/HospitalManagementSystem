package database.bankdb.test;
import database.bankdb.dao.mybatis.*;
import database.bankdb.models.Customer;
import database.bankdb.models.Employee;
import database.bankdb.models.TransactionType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyBatisTest {

    private static final Logger LOGGER = LogManager.getLogger(MyBatisTest.class);

    public static void main(String[] args) {

        LOGGER.info("Getting customer entity by id");
        CustomerDAO customerDAO = new CustomerDAO();
        Customer customer1 = customerDAO.getEntityById(1);
        Customer customer2 = customerDAO.getEntityById(2);
        LOGGER.info(customer1);
        LOGGER.info(customer2);

        String phoneById = customerDAO.getPhoneById(2);
        LOGGER.info(phoneById);
        Customer customer = new Customer(15,"XXX","YYY","123CCC","mail@mail.com","123123123","56765875346");
        LOGGER.info("Removing entity here ");
        customerDAO.removeEntity(9);
        LOGGER.info("List of customers "+ customerDAO.getAllEntities());
        LOGGER.info("Updating customer");
       // customerDAO.updateEntity(15,customer);
        LOGGER.info("Creating entity");
       // customerDAO.insertEntity(customer);


        EmployeeDAO employeeDAO = new EmployeeDAO();
        LOGGER.info("Getting employee by id");
        LOGGER.info(employeeDAO.getEntityById(1));
        LOGGER.info("Removing employee");
        employeeDAO.removeEntity(10);
        Employee employee = new Employee("aaa","bbb");
       // employeeDAO.insertEntity(employee);
       // employeeDAO.updateEntity(6,employee);

        TransactionTypeDAO transactionTypeDAO = new TransactionTypeDAO();
        TransactionType transactionTypeForUpdate = new TransactionType("test","test",0.99);
        transactionTypeDAO.updateEntity(8,transactionTypeForUpdate);
        LOGGER.info("Getting transaction amount by id");
        LOGGER.info(transactionTypeDAO.getTransactionFeeAmountById(1));


        AccountTypeDAO accountTypeDAO = new AccountTypeDAO();
        LOGGER.info(accountTypeDAO.getEntityById(1));

        TransactionDAO transactionDAO = new TransactionDAO();
        LOGGER.info(transactionDAO.getTransactionAmountById(1));
        LOGGER.info("Removing transaction entity by id");
        transactionDAO.removeEntity(13);

    }
}
