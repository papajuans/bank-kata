package bank.transaction.record;

import bank.transaction.TransactionAmounts;
import bank.transaction.printer.TransactionHistoryPrinter;

public class DepositRecord extends TransactionRecord {

  public DepositRecord(TransactionAmounts amounts) {
    super(amounts);
  }

  @Override
  public void print(TransactionHistoryPrinter printer, StringBuffer buffer) {
    printer.printToBuffer(this, buffer);
  }

  public String toString() {
    return "(+) - " + super.toString();
  }


}
