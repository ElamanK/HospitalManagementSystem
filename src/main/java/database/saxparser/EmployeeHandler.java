package database.saxparser;
import database.bankdb.models.Employee;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class EmployeeHandler extends DefaultHandler {

    StringBuilder data;
    String currentElement;
    private Employee employee = new Employee();
    private List<Employee> employeeList = new ArrayList<>();

    public List<Employee> getEmployeesList() {
        return employeeList;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        currentElement = qName;
        data = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (currentElement.equals("id")) {
            employee.setId(Integer.parseInt(data.toString()));
        } else if (currentElement.equals("firstname")) {
            employee.setFirstname(data.toString());
        } else if (currentElement.equals("lastname")) {
            employee.setLastname(data.toString());
        } else if (qName.equalsIgnoreCase("employee")) {
            employeeList.add(employee);
            employee = new Employee();
        }
        currentElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        data.append(new String(ch, start, length));
    }
}
