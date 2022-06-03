package com.example.tdd.extensions;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.io.IOException;
import java.util.Properties;

public class ExecutionContextExtension implements ExecutionCondition {
  @Override
  public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext extensionContext) {
    var properties = new Properties();
    var executionContext = "";
    try {
      properties.load(
          ExecutionContextExtension.class
              .getClassLoader()
              .getResourceAsStream("context.properties"));
      executionContext = properties.getProperty("context");
      if (!executionContext.equalsIgnoreCase("regular")
          && !executionContext.equalsIgnoreCase("low")) {
        return ConditionEvaluationResult.disabled("test disabled outside regular and low context!");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return ConditionEvaluationResult.enabled(
        "test enabled on the " + executionContext + " context");
  }
}
