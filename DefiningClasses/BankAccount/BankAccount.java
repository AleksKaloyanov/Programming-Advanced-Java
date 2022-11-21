package DefiningClasses.BankAccount;

public class BankAccount {
    private final static double DEFAULT_INTEREST_RATE = 0.02;
    private static int idCounter = 1;
    private int id;
    private double balance;
    private static double interestRate = DEFAULT_INTEREST_RATE;

    public BankAccount() {
        this.id = idCounter++;
        System.out.printf("Account ID%d created%n", this.id);
    }

    public static void setInterestRate(double interest) {
        BankAccount.interestRate = interest;
    }

    public void deposit(double amount) {
        this.balance += amount;
        System.out.printf("Deposited %.2g to ID%d%n", amount, this.id);
    }

    public double getInterest(int years) {
        return this.balance * years * interestRate;
    }

    public int getId() {
        return this.id;
    }
}
