# bank-kata

This is my own attempt at the object-calisthenics assignment.

Things that I do not like about it (smells): 
- A lot of pass throughs; Especially with printing: Customer delegates to BankAccount delegates to
  TransactionHistory - I don't think I modelled this correctly
- I'm not entirely sure that transfer() uses good encapsulation
- I'm tired
