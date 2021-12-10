package day05

import day05.shared.Util.getLinesToDraw

object Part2 {

  def getResult(): Int = {
    val linesToDraw = getLinesToDraw
    val maxX = linesToDraw.map(line => if (line.start.x >= line.end.x) line.start.x else line.end.x).max;
    val maxY = linesToDraw.map(line => if (line.start.y >= line.end.y) line.start.y else line.end.y).max;
    val board = Array.ofDim[Int](maxY + 1, maxX + 1);

    for (lineToDraw <- linesToDraw) {
      if (lineToDraw.start.x == lineToDraw.end.x) {
        for (y <- lineToDraw.start.y to lineToDraw.end.y) board(y)(lineToDraw.start.x) += 1;
        for (y <- lineToDraw.end.y to lineToDraw.start.y) board(y)(lineToDraw.start.x) += 1;
      } else if (lineToDraw.start.y == lineToDraw.end.y) {
        for (x <- lineToDraw.start.x to lineToDraw.end.x) board(lineToDraw.start.y)(x) += 1;
        for (x <- lineToDraw.end.x to lineToDraw.start.x) board(lineToDraw.start.y)(x) += 1;
      } else if (lineToDraw.start.x < lineToDraw.end.x && lineToDraw.start.y < lineToDraw.end.y) { // left to right up
        var x = lineToDraw.start.x;
        var y = lineToDraw.start.y;
        while (x <= lineToDraw.end.x && y <= lineToDraw.end.y) { board(y)(x) += 1; x += 1; y += 1; }
      } else if (lineToDraw.start.x < lineToDraw.end.x && lineToDraw.start.y > lineToDraw.end.y) { // left to right down
        var x = lineToDraw.start.x;
        var y = lineToDraw.start.y;
        while (x <= lineToDraw.end.x && y >= lineToDraw.end.y) { board(y)(x) += 1; x += 1; y -= 1; }
      } else if (lineToDraw.start.x > lineToDraw.end.x && lineToDraw.start.y < lineToDraw.end.y) { // right to left down
        var x = lineToDraw.start.x;
        var y = lineToDraw.start.y;
        while (x >= lineToDraw.end.x && y <= lineToDraw.end.y) { board(y)(x) += 1; x -= 1; y += 1; }
      } else if (lineToDraw.start.x > lineToDraw.end.x && lineToDraw.start.y > lineToDraw.end.y) { // right to left up
        var x = lineToDraw.start.x;
        var y = lineToDraw.start.y;
        while (x >= lineToDraw.end.x && y >= lineToDraw.end.y) { board(y)(x) += 1; x -= 1; y -= 1; }
      }
    }

    board.map(row => row.count(number => number >= 2)).sum;
  }

  def main(args: Array[String]): Unit = {
    println("result: " + getResult());
  }

}
