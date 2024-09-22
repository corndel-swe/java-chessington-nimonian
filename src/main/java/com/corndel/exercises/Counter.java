package com.corndel.exercises;

public class Counter {
  private int count;

  public Counter() {
    this.count = 0;
  }

  public void increment() {
    this.count++;
  }

  public void reset() {
    this.count = 0;
  }

  public int getCount() {
    return this.count;
  }
}