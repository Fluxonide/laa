/* Program 2:
 
Create a BankAccount class with given information:
Attributes- accountNumber, customerName, phoneNumber, password, balance
Behaviour -Withdraw Amount -Add Amount -displayInfo
 
Saving Account-
Attributes- interestRate, minBalance, withdrawLimit
Behaviour- updateWithdrawLimit, displayInfo

Bussiness Account-
Attributes- companyName, transactionFeeRate, transactionAmount
Behaviour- calculateTransactionFee, displayInfo
 
Note:
1. Users should not be able to change the name once created.
2. User should not be able to view password but can change it.
3. Saving Account and Business Account are child class of BankAccount.
4. Use appropriate getter and setter method for the attributes

 */



import java.util.Scanner;

//bank account
class BankAccount {
    private String accountNumber;
    private String customerName;
    private String phoneNumber;
    private String password;
    protected double balance;

    public BankAccount(String accNo, String name, String phone, String pass, double bal) {
        accountNumber = accNo;
        customerName = name;
        phoneNumber = phone;
        password = pass;
        balance = bal;
    }

    public void addAmount(double amt) {
        balance += amt;
        System.out.println("Amount Deposited.");
    }

    public void withdrawAmount(double amt) {
        if (amt <= balance) {
            balance -= amt;
            System.out.println("Amount Withdrawn.");
        } else {
            System.out.println("Insufficient Balance!");
        }
    }

    public void setPassword(String newPass) { password = newPass; }

    public void setPhoneNumber(String phone) { phoneNumber = phone; }

    public void displayInfo() {
        System.out.println("\n--- Account Info ---");
        System.out.println("Account No: " + accountNumber);
        System.out.println("Name: " + customerName);
        System.out.println("Phone: " + phoneNumber);
        System.out.println("Balance: " + balance);
    }
}
//savings account
class SavingAccount extends BankAccount {
    private double interestRate, minBalance;
    private int withdrawLimit;

    public SavingAccount(String accNo, String name, String phone, String pass, double bal,  double rate, double minBal, int limit) {
        super(accNo, name, phone, pass, bal);
        interestRate = rate;
        minBalance = minBal;
        withdrawLimit = limit;
    }

    public void updateWithdrawLimit(int newLimit) {
        withdrawLimit = newLimit;
        System.out.println("Withdraw Limit Updated.");
    }

    public void withdrawAmountSaving(double amt) {
        if (amt <= balance - minBalance && withdrawLimit > 0) {
            balance -= amt;
            withdrawLimit--;
            System.out.println("Amount Withdrawn.");
        } else {
            System.out.println("Cannot Withdraw!");
        }
    }

    public void displayInfoSaving() {
        displayInfo();
        System.out.println("Interest Rate: " + interestRate);
        System.out.println("Min Balance: " + minBalance);
        System.out.println("Withdraw Limit Left: " + withdrawLimit);
    }
}

//bussiness account
class BusinessAccount extends BankAccount {
    private String companyName;
    private double transactionFeeRate;

    public BusinessAccount(String accNo, String name, String phone, String pass, double bal, String company, double feeRate) {
        super(accNo, name, phone, pass, bal);
        companyName = company;
        transactionFeeRate = feeRate;
    }

    public void calculateTransactionFee(double amt) {
        double fee = amt * transactionFeeRate;
        balance -= fee;
        System.out.println("Transaction Fee: " + fee);
    }

    public void displayInfoBusiness() {
        displayInfo();
        System.out.println("Company Name: " + companyName);
        System.out.println("Transaction Fee Rate: " + transactionFeeRate);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Saving Account\n2. Business Account");
        System.out.print("Enter choice: ");
        int type = sc.nextInt();
        sc.nextLine();

        System.out.print("Account No: ");
        String accNo = sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Phone: ");
        String phone = sc.nextLine();
        System.out.print("Password: ");
        String pass = sc.nextLine();
        System.out.print("Balance: ");
        double bal = sc.nextDouble();

        if (type == 1) {
            System.out.print("Interest Rate: ");
            double rate = sc.nextDouble();
            System.out.print("Minimum Balance: ");
            double minBal = sc.nextDouble();
            System.out.print("Withdraw Limit: ");
            int limit = sc.nextInt();

            SavingAccount sa = new SavingAccount(accNo, name, phone, pass, bal, rate, minBal, limit);
            handleSavingAccount(sa, sc);

        } else {
            sc.nextLine();
            System.out.print("Company Name: ");
            String company = sc.nextLine();
            System.out.print("Transaction Fee Rate: ");
            double feeRate = sc.nextDouble();

            BusinessAccount ba = new BusinessAccount(accNo, name, phone, pass, bal, company, feeRate);
            handleBusinessAccount(ba, sc);
        }

        sc.close();
    }

    private static void handleSavingAccount(SavingAccount sa, Scanner sc) {
        int choice;
        do {
            System.out.println("\n1.Deposit 2.Withdraw 3.Update Limit 4.Display 5.Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> { System.out.print("Amount: "); sa.addAmount(sc.nextDouble()); }
                case 2 -> { System.out.print("Amount: "); sa.withdrawAmountSaving(sc.nextDouble()); }
                case 3 -> { System.out.print("New Limit: "); sa.updateWithdrawLimit(sc.nextInt()); }
                case 4 -> sa.displayInfoSaving();
            }
        } while (choice != 5);
    }

    private static void handleBusinessAccount(BusinessAccount ba, Scanner sc) {
        int choice;
        do {
            System.out.println("\n1.Deposit 2.Withdraw 3.Transaction Fee 4.Display 5.Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> { System.out.print("Amount: "); ba.addAmount(sc.nextDouble()); }
                case 2 -> { System.out.print("Amount: "); ba.withdrawAmount(sc.nextDouble()); }
                case 3 -> { System.out.print("Transaction Amount: "); ba.calculateTransactionFee(sc.nextDouble()); }
                case 4 -> ba.displayInfoBusiness();
            }
        } while (choice != 5);
    }
}
