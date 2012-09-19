package bank.core;

import bank.transaction.TransactionHistory;
import bank.transaction.printer.TransactionHistoryPrinter;

public class BankAccount {

  private DollarAmount currentBalance;
  private TransactionHistory transactionHistory;

  public BankAccount(DollarAmount initialBalance) {
    currentBalance = new DollarAmount(0);
    this.transactionHistory = new TransactionHistory();
    deposit(initialBalance);
  }

  public void deposit(DollarAmount depositAmount) {
    currentBalance = currentBalance.add(depositAmount);
    transactionHistory.addDepositRecord(depositAmount, new DollarAmount(currentBalance));
  }

  public void withdrawal(DollarAmount withdrawalAmount) {
    currentBalance = currentBalance.subtract(withdrawalAmount);
    transactionHistory.addWithdrawalRecord(withdrawalAmount, new DollarAmount(currentBalance));
  }

  public void transferTo(BankAccount targetAccount, DollarAmount transferAmount) {
    withdrawal(transferAmount);
    targetAccount.deposit(transferAmount);
  }

  public DollarAmount currentBalance() {
    return new DollarAmount(currentBalance);
  }

  public void printStatement(TransactionHistoryPrinter printer, StringBuffer buffer) {
    transactionHistory.print(printer, buffer);
  }

}