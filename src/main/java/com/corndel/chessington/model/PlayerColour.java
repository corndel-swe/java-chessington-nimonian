package com.corndel.chessington.model;

public enum PlayerColour {
  WHITE,
  BLACK;

  /**
   * Returns the opposite of the current colour.
   *
   * @return the opposite {@link PlayerColour}
   */
  public PlayerColour getOpposite() {
    return this == WHITE ? BLACK : WHITE;
  }
}
