package bank.core;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class DollarAmountTest {

  private DollarAmount testAmount;
  private DollarAmount result;

  @Test
  public void testAddingDollarAmount() {
    given10Dollars();
    whenAdding5Dollars();
    thenTestAmountIs(15.0);
  }

  @Test
  public void testSubtractingDollarAmount() {
    given10Dollars();
    whenSubtracting5Dollars();
    thenTestAmountIs(5.0);
  }

  private void given10Dollars() {
    testAmount = new DollarAmount(10.0);
  }

  private void whenAdding5Dollars() {
    DollarAmount fiveDollars = new DollarAmount(5.0);
    result = testAmount.add(fiveDollars);
  }

  private void whenSubtracting5Dollars() {
    DollarAmount fiveDollars = new DollarAmount(5.0);
    result = testAmount.subtract(fiveDollars);
  }

  private void thenTestAmountIs(Double d) {
    DollarAmount expected = new DollarAmount(d);
    assertEquals(expected, result);
  }
}
