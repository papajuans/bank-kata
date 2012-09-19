package bank.transaction.filter;

import bank.transaction.record.TransactionRecord;

public class DepositRecordFilter extends TransactionRecordFilter {

  @Override
  public boolean allows(TransactionRecord record) {
    return record.isDeposit();
  }

}