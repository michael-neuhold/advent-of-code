package day07

import scala.io.Source

object Part1 {

  def getResult(): Int = {
    val inputFile = Source.fromFile("src/main/scala/day07/input/input.txt");
    val input = inputFile.getLines().toList.head.split(',').map(ch => ch.toInt).toList;
    inputFile.close();
    input.map(horizontalPosition1 => input.map(horizontalPosition2 => Math.abs(horizontalPosition2 - horizontalPosition1)).sum).min;
  }

  def main(args: Array[String]): Unit = {
    println("result: " + getResult());
  }

}
