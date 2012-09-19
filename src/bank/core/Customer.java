package bank.core;

import java.util.Date;

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
    bankAccount.printStatement(buffer);
  }

  public void printDeposits(StringBuffer buffer) {
    bankAccount.printDeposits(buffer);
  }

  public void printWithdrawals(StringBuffer buffer) {
    bankAccount.printWithdrawals(buffer);
  }

  public void printDateRange(Date start, Date end, StringBuffer buffer) {
    bankAccount.printDateRange(start, end, buffer);
  }

  public DollarAmount currentBalance() {
    return bankAccount.currentBalance();
  }

  public void transferTo(Customer targetCustomer, DollarAmount transferAmount) {
    BankAccount targetAccount = targetCustomer.bankAccount;
    bankAccount.transferTo(targetAccount, transferAmount);
  }

  public boolean matches(CustomerInformation information) {
    return customerInformation.equals(information);
  }
}
