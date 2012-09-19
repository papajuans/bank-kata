package bank.transaction.filter;

import bank.transaction.record.TransactionRecord;

public class NoFilter extends TransactionRecordFilter {

  @Override
  public boolean allows(TransactionRecord record) {
    return true;
  }
}
