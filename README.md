# bank-kata

This is my own attempt at the object-calisthenics assignment.

Things that I do not like about it (smells): 
- A lot of pass throughs; Especially with printing: Customer delegates to BankAccount delegates to
  TransactionHistory - I don't think I modelled this correctly
- I'm not entirely sure that transfer() uses good encapsulation
- I'm tired
- The stupid StringBuffer being passed through for all the print() was a half-thought; I was
  originally going to do matching on the final buffer, but got lazy.
- All of the printing needs to be refactored to be a separate concern.

Things that I should probably do:
- Actual error checking for negative balances

# Assignment Details
The Bank Account Kata

Coding exercise based on the strict rules contained in ObjectCalisthenics.pdf. Meant to give a
deeper understanding of object-oriented principles.

Think of your personal bank account experience. When in doubt, go for the simplest solution.

Requirements

- Deposit and withdrawal
- Transfer
- Account statement (date, amount, balance)
- Statement printing
- Statement filters (just deposits, withdrawal, date)
- Rules

1. Use only one level of indentation per method
2. Don’t use the else keyword
3. Wrap all primitives and strings
4. Use only one dot per line
5. Don’t abbreviate
6. Keep all entities small (<50 lines)
7. Don’t use any classes with more than two instance variables
8. Use first-class collections
9. Don’t use any getters/setters/properties
