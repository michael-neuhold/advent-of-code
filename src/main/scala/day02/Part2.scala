package day02

import scala.io.Source

object Part2 {

  def getResult(): Int = {
    val inputFile = Source.fromFile("src/main/scala/day02/input/input.txt");
    var aim = 0;
    var depth = 0;
    var horizontal = 0;
    for (line <- inputFile.getLines()) {
      val currentValue = line.split(' ').last.toInt
      if (line.contains("forward")) {
        horizontal += currentValue;
        depth += currentValue * aim;
      } else if (line.contains("down")) {
        aim += currentValue;
      } else if (line.contains("up")) {
        aim -= currentValue;
      }
    }

    horizontal * depth;
  }

  def main(args: Array[String]): Unit = {
    print("Result: " + getResult());
  }

}
