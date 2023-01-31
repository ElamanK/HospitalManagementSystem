package database.jaxb;
import database.bankdb.models.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class JAXBTest {

    private final static Logger LOGGER = LogManager.getLogger(JAXBTest.class);

    public static void main(String[] args) {

        Employee employee1 = new Employee(11, "Ann", "Vert");
        Employee employee2 = new Employee(22, "Ben", "Flip");

        Customer customer1 = new Customer(11, "Fillip", "Gal", "123 W Morse ave", "fill@example.com",
                "1231123122", "124534251");
        Customer customer2 = new Customer(22, "Fiona", "Gal", "123 W Main street", "fiona@example.com",
                "636357537", "6457547365");

        AccountType accountType1 = new AccountType(5, "debit");
        AccountType accountType2 = new AccountType(6, "credit");

        AccountStatusType accountStatusType1 = new AccountStatusType("active");
        AccountStatusType accountStatusType2 = new AccountStatusType("inactive");
        AccountStatusType accountStatusType3 = new AccountStatusType("pending");

        TransactionType transactionType1 = new TransactionType("wireless","transactions",2.99);
        TransactionType transactionType2 = new TransactionType("test","deposit",2.99);


        LocalDateTime now = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(now);
        Transaction transaction = new Transaction(1,timestamp,500.00,1200.00,1,2,2);

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
        transactionsList.add(transaction);

        List<AccountStatusType> accountStatusTypeList = new ArrayList<>();
        accountStatusTypeList.add(accountStatusType1);
        accountStatusTypeList.add(accountStatusType2);
        accountStatusTypeList.add(accountStatusType3);

        List<TransactionType> transactionTypeList = new ArrayList<>();
        transactionTypeList.add(transactionType1);
        transactionTypeList.add(transactionType2);

        Bank bank = new Bank(customerList, employeeList, transactionsList, accountTypeList,accountStatusTypeList,transactionTypeList);

        try {
            JAXBContext context = JAXBContext.newInstance(Bank.class, Customer.class, Employee.class,Transaction.class, AccountType.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(bank, new File("src/main/resources/bank_db_output.xml"));
        } catch (JAXBException e) {
            LOGGER.error(e);
        }


        Bank bankFromXml = unmarshall();
        System.out.println(bankFromXml);
    }

    public static Bank unmarshall() {
        Bank bank = new Bank();
        try {
            JAXBContext context = JAXBContext.newInstance(Bank.class, Customer.class, Employee.class, Transaction.class, AccountType.class);
            bank = (Bank) context.createUnmarshaller().unmarshal(new FileReader("src/main/resources/bank_db_output.xml"));

        } catch (JAXBException | FileNotFoundException e) {
            LOGGER.error(e);
        }
        return bank;
    }
}
