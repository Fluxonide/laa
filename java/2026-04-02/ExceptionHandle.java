/* 
2. Create a custom exception for handling bank related issue-
i. when user try to request more that it has in its stock or the max limit user can withdraw in one transaction.
ii. When user try to deposit or withdraw negative amount form their account.
 */

import java.util.Scanner;

class MyException extends Exception {
    MyException(String s) { super(s); }
}

class Bank {
    double bal = 1000;

    void withdraw(double a) throws MyException {
        if (a < 0) throw new MyException("neg amount");
        if (a > 500) throw new MyException("limit cross");
        if (a > bal) throw new MyException("low balance");
        bal -= a;
        System.out.println("withdrawn: " + a);
    }

    void deposit(double a) throws MyException {
        if (a < 0) throw new MyException("neg amount");
        bal += a;
        System.out.println("deposited: " + a);
    }
}

class ExceptionHandle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank b = new Bank();
        try {
            System.out.print("Enter amount to withdraw: ");
            b.withdraw(sc.nextDouble());
            System.out.print("Enter amount to deposit: ");
            b.deposit(sc.nextDouble());
        } catch (MyException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Balance: " + b.bal);
    }
}