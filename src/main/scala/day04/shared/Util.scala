package day04.shared

import scala.collection.mutable.ListBuffer

object Util {

  def isBingo(board: List[List[Int]]): Boolean = {
    val bingoInRow = board.exists(row => row.forall(number => number == -1));
    if (bingoInRow) return true;
    for (currentColumn <- 0 to 4) {
      var bingoInCurrentColumn = true;
      for (row <- board) {
        if (row(currentColumn) != -1) {
          bingoInCurrentColumn = false;
        }
      }
      if (bingoInCurrentColumn) return true;
    }
    false;
  }

  def getBoards(lines: List[String]): ListBuffer[List[List[Int]]] = {
    val boards = ListBuffer[List[List[Int]]]();
    for (i <- 2 until lines.size by 6) {
      val currentBoard = new ListBuffer[List[Int]]();
      for (lineInBoard <- i to i + 4) {
        currentBoard +=
          lines(lineInBoard)
            .replaceAll("^ +", "")
            .replaceAll(" +", " ")
            .split(" ")
            .toList.map(ch => ch.toInt);
      }
      boards += currentBoard.toList;
    }
    boards;
  }

}
