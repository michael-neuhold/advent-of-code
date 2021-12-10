package day08

import scala.io.Source

object Part1 {

  def getResult(): Int = {
    val inputFile = Source.fromFile("src/main/scala/day08/input/input.txt");
    val easyDigits = List(2,3,4,7);
    val input = inputFile
      .getLines()
      .toList.map(line => line.split(" \\| " ))
      .map(lineSplit =>
        List(
          lineSplit(0).split(' ').map(combination => combination.trim).toList,
          lineSplit(1).split(' ').map(combination => combination.trim).toList
        )
      );
    inputFile.close();
    input.map(line => line(1).count(value => easyDigits.contains(value.length))).sum;
  }

  def main(args: Array[String]): Unit = {
    println("result: " + getResult());
  }

}
