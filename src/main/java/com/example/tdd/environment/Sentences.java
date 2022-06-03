package com.example.tdd.environment;

public enum Sentences {
  Vahid("Vahid Hasani"),
  Zhila("Zhila Bakhshi"),
  Sourena("SOurena Hasani"),
  Sirvan("Sirvan Hasani");

  private final String fullName;

  Sentences(String fullName) {
    this.fullName = fullName;
  }
}
