package socketPackage;

public class Account
{
    private String name;
    private   String accountNo;
    private double balance;
    private String NID;

    public void withdraw(double amount)
    {
        if(balance>amount && amount>0)balance-=amount;
    }

    public void deposit(double amount)
    {
        if(amount>0) balance+=amount;
    }

    public String getName() {
        return name;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public String getNID() {
        return NID;
    }

    public Account(String name, String accountNo, double balance, String NID) {
        this.name = name;
        this.accountNo = accountNo;
        this.balance = balance;
        this.NID = NID;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", accountNo='" + accountNo + '\'' +
                ", balance=" + balance +
                ", NID='" + NID + '\'' +
                '}';
    }
}
