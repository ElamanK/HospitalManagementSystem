package data_base.xml_files;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XMLValidator {

    private static final Logger LOGGER = LogManager.getLogger(XMLValidator.class);

    public static void main(String[] args) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

            File usersSchema = new File("src/main/java/data_base/xsd_files/users.xsd");
            Schema schema = factory.newSchema(usersSchema);

            Validator validator = schema.newValidator();

            File employeeXML = new File("src/main/java/data_base/xml_files/employee.xml");
            File customerXML = new File("src/main/java/data_base/xml_files/customer.xml");

            File [] userXMLs  = new File[2];
            userXMLs[0]=employeeXML;
            userXMLs[1]=customerXML;

            for(File xml:userXMLs){
                StreamSource source = new StreamSource(xml);
                validator.validate(source);
                LOGGER.info(xml.getName() + " is valid.");
            }
        } catch (IOException | SAXException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
