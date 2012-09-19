package bank.transaction.printer;

import bank.transaction.record.DepositRecord;
import bank.transaction.record.WithdrawalRecord;

public class WithdrawalsPrinter implements TransactionHistoryPrinter {

  @Override
  public void printToBuffer(DepositRecord record, StringBuffer buffer) {
    //Do nothing
  }

  @Override
  public void printToBuffer(WithdrawalRecord record, StringBuffer buffer) {
    buffer.append(record);
  }
}
