package com.corndel.chessington.model;

import com.corndel.chessington.model.pieces.Piece;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

public class Game {
  private final Board board;

  private PlayerColour currentPlayer = PlayerColour.WHITE;

  private boolean isEnded = false;

  public Game(Board board) {
    this.board = board;
  }

  /**
   * Returns the piece at the given coordinates on the board.
   *
   * @param row the row number of the piece to retrieve
   * @param col the column number of the piece to retrieve
   * @return the piece at the given coordinates, or null if there is no piece
   */
  public Piece pieceAt(int row, int col) {
    return board.get(new Coordinates(row, col));
  }

  /**
   * Returns all the allowed moves for the piece at the given coordinates.
   * <p>
   * If the game has ended, or there is no piece at the given coordinates, or the
   * piece at the given coordinates is not of the current player, an empty list is
   * returned.
   *
   * @param from the coordinates of the piece to retrieve allowed moves for
   * @return a list of all the allowed moves for the piece at the given
   *         coordinates,
   *         or an empty list if there is no piece, or the game has ended
   */
  @JsonIgnore
  public List<Move> getAllowedMoves(Coordinates from) {
    if (isEnded) {
      return new ArrayList<>();
    }

    Piece piece = board.get(from);
    if (piece == null || piece.getColour() != currentPlayer) {
      return new ArrayList<>();
    }

    return piece.getAllowedMoves(from, board);
  }

  /**
   * Makes a move on the board.
   * <p>
   * This method first checks to see if the game has ended. If it has, an
   * {@link InvalidMoveException} is thrown.
   * <p>
   * If the move is valid, the piece is moved from the start coordinates to the
   * end coordinates, and the current player is switched.
   *
   * @param move the move to be made
   * @throws InvalidMoveException if the move is invalid
   */
  public void makeMove(Move move) throws InvalidMoveException {
    if (isEnded) {
      throw new InvalidMoveException("Game has ended!");
    }

    Coordinates from = move.getFrom();
    Coordinates to = move.getTo();

    Piece piece = board.get(from);
    if (piece == null) {
      throw new InvalidMoveException(String.format("No piece at %s", from));
    }

    if (piece.getColour() != currentPlayer) {
      throw new InvalidMoveException(
          String.format("Wrong colour piece - it is %s's turn", currentPlayer));
    }

    if (!piece.getAllowedMoves(move.getFrom(), board).contains(move)) {
      throw new InvalidMoveException(
          String.format("Cannot move piece %s from %s to %s", piece, from, to));
    }

    board.move(from, to);
    currentPlayer = currentPlayer.getOpposite();
  }

  /**
   * Returns whether the game has ended.
   * <p>
   * If the game has ended, {@link #getResult()} can be used to find out the
   * result of the game.
   *
   * @return whether the game has ended
   */
  @JsonIgnore
  public boolean isEnded() {
    return isEnded;
  }

  /**
   * Returns the result of the game, if it has ended.
   * <p>
   * If the game has not ended, this method returns null.
   * <p>
   * The result is a string that is either "white-wins", "black-wins", or "draw".
   *
   * @return the result of the game, or null if the game has not ended
   */
  @JsonIgnore
  public String getResult() {
    return null;
  }

  /**
   * Returns the state of the board as a two dimensional array of pieces, where
   * the first index is the row
   * and the second index is the column. The top left is [0][0] and the bottom
   * right is [7][7].
   * <p>
   * The board is returned in its current state, which may have changed since the
   * game started.
   *
   * @return a two dimensional array of pieces, representing the current state of
   *         the board
   */
  @JsonProperty("board_pieces")
  public Piece[][] getBoardPieces() {
    return board.getBoard();
  }

  /**
   * Returns the current player.
   *
   * @return the current player
   */
  @JsonProperty("current_player")
  public PlayerColour getCurrentPlayer() {
    return currentPlayer;
  }
}
