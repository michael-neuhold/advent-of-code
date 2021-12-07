package day7

import scala.io.Source

object Part2 {

  def main(args: Array[String]): Unit = {
    val inputFile = Source.fromFile("src/main/scala/day7/input/input.txt");
    val input = inputFile.getLines().toList.head.split(',').map(ch => ch.toInt).toList;
    val result =
      input.map(horizontalPosition1 =>
        input.map(horizontalPosition2 =>
          Math.abs(horizontalPosition2 - horizontalPosition1)
        ).map(number => Array.range(1, number + 1).sum).sum).min;

    println("result: " + result)
  }

}
