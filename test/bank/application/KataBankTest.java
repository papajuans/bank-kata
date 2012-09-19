package bank.application;

import bank.core.DollarAmount;
import bank.core.Customer;
import bank.core.CustomerInformation;
import org.junit.Before;
import org.junit.Test;

import java.sql.Time;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class KataBankTest {

  private DollarAmount batmanInitialBalance;
  private DollarAmount robinInitialBalance;
  private Customer batman;
  private Customer robin;

  @Before
  public void setup() {
    batmanInitialBalance = new DollarAmount(500);
    robinInitialBalance = new DollarAmount(50);
    batman = new Customer(batmanInitialBalance, new CustomerInformation("batman"));
    robin = new Customer(robinInitialBalance, new CustomerInformation("robin"));
  }

  @Test
  public void testDeposits(){
    DollarAmount someAmount = randomDollarAmount();
    batman.deposit(someAmount);
    assertEquals(batman.currentBalance(), batmanInitialBalance.add(someAmount));

    DollarAmount anotherAmount = randomDollarAmount();
    batman.deposit(anotherAmount);
    assertEquals(batman.currentBalance(), batmanInitialBalance.add(someAmount).add(anotherAmount));

  }

  @Test
  public void testWithdrawals() {
    DollarAmount someAmount = randomDollarAmount();
    robin.withdrawal(someAmount);
    assertEquals(robin.currentBalance(), robinInitialBalance.subtract(someAmount));

    DollarAmount anotherAmount = randomDollarAmount();
    robin.withdrawal(anotherAmount);
    assertEquals(robin.currentBalance(), robinInitialBalance.subtract(someAmount).subtract(anotherAmount));
  }

  @Test
  public void testTransfers() {
    DollarAmount someAmount = randomDollarAmount();
    batman.transferTo(robin, someAmount);

    assertEquals(batman.currentBalance(), batmanInitialBalance.subtract(someAmount));
    assertEquals(robin.currentBalance(), robinInitialBalance.add(someAmount));

    DollarAmount anotherAmount = randomDollarAmount();
    robin.transferTo(batman, anotherAmount);
    assertEquals(batman.currentBalance(), batmanInitialBalance.subtract(someAmount).add(anotherAmount));
    assertEquals(robin.currentBalance(), robinInitialBalance.add(someAmount).subtract(anotherAmount));

  }

  @Test
  public void printFullStatement() {
    System.out.println("********** Full Statement ***********");
    DollarAmount someAmount = randomDollarAmount();
    DollarAmount anotherAmount = randomDollarAmount();

    batman.deposit(someAmount);
    batman.deposit(someAmount);
    batman.withdrawal(anotherAmount);

    StringBuffer buffer = new StringBuffer();
    batman.printStatement(buffer);
    printBufferWithLines("Full Statement", buffer);
    System.out.println("***************************************");
  }

  @Test
  public void printDepositsOnly() {
    System.out.println("***************************************");
    DollarAmount someAmount = randomDollarAmount();
    DollarAmount anotherAmount = randomDollarAmount();

    batman.deposit(someAmount);
    batman.withdrawal(anotherAmount);
    batman.withdrawal(anotherAmount);
    batman.withdrawal(anotherAmount);
    batman.deposit(anotherAmount);

    StringBuffer buffer = new StringBuffer();
    batman.printStatement(buffer);
    printBufferWithLines("Full Statement", buffer);
    buffer = new StringBuffer();
    batman.printDeposits(buffer);
    printBufferWithLines("Deposits Only", buffer);
    System.out.println("***************************************");
  }

  @Test
  public void printWithdrawalsOnly() {
    System.out.println("***************************************");
    DollarAmount someAmount = randomDollarAmount();
    DollarAmount anotherAmount = randomDollarAmount();

    batman.deposit(someAmount);
    batman.withdrawal(anotherAmount);
    batman.withdrawal(anotherAmount);
    batman.withdrawal(anotherAmount);
    batman.deposit(anotherAmount);

    StringBuffer buffer = new StringBuffer();
    batman.printStatement(buffer);
    printBufferWithLines("Full Statement", buffer);
    buffer = new StringBuffer();
    batman.printWithdrawals(buffer);
    printBufferWithLines("Withdrawals Only", buffer);
    System.out.println("***************************************");
  }

  private DollarAmount randomDollarAmount() {
    return new DollarAmount(new Random().nextInt(100) + 1);
  }

  private void printBufferWithLines(String title, StringBuffer buffer) {
    System.out.println("----" + title + "----");
    System.out.print(buffer);
    System.out.println("------------------------");
  }

}
