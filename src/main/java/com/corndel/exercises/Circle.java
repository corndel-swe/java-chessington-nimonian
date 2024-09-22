package com.corndel.exercises;

public class Circle implements Shape {
  private double radius;

  Circle(double radius) {
    this.radius = radius;
  }

  /**
   * Returns the radius of this Circle.
   *
   * @return the radius
   */
  public double getRadius() {
    return radius;
  }

  /**
   * Returns the perimeter of this Circle.
   *
   * The perimeter is defined as <i>2 * PI * r</i>, where <i>r</i> is the radius
   * of the circle.
   *
   * @return the perimeter
   */
  @Override
  public double getPerimeter() {
    return 2 * Maths.PI * this.getRadius();
  }

  /**
   * Returns the area of this Circle.
   *
   * The area is defined as <i>PI * r^2</i>, where <i>r</i> is the radius of
   * the circle.
   *
   * @return the area
   */
  @Override
  public double getArea() {
    return Maths.PI * this.getRadius() * this.getRadius();
  }
}
