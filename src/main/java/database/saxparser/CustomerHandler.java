package database.saxparser;
import database.bankdb.models.Customer;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;


public class CustomerHandler extends DefaultHandler {

    private StringBuilder data;
    private String currentElement;
    private Customer customer = new Customer();
    private List<Customer> customerList = new ArrayList<>();


    public List<Customer> getCustomersList() {
        return customerList;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        currentElement = qName;
        if (qName.equalsIgnoreCase("customer")) {
            String id = attributes.getValue("id");
            customer.setCustomer_id(Integer.parseInt(id));
        }
        data = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (currentElement.equals("accountId")) {
            customer.setAccountId(Integer.parseInt(data.toString()));
        } else if (currentElement.equals("firstname")) {
            customer.setFirstname(data.toString());
        } else if (currentElement.equals("lastname")) {
            customer.setLastname(data.toString());
        } else if (currentElement.equals("address")) {
            customer.setAddress(data.toString());
        } else if (currentElement.equals("emailAddress")) {
            customer.setEmailAddress(data.toString());
        } else if (currentElement.equals("phone")) {
            customer.setPhone(data.toString());
        } else if (currentElement.equals("ssn")) {
            customer.setSsn(data.toString());
        } else if (qName.equalsIgnoreCase("customer")) {
            customerList.add(customer);
            customer = new Customer();
        }
        currentElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        data.append(new String(ch, start, length));
    }
}


