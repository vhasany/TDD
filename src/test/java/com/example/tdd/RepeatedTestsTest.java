package com.example.tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestReporter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RepeatedTestsTest {
  private static Set<Integer> integerSet = new HashSet<>();
  private static List<Integer> integerList = new ArrayList<>();

  @RepeatedTest(
      value = 5,
      name = "{displayName} - repetition {currentRepetition}/{totalRepetitions}")
  @DisplayName("test add repetition")
  void addNumber() {
    Calculator calculator = new Calculator();
    assertEquals(2, calculator.add(1, 1), "1+1 should be 2");
  }

  @RepeatedTest(
      value = 5,
      name = "the list contains {currentRepetition} element(s) , The set contains 1 element")
  @DisplayName("test set and integer")
  void testAddingToCollections(TestReporter testReporter, RepetitionInfo repetitionInfo) {
    integerList.add(repetitionInfo.getTotalRepetitions());
    integerSet.add(1);
    testReporter.publishEntry(
        "Repetition number", String.valueOf(repetitionInfo.getCurrentRepetition()));
    assertEquals(1, integerSet.size());
    assertEquals(integerList.size(), repetitionInfo.getTotalRepetitions());
  }
}
