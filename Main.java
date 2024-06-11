abstract class Account {
 private String accountNumber;
 private String accountHolder;
 protected double balance;
 public Account(String accountNumber, String accountHolder, double 
balance) {
 this.accountNumber = accountNumber;
 this.accountHolder = accountHolder;
 this.balance = balance;
 }
 public String getAccountNumber() {
 return accountNumber;
 }
 public String getAccountHolder() {
 return accountHolder;
 }
 public double getBalance() {
 return balance;
 }
 public void deposit(double amount) {
 if (amount > 0) {
 balance += amount;
 System.out.println("Deposited " + amount + ". New balance: " + 
balance);
 } else {
 System.out.println("Deposit amount must be positive.");
 }
 }
 public void withdraw(double amount) {
 if (amount > 0 && amount <= balance) {
 balance -= amount;
 System.out.println("Withdrew " + amount + ". New balance: " + 
balance);
 } else {
 System.out.println("Insufficient funds or invalid amount.");
 }
 }
 public abstract void calculateInterest();
}
class SavingsAccount extends Account {
 private double interestRate;
 public SavingsAccount(String accountNumber, String accountHolder, double 
balance, double interestRate) {
 super(accountNumber, accountHolder, balance);
 this.interestRate = interestRate;
 }
 @Override
 public void calculateInterest() {
 double interest = balance * interestRate / 100;
 balance += interest;
 System.out.println("Interest added: " + interest + ". New balance: " + 
balance);
 }
}
class CurrentAccount extends Account {
 private double overdraftLimit;
 public CurrentAccount(String accountNumber, String accountHolder, double 
balance, double overdraftLimit) {
 super(accountNumber, accountHolder, balance);
 this.overdraftLimit = overdraftLimit;
 }
 @Override
 public void withdraw(double amount) {
 if (amount > 0 && (balance + overdraftLimit >= amount)) {
 balance -= amount;
 System.out.println("Withdrew " + amount + ". New balance: " + 
balance);
 } else {
 System.out.println("Overdraft limit exceeded or invalid amount.");
 }
 }
 @Override
 public void calculateInterest() {
 System.out.println("No interest for current account.");
 }
}
public class Main {
 public static void main(String[] args) {
 SavingsAccount savingsAccount = new SavingsAccount("SA123", 
"charan", 1000.0, 5.0);
 CurrentAccount currentAccount = new CurrentAccount("CA123", 
"keerthi", 500.0, 200.0);
 
 savingsAccount.deposit(200.0);
 currentAccount.deposit(300.0);
 
 savingsAccount.withdraw(100.0);
 currentAccount.withdraw(600.0);
 
 savingsAccount.calculateInterest();
 currentAccount.calculateInterest();
 
 System.out.println("Savings Account Balance: " + 
savingsAccount.getBalance());
 System.out.println("Current Account Balance: " + 
currentAccount.getBalance());
}
}
