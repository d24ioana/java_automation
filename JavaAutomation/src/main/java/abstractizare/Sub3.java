package abstractizare;

public class Sub3 extends Sub2{
    private int term;

    public Sub3(double balance) {
        super(balance);
    }

    public String ToString(){
        return ("The balance of the account is: " + balance);
    }
}
