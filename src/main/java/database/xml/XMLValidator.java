package database.xml;
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

            File bankSchema = new File("src/main/resources/bank_db.xsd");
            Schema schema = factory.newSchema(bankSchema);

            Validator validator = schema.newValidator();

            File bankXml = new File("src/main/resources/bank_db.xml");

                StreamSource source = new StreamSource(bankXml);
                validator.validate(source);
                LOGGER.info(bankXml.getName() + " is valid.");

        } catch (IOException | SAXException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
