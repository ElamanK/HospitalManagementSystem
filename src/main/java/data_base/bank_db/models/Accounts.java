package data_base.bank_db.models;

public class Accounts {

    private int accountId;
    private double currentBalance;
    private int accountTypeId;
    private int accountStatusTypeId;

    public Accounts() {
    }

    public Accounts(int accountId, double currentBalance, int accountTypeId, int accountStatusTypeId) {
        this.accountId = accountId;
        this.currentBalance = currentBalance;
        this.accountTypeId = accountTypeId;
        this.accountStatusTypeId = accountStatusTypeId;
    }

    @Override
    public String toString() {
        return "Account id: " + this.accountId
                + "\n" + "Current balance: " + this.currentBalance
                + "\n" + "Account type id: " + this.accountTypeId
                + "\n" + "Account status type id: " + this.accountStatusTypeId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public int getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(int accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    public int getAccountStatusTypeId() {
        return accountStatusTypeId;
    }

    public void setAccountStatusTypeId(int accountStatusTypeId) {
        this.accountStatusTypeId = accountStatusTypeId;
    }
}
