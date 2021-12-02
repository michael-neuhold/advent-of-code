package day2

import scala.io.Source

object Part2 {

  def main(args: Array[String]): Unit = {
    val inputFile = Source.fromFile("src/main/scala/day2/input/input.txt");
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

    val result = horizontal * depth;
    println("Horizontal: " + horizontal);
    println("Depth: " + depth);
    print("Result: " + result);

  }

}
