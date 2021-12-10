package day02

import scala.io.Source

object Part1 {

  def getResult(): Int = {
    val inputFile = Source.fromFile("src/main/scala/day02/input/input.txt");
    val lines = inputFile.getLines().toList;
    val forward = lines.filter(line => line.contains("forward")).map(forwardCommand => forwardCommand.split(' ').last.toInt);
    val down = lines.filter(line => line.contains("down")).map(downCommand => downCommand.split(' ').last.toInt);
    val up = lines.filter(line => line.contains("up")).map(upCommand => upCommand.split(' ').last.toInt);

    val horizontal = forward.sum;
    val vertical = down.sum - up.sum;
    horizontal * vertical;
  }

  def main(args: Array[String]): Unit = {
    print("Result: " + getResult());
  }

}
