package bank.core;

import bank.transaction.printer.AllTransactionPrinter;
import bank.transaction.printer.DepositsPrinter;
import bank.transaction.printer.WithdrawalsPrinter;

public class Customer {
  private BankAccount bankAccount;
  private CustomerInformation customerInformation;

  public Customer(DollarAmount initialDeposit, CustomerInformation customerInformation) {
    this.bankAccount = new BankAccount(initialDeposit);
    this.customerInformation = customerInformation;
  }

  public void deposit(DollarAmount depositAmount) {
    bankAccount.deposit(depositAmount);
  }

  public void withdrawal(DollarAmount withdrawalAmount) {
    bankAccount.withdrawal(withdrawalAmount);
  }

  public void printStatement(StringBuffer buffer) {
    bankAccount.printStatement(new AllTransactionPrinter(), buffer);
  }

  public void printDeposits(StringBuffer buffer) {
    bankAccount.printStatement(new DepositsPrinter(), buffer);
  }

  public void printWithdrawals(StringBuffer buffer) {
    bankAccount.printStatement(new WithdrawalsPrinter(), buffer);
  }

  public DollarAmount currentBalance() {
    return bankAccount.currentBalance();
  }

  public void transferTo(Customer targetCustomer, DollarAmount transferAmount) {
    BankAccount targetAccount = targetCustomer.bankAccount;
    bankAccount.transferTo(targetAccount, transferAmount);
  }
}
