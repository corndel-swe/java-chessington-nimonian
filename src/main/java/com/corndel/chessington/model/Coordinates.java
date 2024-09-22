package com.corndel.chessington.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

public final class Coordinates {
  private final int row;
  private final int col;

  @JsonCreator
  public Coordinates(@JsonProperty("row_num") int row, @JsonProperty("column_num") int col) {
    this.row = row;
    this.col = col;
  }

  /**
   * Returns the row number of the coordinates. Row numbers are zero-indexed and
   * increase going down the board.
   *
   * @return the row number
   */
  public int getRow() {
    return row;
  }

  /**
   * Returns the column number of the coordinates. Column numbers are
   * zero-indexed and increase going right across the board.
   *
   * @return the column number
   */
  public int getCol() {
    return col;
  }

  /**
   * Compares two coordinates for equality.
   *
   * @param o the object to compare this to
   * @return {@code true} if the two coordinates are equal
   */
  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Coordinates that = (Coordinates) o;
    return row == that.row && col == that.col;
  }

  @Override
  public int hashCode() {
    return Objects.hash(row, col);
  }

  @Override
  public String toString() {
    return String.format("row %d, column %d", row, col);
  }

  /**
   * Returns a new Coordinates object that is offset from this one by the
   * given row and column differences.
   *
   * @param rowDiff the row offset
   * @param colDiff the column offset
   * @return a new Coordinates representing the offset position
   */
  public Coordinates plus(int rowDiff, int colDiff) {
    return new Coordinates(row + rowDiff, col + colDiff);
  }
}
