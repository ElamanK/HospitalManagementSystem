package database.bankdb.models;

public class Overdraft {

    private int accountId;
    private String overdraftDate;
    private String overdraftAmount;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getOverdraftDate() {
        return overdraftDate;
    }

    public void setOverdraftDate(String overdraftDate) {
        this.overdraftDate = overdraftDate;
    }

    public String getOverdraftAmount() {
        return overdraftAmount;
    }

    public void setOverdraftAmount(String overdraftAmount) {
        this.overdraftAmount = overdraftAmount;
    }
}
