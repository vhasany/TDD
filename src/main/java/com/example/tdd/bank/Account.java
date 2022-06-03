package com.example.tdd.bank;

public class Account {
  private String accountId;
  private long balance;

  public Account(String accountId, long initBalance) {
    this.accountId = accountId;
    this.balance = initBalance;
  }

  public void debit(long amount) {
    this.balance -= amount;
  }

  public void credit(long amount) {
    this.balance += amount;
  }

  public long getBalance() {
    return balance;
  }
}
