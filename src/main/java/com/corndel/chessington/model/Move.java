package com.corndel.chessington.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

public final class Move {
  private final Coordinates from;
  private final Coordinates to;

  public Move(
      @JsonProperty("from_square") Coordinates from,
      @JsonProperty("target_square") Coordinates to) {
    this.from = from;
    this.to = to;
  }

  /**
   * Returns the coordinates of the square that the piece is moving from.
   *
   * @return the coordinates of the "from" square
   */
  public Coordinates getFrom() {
    return from;
  }

  /**
   * Returns the coordinates of the square that the piece is moving to.
   *
   * @return the coordinates of the "to" square
   */
  public Coordinates getTo() {
    return to;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Move move = (Move) o;
    return Objects.equals(from, move.from) && Objects.equals(to, move.to);
  }

  @Override
  public int hashCode() {
    return Objects.hash(from, to);
  }

  @Override
  public String toString() {
    return "from " + from + " to " + to;
  }
}
