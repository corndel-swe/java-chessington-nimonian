package com.corndel.chessington.model;

import com.corndel.chessington.model.pieces.*;

public class Board {

  public static final int BOARD_SIZE = 8;

  private Piece[][] board = new Piece[BOARD_SIZE][BOARD_SIZE];

  private Board() {
  }

  /**
   * Creates a new board with the starting positions of a game of chess.
   * <p>
   * The back row of each player is populated with all the pieces, and the
   * front row is populated with pawns.
   * <p>
   * The board is returned in an immutable state.
   *
   * @return a new board with the starting positions of a game of chess
   */
  public static Board forNewGame() {
    Board board = new Board();
    board.setBackRow(0, PlayerColour.BLACK);
    board.setBackRow(7, PlayerColour.WHITE);

    for (int col = 0; col < BOARD_SIZE; col++) {
      board.board[1][col] = new Pawn(PlayerColour.BLACK);
      board.board[6][col] = new Pawn(PlayerColour.WHITE);
    }

    return board;
  }

  /**
   * Returns the state of the board.
   *
   * @return a two dimensional array of pieces, where the first index is the row
   *         and the second index is the column. The top left is [0][0] and the
   *         bottom right is [7][7].
   */
  public Piece[][] getBoard() {
    return board;
  }

  /**
   * Returns an empty board.
   *
   * @return an empty board
   */
  public static Board empty() {
    return new Board();
  }

  /**
   * Sets the back row of a board with the pieces in the order:
   * Rook, Knight, Bishop, Queen, King, Bishop, Knight, Rook.
   *
   * @param rowIndex the index of the row to set (0 or 7)
   * @param colour   the colour of the pieces to set
   */
  private void setBackRow(int rowIndex, PlayerColour colour) {
    board[rowIndex][0] = new Rook(colour);
    board[rowIndex][1] = new Knight(colour);
    board[rowIndex][2] = new Bishop(colour);
    board[rowIndex][3] = new Queen(colour);
    board[rowIndex][4] = new King(colour);
    board[rowIndex][5] = new Bishop(colour);
    board[rowIndex][6] = new Knight(colour);
    board[rowIndex][7] = new Rook(colour);
  }

  /**
   * Returns the piece at the given coordinates.
   *
   * @param coords the coordinates of the piece to retrieve
   * @return the piece at the given coordinates, or null if there is no piece
   */
  public Piece get(Coordinates coords) {
    return board[coords.getRow()][coords.getCol()];
  }

  /**
   * Moves a piece from one set of coordinates to another.
   *
   * @param from the coordinates of the piece to move
   * @param to   the coordinates of the destination square
   */
  public void move(Coordinates from, Coordinates to) {
    Piece piece = board[from.getRow()][from.getCol()];
    board[to.getRow()][to.getCol()] = piece;
    board[from.getRow()][from.getCol()] = null;
  }

  /**
   * Places a piece at the given coordinates, overwriting any existing piece.
   *
   * @param coords the coordinates to place the piece at
   * @param piece  the piece to place
   */
  public void placePiece(Coordinates coords, Piece piece) {
    board[coords.getRow()][coords.getCol()] = piece;
  }
}
