package bank.core;

import bank.transaction.TransactionHistory;
import bank.transaction.filter.DateRangeRecordFilter;
import bank.transaction.filter.DepositRecordFilter;
import bank.transaction.filter.NoFilter;
import bank.transaction.filter.WithdrawalRecordFilter;

import java.util.Date;

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

  public void printStatement(StringBuffer buffer) {
    transactionHistory.print(new NoFilter(), buffer);
  }

  public void printDeposits(StringBuffer buffer) {
    transactionHistory.print(new DepositRecordFilter(), buffer);
  }

  public void printWithdrawals(StringBuffer buffer) {
    transactionHistory.print(new WithdrawalRecordFilter(), buffer);
  }

  public void printDateRange(Date start, Date end, StringBuffer buffer) {
    transactionHistory.print(new DateRangeRecordFilter(start, end), buffer);
  }
}