package day06

import day06.shared.Util.simulateLanternfish

import scala.collection.mutable.ListBuffer
import scala.io.Source

object Part2 {

  def getResult(): Long = {
    val inputFile = Source.fromFile("src/main/scala/day06/input/input.txt");
    val internalTimers = new ListBuffer[Int];
    for (line <- inputFile.getLines())
      line.split(",").map(ch => internalTimers += ch.toInt)
    inputFile.close();
    simulateLanternfish(internalTimers.toList, 256)
  }

  def main(args: Array[String]): Unit = {
    println("result: " + getResult())
  }

}