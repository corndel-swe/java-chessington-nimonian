package com.corndel.exercises;

public class Counter {
  private int count;

  public Counter() {
    this.count = 0;
  }

  /**
   * Increment the count by one.
   */
  public void increment() {
    this.count++;
  }

  /**
   * Reset the count to zero.
   */
  public void reset() {
    this.count = 0;
  }

  /**
   * Get the current count.
   *
   * @return The current count.
   */
  public int getCount() {
    return this.count;
  }
}