package day01

import scala.io.Source

object Part1 {

  def getResult(): Int = {
    val inputFile = Source.fromFile("src/main/scala/day01/input/input.txt");
    var previous = 0;
    var increases = 0;
    var isFirst = true;

    for(line <- inputFile.getLines()) {
      val currentDepth = line.toInt;
      if (!isFirst && previous < currentDepth) {
        increases += 1;
      }
      isFirst = false;
      previous = currentDepth;
    }
    increases
  }

  def main(args: Array[String]): Unit = {

    print(getResult() + " measurements that are larger than the previous measurement")
  }

}
