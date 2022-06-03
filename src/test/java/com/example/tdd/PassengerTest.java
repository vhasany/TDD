package com.example.tdd;

import com.example.tdd.extensions.DataAccessObjectParameterResolver;
import com.example.tdd.extensions.DatabaseOperationsExtension;
import com.example.tdd.extensions.ExecutionContextExtension;
import com.example.tdd.repository.PassengerDao;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith({
        ExecutionContextExtension.class,
        DatabaseOperationsExtension.class,
        DataAccessObjectParameterResolver.class
})
public record PassengerTest(PassengerDao passengerDao) {
  @Test
  void testPassenger() {
    var passenger = new Passenger("123-456-789", "John");
    Assertions.assertTrue(passenger.toString().contains("John"), "passenger doesn't contains John");
  }

  @Test
  void testInsertPassenger() {
    var passenger = new Passenger("123-456-789", "John");
    passengerDao.insert(passenger);
    assertEquals("John", passengerDao.getById("123-456-789").getName());
  }

  @Test
  void testUpdatePassenger() {
    var passenger = new Passenger("123-456-789", "John");
    passengerDao.insert(passenger);
    passengerDao.update("123-456-789", "Michael");
    assertEquals("Michael", passengerDao.getById("123-456-789").getName());
  }

  @Test
  void testDeletePassenger() {
    var passenger = new Passenger("123-456-789", "John");
    passengerDao.insert(passenger);
    passengerDao.delete(passenger);
    assertNull(passengerDao.getById("123-456-789"));
  }
}
