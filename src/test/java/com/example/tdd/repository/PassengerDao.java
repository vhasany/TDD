package com.example.tdd.repository;

import com.example.tdd.Passenger;

public interface PassengerDao {
  void insert(Passenger passenger);

  void update(String id, String name);

  void delete(Passenger passenger);

  Passenger getById(String id);
}
