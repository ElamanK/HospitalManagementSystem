package database.bankdb.models;

public class AccountStatusType {

    private int accountStatusTypeId;
    private String accountStatusTypeDescription;

    public AccountStatusType() {};

    public AccountStatusType(String accountStatusTypeDescription) {
        this.accountStatusTypeDescription = accountStatusTypeDescription;
    }

    public int getAccountStatusTypeId() {
        return accountStatusTypeId;
    }

    public void setAccountStatusTypeId(int accountStatusTypeId) {
        this.accountStatusTypeId = accountStatusTypeId;
    }

    public String getAccountStatusTypeDescription() {
        return accountStatusTypeDescription;
    }

    public void setAccountStatusTypeDescription(String accountStatusTypeDescription) {
        this.accountStatusTypeDescription = accountStatusTypeDescription;
    }

    @Override
    public String toString() {
        return "account status type id: " + accountStatusTypeId
                + "\naccount status description: " + accountStatusTypeDescription;
    }
}
