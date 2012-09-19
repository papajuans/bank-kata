package bank.transaction.filter;

import bank.transaction.record.TransactionRecord;

import java.util.Date;

public class DateRangeRecordFilter extends TransactionRecordFilter {

  Date startDate;
  Date endDate;

  public DateRangeRecordFilter(Date start, Date end) {
    super();
    this.startDate = start;
    this.endDate = end;
  }

  @Override
  public boolean allows(TransactionRecord record) {
    return record.isDateWithin(startDate, endDate);
  }
}
