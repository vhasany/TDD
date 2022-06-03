package com.example.tdd.bank;

public interface AccountManager {
  Account findAccountForUser(String userId);

  void updateAccount(Account account);
}
