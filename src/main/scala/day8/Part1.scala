package day8

import scala.io.Source

object Part1 {

  def main(args: Array[String]): Unit = {
    val inputFile = Source.fromFile("src/main/scala/day8/input/input.txt");
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
    val result = input.map(line => line(1).count(value => easyDigits.contains(value.length))).sum;
    println("result: " + result);
    inputFile.close();
  }

}
