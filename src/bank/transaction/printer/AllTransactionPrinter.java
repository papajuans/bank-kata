package bank.transaction.printer;

import bank.transaction.record.DepositRecord;
import bank.transaction.record.WithdrawalRecord;

public class AllTransactionPrinter implements TransactionHistoryPrinter {

  @Override
  public void printToBuffer(DepositRecord record, StringBuffer buffer) {
    buffer.append(record);
  }

  @Override
  public void printToBuffer(WithdrawalRecord record, StringBuffer buffer) {
    buffer.append(record);
  }
}
