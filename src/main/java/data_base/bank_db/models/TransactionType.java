package data_base.bank_db.models;

public class TransactionType {

    private int transactionTypeId;
    private String transactionTypeName;
    private String transactionTypeDescription;
    private double fee;

    public TransactionType(){};

    public TransactionType( String transactionTypeName, String transactionTypeDescription, double fee) {
        this.transactionTypeName = transactionTypeName;
        this.transactionTypeDescription = transactionTypeDescription;
        this.fee = fee;
    }

    public int getTransactionTypeId() {
        return transactionTypeId;
    }

    public void setTransactionTypeId(int transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }

    public String getTransactionTypeName() {
        return transactionTypeName;
    }

    public void setTransactionTypeName(String transactionTypeName) {
        this.transactionTypeName = transactionTypeName;
    }

    public String getTransactionTypeDescription() {
        return transactionTypeDescription;
    }

    public void setTransactionTypeDescription(String transactionTypeDescription) {
        this.transactionTypeDescription = transactionTypeDescription;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "transaction type id: "+transactionTypeId
                +"\ntransaction type name: "+transactionTypeName
                +"\ntransaction type description: "+transactionTypeDescription
                +"\ntransaction fee: "+fee;
    }
}
