package day2

import scala.io.Source

object Part1 {

  def main(args: Array[String]): Unit = {
    val inputFile = Source.fromFile("src/main/scala/day2/input/input.txt");
    val lines = inputFile.getLines().toList;
    val forward = lines.filter(line => line.contains("forward")).map(forwardCommand => forwardCommand.split(' ').last.toInt);
    val down = lines.filter(line => line.contains("down")).map(downCommand => downCommand.split(' ').last.toInt);
    val up = lines.filter(line => line.contains("up")).map(upCommand => upCommand.split(' ').last.toInt);

    val horizontal = forward.sum;
    val vertical = down.sum - up.sum;
    val result = horizontal * vertical;
    println("Horizontal: " + horizontal);
    println("Vertical: " + vertical);
    print("Result: " + result);
  }

}
