package day4

import day4.shared.Util.{getBoards, isBingo}

import scala.collection.mutable.ListBuffer
import scala.io.Source

object Part2 {

  def findLastSolution(numbersToCheck: Array[Int], boards: ListBuffer[List[List[Int]]]): Int = {
    val finishedBoards = ListBuffer[Int]();
    for (numberToCheck <- numbersToCheck) {
      for (i <- boards.indices) {
        if (!finishedBoards.contains(i)) {
          boards(i) =
            boards(i).map(row => row.map(currentNumber => if (currentNumber == numberToCheck) -1 else currentNumber));
          if (isBingo(boards(i))) {
            finishedBoards += i;
            val sum = boards(i).map(row => row.filter(number => number != -1).sum).sum;
            if (finishedBoards.size == boards.size) {
              return sum * numberToCheck;
            }
          }
        }
      }
    }
    throw new IllegalArgumentException("No solution found!");
  }

  def main(args: Array[String]): Unit = {
    val inputFile = Source.fromFile("src/main/scala/day4/input/input.txt");
    val lines = inputFile.getLines().toList;

    val numbersToCheck = lines.head.split(',').map(ch => ch.toInt);
    val boards = getBoards(lines);

    println("result: " + findLastSolution(numbersToCheck, boards));
    inputFile.close();
  }

}
