// Hussein Alsaidi
// Midterm Exam
// 02-29-24

import java.util.Scanner;

public class Account {
    private String name;
    private String accountNumber;
    private double savingsAccountBalance;
    private double checkingAccountBalance;
    private double loanAmount;

    public Account() {
    }

    public Account(String name, String accountNumber, double savingsAccountBalance, double checkingAccountBalance, double loanAmount) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.savingsAccountBalance = savingsAccountBalance;
        this.checkingAccountBalance = checkingAccountBalance;
        this.loanAmount = loanAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getSavingsAccountBalance() {
        return savingsAccountBalance;
    }

    public void setSavingsAccountBalance(double savingsAccountBalance) {
        this.savingsAccountBalance = savingsAccountBalance;
    }

    public double getCheckingAccountBalance() {
        return checkingAccountBalance;
    }

    public void setCheckingAccountBalance(double checkingAccountBalance) {
        this.checkingAccountBalance = checkingAccountBalance;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public void checkBalances() {
        System.out.println("Savings Account Balance: " + savingsAccountBalance);
        System.out.println("Checking Account Balance: " + checkingAccountBalance);
        System.out.println("Loan Balance: " + loanAmount);
    }

    public void depositFunds(double amount) {
        checkingAccountBalance += amount;
        System.out.println("New Checking Account Balance after deposit: " + checkingAccountBalance);
        System.out.println("Name: " +name);
        System.out.println("Account number:" + accountNumber);
        System.out.println("Savings Account balance: " + savingsAccountBalance);
        System.out.println("Loan balance: " + loanAmount);
    }

    public void withdrawFunds(double amount) {
        if (checkingAccountBalance >= amount) {
            checkingAccountBalance -= amount;
            System.out.println("New Checking Account Balance after withdrawal: " + checkingAccountBalance);
            System.out.println("Name: " +name);
            System.out.println("Account number:" + accountNumber);
            System.out.println("Savings Account balance: " + savingsAccountBalance);
            System.out.println("Loan balance: " + loanAmount);
        } else {
            System.out.println("Insufficient funds in savings account.");
        }
    }

    public void transferFunds(double amount, Account recipientAccount, String sourceAccount) {

        if (sourceAccount.equalsIgnoreCase("checking")) {
            if (checkingAccountBalance >= amount) {
                checkingAccountBalance -= amount;
                System.out.println("Transfer Successful.");
            } else {
                System.out.println("Insufficient funds in checking account for transfer.");
                return;
            }
        } else if (sourceAccount.equalsIgnoreCase("savings")) {
            if (savingsAccountBalance >= amount) {
                savingsAccountBalance -= amount;
                System.out.println("Transfer Successful.");
            } else {
                System.out.println("Insufficient funds in savings account for transfer.");
                return;
            }
        } else {
            System.out.println("Invalid source account type.");
            return;
        }
        System.out.println("Checking Account Balance: " + checkingAccountBalance);
        System.out.println("Name: " + name);
        System.out.println("Account number:" + accountNumber);
        System.out.println("Savings Account balance: " + savingsAccountBalance);
        System.out.println("Loan balance: " + loanAmount);

    }

    public void payLoan(double amount) {
        if (checkingAccountBalance >= amount) {
            checkingAccountBalance -= amount;
            loanAmount -= amount;
            System.out.println("Name: " + name);
            System.out.println("Account number:" + accountNumber);
            System.out.println("Checking Account Balance: " + checkingAccountBalance);
            System.out.println("Savings Account balance: " + savingsAccountBalance);
            System.out.println("Loan balance: " + loanAmount);
        } else {
            System.out.println("Insufficient funds in savings account.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Account account1 = new Account("Tony Stark", "123456789", 2000.00, 1000.00, 500.00);
        Account account2 = new Account("Bruce Wayne", "234567891", 2500.00, 1200.00, 300.00);

        int choice;
        boolean exit = false;
        Account currentAccount = null;

        System.out.println("Enter 1 for Tony Stark or 2 for Bruce Wayne:");
        int accountChoice = scanner.nextInt();

        if (accountChoice == 1) {
            currentAccount = account1;
            System.out.println("Welcome Tony Stark!");
        } else if (accountChoice == 2) {
            currentAccount = account2;
            System.out.println("Welcome Bruce Wayne!");
        } else {
            System.out.println("Invalid choice.");
            return;
        }

        while (!exit) {
            System.out.println("\nPlease select from the following 6 Options Below:");
            System.out.println("1. Check Balances");
            System.out.println("2. Deposit Funds");
            System.out.println("3. Withdraw Funds");
            System.out.println("4. Transfer Funds");
            System.out.println("5. Pay Loan");
            System.out.println("6. Exit");
            System.out.print("Selection: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    currentAccount.checkBalances();
                    break;
                case 2:
                    System.out.println("Enter amount to deposit:");
                    double depositAmount = scanner.nextDouble();
                    currentAccount.depositFunds(depositAmount);
                    break;
                case 3:
                    System.out.println("Enter amount to withdraw:");
                    double withdrawAmount = scanner.nextDouble();
                    currentAccount.withdrawFunds(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Please select which account you would like to transfer from:");
                    System.out.println("1. Savings");
                    System.out.println("2. Checking");
                    int accountSelection = scanner.nextInt();
                    scanner.nextLine();
                    String sourceAccount = "";
                    if (accountSelection == 1) {
                        sourceAccount = "savings";
                    } else if (accountSelection == 2) {
                        sourceAccount = "checking";
                    } else {
                        System.out.println("Invalid selection. Please try again.");
                        break;
                    }
                    System.out.println("Deposit Amount:");
                    double transferAmount = scanner.nextDouble();
                    currentAccount.transferFunds(transferAmount, (accountChoice == 1) ? account2 : account1, sourceAccount);
                    break;
                case 5:
                    System.out.println("Enter amount to pay loan:");
                    double loanPaymentAmount = scanner.nextDouble();
                    currentAccount.payLoan(loanPaymentAmount);
                    break;
                case 6:
                    System.out.println("Goodbye " + currentAccount.getName());
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }
}
