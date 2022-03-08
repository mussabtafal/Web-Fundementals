import java.util.concurrent.ThreadLocalRandom;

public class BankAccount {
    private double checkingBalance;
    private double savingBalance;
    private long accountNo;
    private static int numberOfAccounts = 0;
    private static double totalBalance = 0;
// Constructor method
    public BankAccount() {
        accountNo = randTenDigit();
        numberOfAccounts++;
    }
    public static int accountNo() {
        return numberOfAccounts;
    }

    public static double totalBalance() {
        return totalBalance;
    }
// checkingBalance Getters and Setters

    // public void setCheck(double checkingBalance) {
    //     this.checkingBalance = checkingBalance;
    // }

    public Double getCheck() {
        return checkingBalance;
    }
// savingBalance Getters and Setters

    // public void setSaving(double savingBalance) {
    //     this.savingBalance = savingBalance;
    // }

    public Double getSaving() {
        return savingBalance;
    }

// BankAccount Methods
    private long randTenDigit() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        return random.nextLong(1_000_000_000L, 10_000_000_000L);
    }

    public Double depositMoney(double amount, String account){
        if ("Checking" == account){
            this.checkingBalance += amount;
            totalBalance += amount;
            return checkingBalance;
        }
        else{
            this.savingBalance += amount;
            totalBalance += amount;
            return savingBalance;
        }
    }

    public Double withdrawMoney(double amount, String account){
        if (account =="Checking"){
            if (this.checkingBalance - amount >= 0){
                this.checkingBalance -= amount;
                totalBalance -= amount;
                return checkingBalance;
            }
            else {
                System.out.println("Insufficient Funds");
                return checkingBalance;
            }
        }
        else{
            if (this.savingBalance - amount > 0){
                this.savingBalance -= amount;
                totalBalance -= amount;
                return savingBalance;
            }
            else {
                System.out.println("Insufficient Funds");
                return savingBalance;
            }
        }
    }

    public void display(){
        System.out.println("Customer Checking Balance: " + this.checkingBalance);
        System.out.println("Customer Saving Balance: " + this.savingBalance);
        System.out.println("Customer Account ID: " + this.accountNo);
    }
}
