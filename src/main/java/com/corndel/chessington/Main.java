package com.corndel.chessington;

import com.corndel.chessington.model.Board;
import com.corndel.chessington.model.Coordinates;
import com.corndel.chessington.model.Game;
import com.corndel.chessington.model.Move;
import io.javalin.Javalin;
import io.javalin.http.ContentType;
import io.javalin.http.staticfiles.Location;

public class Main {
  private static final int PORT = 8173;

  public static void main(String[] args) {
    var board = Board.forNewGame();
    var game = new Game(board);
    var app = Javalin.create(config -> config.staticFiles.add("/static", Location.CLASSPATH));

    app.get(
        "/",
        ctx -> {
          ctx.contentType(ContentType.TEXT_HTML);
          ctx.result(Main.class.getResourceAsStream("/html/index.html"));
        });

    app.get("/board-data", ctx -> ctx.json(game));

    app.post(
        "/select-piece",
        ctx -> {
          var selectedSquare = ctx.bodyAsClass(Coordinates.class);
          var allowedMoves = game.getAllowedMoves(selectedSquare).stream().map(move -> move.getTo()).toList();

          ctx.json(allowedMoves);
        });

    app.post(
        "/move-piece",
        ctx -> {
          var move = ctx.bodyAsClass(Move.class);
          game.makeMove(move);

          ctx.json(game);
        });

    app.start(PORT);
  }
}
