package day07

import scala.io.Source

object Part2 {

  def getResult(): Int = {
    val inputFile = Source.fromFile("src/main/scala/day07/input/input.txt");
    val input = inputFile.getLines().toList.head.split(',').map(ch => ch.toInt).toList;
    input.map(horizontalPosition1 =>
      input.map(horizontalPosition2 =>
        Math.abs(horizontalPosition2 - horizontalPosition1)
      ).map(number => Array.range(1, number + 1).sum).sum).min;
  }
  def main(args: Array[String]): Unit = {
    println("result: " + getResult())
  }

}
