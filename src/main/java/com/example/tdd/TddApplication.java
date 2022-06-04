package com.example.tdd;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;

@SpringBootApplication
public class TddApplication {
  public static void main(String[] args) {
    ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneOffset.UTC);
    System.out.println(zonedDateTime.toEpochSecond());
    zonedDateTime = zonedDateTime.minusDays(7);
    System.out.println(zonedDateTime.toEpochSecond());
  }
}
