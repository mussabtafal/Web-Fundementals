public class BankAccountTest {
    public static void main(String[] args) {
    // Accounts initiation
    BankAccount account1 = new BankAccount();
    BankAccount account2 = new BankAccount();
    BankAccount account3 = new BankAccount();
    BankAccount account4 = new BankAccount();

    account1.depositMoney(500, "Checking");
    account1.display();

    account1.withdrawMoney(500, "Checking");
    account1.display();

    
    }
}
