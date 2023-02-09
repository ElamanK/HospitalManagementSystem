package database.saxparser;
import database.bankdb.models.Transaction;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class TransactionHandler extends DefaultHandler {

    private StringBuilder data;
    private String currentElement;
    private Transaction transaction = new Transaction();
    private List<Transaction> transactionList = new ArrayList<>();

    public List<Transaction> getTransactionsList() {
        return transactionList;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        currentElement = qName;
        if (qName.equalsIgnoreCase("transaction")) {
            String id = attributes.getValue("id");
            transaction.setTransactionId(Integer.parseInt(id));
        }
        data = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (currentElement.equals("date")) {
            transaction.setTransactionDate(Timestamp.valueOf(data.toString()));
        } else if (currentElement.equals("transaction-amount")) {
            transaction.setTransactionAmount(Double.parseDouble(data.toString()));
        } else if (currentElement.equals("new-balance")) {
            transaction.setNewBalance(Double.parseDouble(data.toString()));
        } else if (currentElement.equals("account-id")) {
            transaction.setAccountId(Integer.parseInt(data.toString()));
        } else if (currentElement.equals("employee-id")) {
            transaction.setEmployeeId(Integer.parseInt(data.toString()));
        } else if (currentElement.equals("transaction-type-id")) {
            transaction.setTransactionTypeId(Integer.parseInt(data.toString()));
        } else if (qName.equalsIgnoreCase("transaction")) {
            transactionList.add(transaction);
            transaction = new Transaction();
        }
        currentElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        data.append(new String(ch, start, length));
    }
}
