package bank.core;

public class DollarAmount {

  private double amount;

  public DollarAmount(double amount) {
    this.amount = amount;
  }

  public DollarAmount(DollarAmount dollarAmount) {
    amount = dollarAmount.amount;
  }

  public DollarAmount add(DollarAmount amountToAdd) {
    return new DollarAmount(amount + amountToAdd.amount);
  }

  public DollarAmount subtract(DollarAmount amountToSubtract) {
    return new DollarAmount(amount - amountToSubtract.amount);
  }

  @Override
  public String toString() {
    return "$" + Double.toString(amount);
  }

  //auto-generated
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    DollarAmount that = (DollarAmount) o;

    if (Double.compare(that.amount, amount) != 0) return false;

    return true;
  }

  //auto-generated
  @Override
  public int hashCode() {
    long temp = amount != +0.0d ? Double.doubleToLongBits(amount) : 0L;
    return (int) (temp ^ (temp >>> 32));
  }
}
