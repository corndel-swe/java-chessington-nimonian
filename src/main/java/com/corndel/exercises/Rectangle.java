package com.corndel.exercises;

public class Rectangle implements Shape {
  private double width;
  private double height;

  public Rectangle(double width, double height) {
    this.width = width;
    this.height = height;
  }

  @Override
  public double getArea() {
    return this.width * this.height;
  }

  @Override
  public double getPerimeter() {
    return 2 * (this.width + this.height);
  }

  public double getWidth() {
    return this.width;
  }

  public double getHeight() {
    return this.height;
  }
}
