package bank.transaction.filter;

import bank.transaction.TransactionHistory;
import bank.transaction.record.TransactionRecord;

public abstract class TransactionRecordFilter {

  public abstract boolean allows(TransactionRecord record);

}
