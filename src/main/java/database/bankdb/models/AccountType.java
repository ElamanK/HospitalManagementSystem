package database.bankdb.models;

public class AccountType {

    private int accountTypeId;
    private String accountTypeDescription;

    public AccountType() {};

    public AccountType(int accountTypeId,String accountTypeDescription) {
        this.accountTypeId=accountTypeId;
        this.accountTypeDescription = accountTypeDescription;
    }

    @Override
    public String toString() {
        return "account type id: " + accountTypeId
                + "\naccount type description: " + accountTypeDescription;
    }

    public int getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(int accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    public String getAccountTypeDescription() {
        return accountTypeDescription;
    }

    public void setAccountTypeDescription(String accountTypeDescription) {
        this.accountTypeDescription = accountTypeDescription;
    }
}
