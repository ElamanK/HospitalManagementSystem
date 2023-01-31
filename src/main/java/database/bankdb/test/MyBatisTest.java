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
        CustomerService customerService = new CustomerService();
        Customer customer1 = customerService.getEntityById(1);
        Customer customer2 = customerService.getEntityById(2);
        LOGGER.info(customer1);
        LOGGER.info(customer2);

        String phoneById = customerService.getPhoneById(2);
        LOGGER.info(phoneById);
        Customer customer = new Customer(15,"XXX","YYY","123CCC","mail@mail.com","123123123","56765875346");
        LOGGER.info("Removing entity here ");
        customerService.removeEntity(9);
        LOGGER.info("List of customers "+customerService.getAllEntities());
        LOGGER.info("Updating customer");
        customerService.updateEntity(15,customer);
        LOGGER.info("Creating entity");
       // customerService.insertEntity(customer);


        EmployeeService employeeService = new EmployeeService();
        LOGGER.info("Getting employee by id");
        LOGGER.info(employeeService.getEntityById(1));
        LOGGER.info("Removing employee");
        employeeService.removeEntity(10);
        Employee employee = new Employee("aaa","bbb");
        employeeService.insertEntity(employee);
        employeeService.updateEntity(6,employee);

        TransactionTypeService transactionTypeService = new TransactionTypeService();
        TransactionType transactionTypeForUpdate = new TransactionType("test","test",0.99);
        transactionTypeService.updateEntity(8,transactionTypeForUpdate);
        LOGGER.info("Getting transaction amount by id");
        LOGGER.info(transactionTypeService.getTransactionFeeAmountById(1));


        AccountTypeService accountTypeService = new AccountTypeService();
        LOGGER.info(accountTypeService.getEntityById(1));

        TransactionService transactionService = new TransactionService();
        LOGGER.info(transactionService.getTransactionAmountById(1));
        LOGGER.info("Removing transaction entity by id");
        transactionService.removeEntity(13);

    }
}
