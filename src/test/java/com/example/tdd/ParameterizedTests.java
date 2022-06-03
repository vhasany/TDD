package com.example.tdd;

import com.example.tdd.environment.Sentences;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

public class ParameterizedTests {
  static int i = 0;

  @ParameterizedTest
  @ValueSource(strings = {"Vahid", "Zhila", "Sourena", "Sirvan"})
  @DisplayName("parameterized arguments test")
  @Tag("parameters")
  void parameterizedTest(String sequence, TestReporter testReporter, TestInfo testInfo) {
    testReporter.publishEntry(
        testInfo.getDisplayName(), "strings sequence : " + sequence + " repetition ");
  }

  @ParameterizedTest
  @EnumSource(
      value = Sentences.class,
      names = {"Vahid", "Zhila"},
      mode = EnumSource.Mode.EXCLUDE)
  @Tag("parameters")
  void EnumTestParameter(Sentences sentences, TestReporter testReporter) {
    testReporter.publishEntry("sentences value: ", sentences.name());
  }

  @ParameterizedTest
  //  @CsvFileSource(resources = "/parameters.csv")
  @Tag("parameters")
  @DisplayName("csvParameterTest")
  @MethodSource(value = "getName")
  void csvParameterizedTest(int expected, String sentence, TestReporter testReporter) {
    i++;
    testReporter.publishEntry(sentence, String.valueOf(expected));
    Assertions.assertEquals(i, expected, "counter and expected value don't match ");
  }

  static Stream<Arguments> getName() {
    return Stream.of(
        Arguments.of("1", "Vahid"),
        Arguments.of("2", "MAhi"),
        Arguments.of("3", "DADY"),
        Arguments.of("4", "MADI"),
        Arguments.of("5", "NADI"),
        Arguments.of("6", "RAD"));
  }
}
