package bank.transaction;

import bank.core.DollarAmount;

public class TransactionAmounts {
  private DollarAmount amount;
  private DollarAmount newBalance;

  public TransactionAmounts(DollarAmount amount, DollarAmount newBalance) {
    this.amount = amount;
    this.newBalance = newBalance;
  }

  public String toString() {
    return "Amount: " + amount + ", Balance:" + newBalance;
  }

}
