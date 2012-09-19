package bank.transaction.filter;

import bank.transaction.record.TransactionRecord;

public abstract class TransactionRecordFilter {

  public abstract boolean allows(TransactionRecord record);

}
