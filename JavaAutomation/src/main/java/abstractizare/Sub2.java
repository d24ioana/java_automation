package abstractizare;

public abstract class Sub2 extends Sub1{
    public Sub2(double balance) {
        super(balance);
    }

    public double Withdraw(double amount){
        return balance = balance - amount;
    }
}
