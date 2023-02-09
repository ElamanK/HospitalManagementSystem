package database.json;
import com.fasterxml.jackson.databind.ObjectMapper;
import database.bankdb.models.*;
import database.jaxb.Bank;
import database.patterns.builder.EmployeeBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class JsonTest {

    private final static Logger LOGGER = LogManager.getLogger(JsonTest.class);

    public static void main(String[] args) throws ParseException {

        Employee employee1 = new EmployeeBuilder().setId(11).setFirstname("Ann").setLastname("Vert").build();
        Employee employee2 = new EmployeeBuilder().setId(22).setFirstname("Ben").setLastname("Flip").build();

        Customer customer1 = new Customer(1,11, "Fillip", "Gal", "123 W Morse ave", "fill@example.com",
                "1231123122", "124534251");
        Customer customer2 = new Customer(2,22, "Fiona", "Gal", "123 W Main street", "fiona@example.com",
                "636357537", "6457547365");

        AccountType accountType1 = new AccountType(5, "debit");
        AccountType accountType2 = new AccountType(6, "credit");

        LocalDateTime now = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(now);
        Transaction transaction1 = new Transaction(1, timestamp, 500.00, 1200.00, 1, 2, 2);
        Transaction transaction2 = new Transaction(1, timestamp, 350.00, 1100.00, 2, 1, 1);

        AccountStatusType accountStatusType1 = new AccountStatusType("active");
        AccountStatusType accountStatusType2 = new AccountStatusType("inactive");
        AccountStatusType accountStatusType3 = new AccountStatusType("pending");

        TransactionType transactionType1 = new TransactionType("wireless","transactions",2.99);
        TransactionType transactionType2 = new TransactionType("test","deposit",2.99);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee1);
        employeeList.add(employee2);

        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer1);
        customerList.add(customer2);

        List<AccountType> accountTypeList = new ArrayList<>();
        accountTypeList.add(accountType1);
        accountTypeList.add(accountType2);

        List<Transaction> transactionsList = new ArrayList<>();
        transactionsList.add(transaction1);
        transactionsList.add(transaction2);

        List<AccountStatusType> accountStatusTypeList = new ArrayList<>();
        accountStatusTypeList.add(accountStatusType1);
        accountStatusTypeList.add(accountStatusType2);
        accountStatusTypeList.add(accountStatusType3);

        List<TransactionType> transactionTypeList = new ArrayList<>();
        transactionTypeList.add(transactionType1);
        transactionTypeList.add(transactionType2);

        Bank bank = new Bank(customerList, employeeList, transactionsList, accountTypeList,accountStatusTypeList,transactionTypeList);

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            objectMapper.writeValue(new File("src/main/resources/json-output.json"), bank);
        } catch (IOException e) {
            LOGGER.error(e);
        }

        Bank bankFromJson = new Bank();

        try {
            bankFromJson = objectMapper.readValue(new File("src/main/resources/json-output.json"), Bank.class);
        } catch (IOException e) {
            LOGGER.error(e);
        }

        LOGGER.info(bankFromJson);

    }
}
