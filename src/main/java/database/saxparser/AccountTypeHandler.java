package database.saxparser;

import database.bankdb.models.AccountType;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class AccountTypeHandler extends DefaultHandler {

    private StringBuilder data;
    private String currentElement;
    private AccountType accountType = new AccountType();
    private List<AccountType> accountTypeList = new ArrayList<>();


    public List<AccountType> getAccountTypeList() {
        return accountTypeList;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        currentElement = qName;
        if (qName.equalsIgnoreCase("account-type")) {
            String id = attributes.getValue("id");
            accountType.setAccountTypeId(Integer.parseInt(id));
        }
        data = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (currentElement.equals("account-type-description")) {
            accountType.setAccountTypeDescription(data.toString());
        } else if (qName.equalsIgnoreCase("account-type")) {
            accountTypeList.add(accountType);
            accountType = new AccountType();
        }
        currentElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        data.append(new String(ch, start, length));
    }
}
