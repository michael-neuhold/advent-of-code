package day01

import scala.io.Source

object Part1 {

  def main(args: Array[String]): Unit = {
    val inputFile = Source.fromFile("src/main/scala/day1/input/input.txt");
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
    print(increases + " measurements that are larger than the previous measurement")
  }

}
