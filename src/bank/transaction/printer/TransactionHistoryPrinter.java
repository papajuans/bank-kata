package bank.transaction.printer;

import bank.transaction.record.DepositRecord;
import bank.transaction.record.WithdrawalRecord;

public interface TransactionHistoryPrinter {

  public void printToBuffer(DepositRecord record, StringBuffer buffer);
  public void printToBuffer(WithdrawalRecord record, StringBuffer buffer);

}
