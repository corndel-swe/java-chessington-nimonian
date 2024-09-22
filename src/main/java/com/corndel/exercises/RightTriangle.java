package com.corndel.exercises;

public class RightTriangle implements Shape {
  private double base;
  private double height;

  RightTriangle(double base, double height) {
    this.base = base;
    this.height = height;
  }

  public double getBase() {
    return this.base;
  }

  public double getHeight() {
    return this.height;
  }

  public double getHypotenuse() {
    return Math.sqrt(base * base + height * height);
  }

  @Override
  public double getPerimeter() {
    return this.getBase() + this.getHeight() + this.getHypotenuse();
  }

  @Override
  public double getArea() {
    return this.getBase() * this.getHeight() / 2;
  }
}
