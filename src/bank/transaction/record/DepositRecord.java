package bank.transaction.record;

import bank.transaction.TransactionAmounts;

public class DepositRecord extends TransactionRecord {

  public DepositRecord(TransactionAmounts amounts) {
    super(amounts);
  }

  @Override
  public boolean isDeposit() {
    return true;
  }

  @Override
  public boolean isWithdrawal() {
    return false;
  }

  public String toString() {
    return "(+) - " + super.toString();
  }


}
