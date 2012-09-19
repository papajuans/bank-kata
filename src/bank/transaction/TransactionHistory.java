package bank.transaction;

import bank.core.DollarAmount;
import bank.transaction.filter.TransactionRecordFilter;
import bank.transaction.record.DepositRecord;
import bank.transaction.record.TransactionRecord;
import bank.transaction.record.WithdrawalRecord;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

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

  public void print(TransactionRecordFilter filter, StringBuffer buffer) {
    for(TransactionRecord record: records) {
      conditionallyAddToBuffer(filter, buffer, record);
    }
  }

  private void conditionallyAddToBuffer(TransactionRecordFilter filter, StringBuffer buffer, TransactionRecord record) {
    if(filter.allows(record)) {
      buffer.append(record);
    }
  }

}
