package day07

import scala.io.Source

object Part1 {

  def main(args: Array[String]): Unit = {
    val inputFile = Source.fromFile("src/main/scala/day7/input/input.txt");
    val input = inputFile.getLines().toList.head.split(',').map(ch => ch.toInt).toList;
    val result = input.map(horizontalPosition1 => input.map(horizontalPosition2 => Math.abs(horizontalPosition2 - horizontalPosition1)).sum).min;
    println("result: " + result);
    inputFile.close();
  }

}
