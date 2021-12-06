package day6

import day6.shared.Util.simulateLanternfish

import scala.collection.mutable.ListBuffer
import scala.io.Source

object Part2 {

  def main(args: Array[String]): Unit = {
    val inputFile = Source.fromFile("src/main/scala/day6/input/input.txt");
    val internalTimers = new ListBuffer[Int];
    for (line <- inputFile.getLines())
      line.split(",").map(ch => internalTimers += ch.toInt)

    println("result: " + simulateLanternfish(internalTimers.toList, 256))
    inputFile.close();
  }

}