package com.example.tdd;

import java.util.Objects;

public class SUT {
  private Job currentJob;

  public void run(Job currentJob) {
    this.currentJob = currentJob;
  }

  public boolean hasJobToRun() {
    return Objects.nonNull(currentJob);
  }
}
