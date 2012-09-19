package bank.transaction.record;

import bank.transaction.TransactionAmounts;

public class WithdrawalRecord extends TransactionRecord {

  public WithdrawalRecord(TransactionAmounts amount) {
    super(amount);
  }

  @Override
  public boolean isDeposit() {
    return false;
  }

  @Override
  public boolean isWithdrawal() {
    return true;
  }

  public String toString() {
    return "(-) - " + super.toString();
  }
}
