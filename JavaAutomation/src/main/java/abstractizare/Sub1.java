package abstractizare;

public abstract class Sub1 implements Bank{
    protected double balance;

    public Sub1(double balance){
        this.balance = balance;
    }

    public double Deposit(double amount){
        return balance = balance + amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
