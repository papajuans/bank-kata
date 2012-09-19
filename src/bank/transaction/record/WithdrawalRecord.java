package bank.transaction.record;

import bank.transaction.TransactionAmounts;
import bank.transaction.printer.TransactionHistoryPrinter;

public class WithdrawalRecord extends TransactionRecord {

  public WithdrawalRecord(TransactionAmounts amount) {
    super(amount);
  }

  @Override
  public void print(TransactionHistoryPrinter printer, StringBuffer buffer) {
    printer.printToBuffer(this, buffer);
  }

  public String toString() {
    return "(-) - " + super.toString();
  }
}
