/* 
2. Create a custom exception for handling bank related issue-
i. when user try to request more that it has in its stock or the max limit user can withdraw in one transaction.
ii. When user try to deposit or withdraw negative amount form their account.
 */

import java.util.Scanner;

class MyException extends Exception {
    String msg;

    MyException(String s) {
          msg = s;
    }

    public String getMessage() {
        return msg;
    }
}

class Bank {
    private double bal = 1000;

    void withdraw(double a) throws MyException {
        if (a < 0) throw new MyException("Negative amount");
        if (a > 500) throw new MyException("Limit exceeded");
        if (a > bal) throw new MyException("Insufficient balance");

        bal -= a;
        System.out.println("Withdrawn: " + a);
    }

    void deposit(double a) throws MyException {
        if (a < 0) throw new MyException("Negative amount");

        bal += a;
        System.out.println("Deposited: " + a);
    }

    double getBalance() {
        return bal;
    }
}

public class ExceptionHandle {
    public static void main(String[] args) {
        ExceptionHandle obj = new ExceptionHandle();
        obj.run();
    }

    void run() {
        Scanner sc = new Scanner(System.in);
        Bank b = new Bank();

        try {
            System.out.print("Enter amount to withdraw: ");
            double w = sc.nextDouble();
            b.withdraw(w);

            System.out.print("Enter amount to deposit: ");
            double d = sc.nextDouble();
            b.deposit(d);

        } catch (MyException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Balance: " + b.getBalance());
    }
}