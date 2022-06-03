package com.example.tdd.environment;

public record TestEnvironment(JavaSpecification javaSpecification,
                              OperationSystem operationSystem) {
  public boolean isWindows() {
    return operationSystem.name().contains("Windows");
  }

  public boolean isFedora() {
    return operationSystem.name().contains("Linux");
  }

  public boolean isAmd64Architecture() {
    return operationSystem.architecture().equalsIgnoreCase("amd64");
  }

  public String getJavaVersion() {
    return javaSpecification.version();
  }
}
