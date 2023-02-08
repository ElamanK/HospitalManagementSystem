package database.patterns.builder;

import database.bankdb.models.Customer;
import database.bankdb.models.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BuilderTest {

    private static final Logger LOGGER = LogManager.getLogger(BuilderTest.class);

    public static void main(String[] args) {

        Employee employee = new EmployeeBuilder().setId(1).setFirstname("test").setLastname("Test").build();
        LOGGER.info(employee);

        Customer customer = new CustomerBuilder(111,2,"Test","test",
                "123 W Test ave","test@gmail.com","12341234","89078697").build();
        LOGGER.info(customer);

    }
}
