package com.example.tdd;

import com.example.tdd.environment.JavaSpecification;
import com.example.tdd.environment.OperationSystem;
import com.example.tdd.environment.TestEnvironment;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assumptions.*;

@DisplayName("assumption test")
@Tag("system")
public class AssumptionsTest {
  private static String EXPECTED_JAVA_VERSION = "17";
  private TestEnvironment testEnvironment =
      new TestEnvironment(
          new JavaSpecification(System.getProperty("java.vm.specification.version")),
          new OperationSystem(System.getProperty("os.name"), System.getProperty("os.arch")));
  private SUT systemUnderTest = new SUT();

  @BeforeEach
  void setUp() {
    assumeTrue(testEnvironment.isFedora(), "invalid assumption Linux OS");
    assumeFalse(testEnvironment.isWindows(), "invalid assumption Linux OS system under Windows OS");
  }

  @Test
  @DisplayName("check sut hasn't any job")
  void testNoJobToRun() {
    assumingThat(
        () -> testEnvironment.getJavaVersion().equalsIgnoreCase(EXPECTED_JAVA_VERSION),
        () -> assertFalse(systemUnderTest.hasJobToRun(), "system has job to run"));
  }

  @DisplayName("check system has job to run")
  @RepeatedTest(value = 5, name = "repeatedTestName")
  void testJobToRun(TestReporter testReporter, RepetitionInfo repetitionInfo) {
    assumeTrue(testEnvironment.isAmd64Architecture());
    systemUnderTest.run(new Job());
    assumeTrue(systemUnderTest.hasJobToRun(), "system has no job to run");
    testReporter.publishEntry("count {}", "Hello reporter!");
    testReporter.publishEntry(
        "repetition : ", String.valueOf(repetitionInfo.getTotalRepetitions()));
  }
}
