package bank.transaction;

import bank.core.DollarAmount;
import bank.transaction.printer.TransactionHistoryPrinter;
import bank.transaction.record.DepositRecord;
import bank.transaction.record.TransactionRecord;
import bank.transaction.record.WithdrawalRecord;

import java.util.ArrayList;
import java.util.List;

public class TransactionHistory {
  private List<TransactionRecord> records;

  public TransactionHistory() {
    this.records = new ArrayList<TransactionRecord>();
  }

  public void addDepositRecord(DollarAmount depositAmount, DollarAmount newBalance) {
    TransactionAmounts depositAmounts = new TransactionAmounts(depositAmount, newBalance);
    DepositRecord depositRecord = new DepositRecord(depositAmounts);
    records.add(depositRecord);
  }

  public void addWithdrawalRecord(DollarAmount withdrawalAmount, DollarAmount newBalance) {
    TransactionAmounts withdrawalAmounts = new TransactionAmounts(withdrawalAmount, newBalance);
    WithdrawalRecord withdrawalRecord = new WithdrawalRecord(withdrawalAmounts);
    records.add(withdrawalRecord);
  }

  public void print(TransactionHistoryPrinter printer, StringBuffer buffer) {
    for(TransactionRecord r : records) {
      r.print(printer, buffer);
    }
  }

}
