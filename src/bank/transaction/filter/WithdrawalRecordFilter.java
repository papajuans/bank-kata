package bank.transaction.filter;

import bank.transaction.record.TransactionRecord;

public class WithdrawalRecordFilter extends TransactionRecordFilter {
  @Override
  public boolean allows(TransactionRecord record) {
    return record.isWithdrawal();
  }
}