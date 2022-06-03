package com.example.tdd;

import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestTestAssertion {
  List<String> strings;

  @BeforeEach
  void fillList() {
    strings = new ArrayList<>();
    strings.add("Vahid");
    strings.add("Zhila");
    strings.add("Sourena");
    strings.add("Sirvan");
  }

  @Test
  @DisplayName("test with Hamcrest")
  void hamcrestTest(TestReporter testReporter) {
    assertThat(strings, hasSize(4));
    assertThat(strings, hasItem(anyOf(equalTo("Vahid"), equalTo("Sourena"), equalTo("nadia"))));
  }
}
