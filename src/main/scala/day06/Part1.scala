package day06

import day06.shared.Util.simulateLanternfish

import scala.collection.mutable.ListBuffer
import scala.io.Source

object Part1 {

  def main(args: Array[String]): Unit = {
    val inputFile = Source.fromFile("src/main/scala/day6/input/input.txt");
    val internalTimers = new ListBuffer[Int];
    for (line <- inputFile.getLines())
      line.split(",").map(ch => internalTimers += ch.toInt)

    println("result: " + simulateLanternfish(internalTimers.toList, 80))
    inputFile.close();
  }

}
