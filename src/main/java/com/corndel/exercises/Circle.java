package com.corndel.exercises;

public class Circle implements Shape {
  private double radius;

  Circle(double radius) {
    this.radius = radius;
  }

  public double getRadius() {
    return radius;
  }

  @Override
  public double getPerimeter() {
    return 2 * Maths.PI * this.getRadius();
  }

  @Override
  public double getArea() {
    return Maths.PI * this.getRadius() * this.getRadius();
  }
}
