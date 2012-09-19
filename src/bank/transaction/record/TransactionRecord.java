package bank.transaction.record;

import bank.transaction.TransactionAmounts;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class TransactionRecord {

  private TransactionAmounts transactionAmount;
  private Date transactionDate;

  protected TransactionRecord(TransactionAmounts amounts) {
    this.transactionDate = new Date();
    this.transactionAmount = amounts;
  }

  public boolean isDateWithin(Date startDate, Date endDate) {
    return isTransactionAfter(startDate) && isTransactionBefore(endDate);
  }

  private boolean isTransactionBefore(Date startDate) {
    return transactionDate.before(startDate);
  }

  private boolean isTransactionAfter(Date endDate) {
    return transactionDate.after(endDate);
  }

  public abstract boolean isDeposit();

  public abstract boolean isWithdrawal();

  @Override
  public String toString() {
    return unixTime() + ", " + transactionAmount + "\n";
  }

  private String formattedDate() {
    SimpleDateFormat format = new SimpleDateFormat();
    return format.format(transactionDate);
  }

  private String unixTime() {
    long unixTime = transactionDate.getTime();
    return Long.toString(unixTime);
  }

}
