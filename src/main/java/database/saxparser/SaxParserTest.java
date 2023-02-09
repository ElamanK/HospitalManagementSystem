package database.saxparser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SaxParserTest {

    private static final Logger LOGGER = LogManager.getLogger(SaxParserTest.class);

    public static void main(String[] args) {

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();

            CustomerHandler customerHandler = new CustomerHandler();
            EmployeeHandler employeeHandler = new EmployeeHandler();
            TransactionHandler transactionHandler = new TransactionHandler();
            AccountTypeHandler accountTypeHandler = new AccountTypeHandler();

            List<DefaultHandler> handlerList = new ArrayList<>();
            handlerList.add(customerHandler);
            handlerList.add(employeeHandler);
            handlerList.add(transactionHandler);
            handlerList.add(accountTypeHandler);

            for (DefaultHandler h : handlerList) {
                saxParser.parse(new File("src/main/resources/bank_db.xml"), h);
            }
            customerHandler.getCustomersList().forEach(LOGGER::info);
            employeeHandler.getEmployeesList().forEach(LOGGER::info);
            transactionHandler.getTransactionsList().forEach(LOGGER::info);
            accountTypeHandler.getAccountTypeList().forEach(LOGGER::info);
        } catch (ParserConfigurationException | IOException | org.xml.sax.SAXException e) {
            LOGGER.error(e);
        }
    }
}
