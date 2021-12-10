package day09

import day09.shared.Util.{isLowestPointInNeighborhood}

import scala.io.Source

object Part1 {

  def getResult(): Int = {
    val inputFile = Source.fromFile("src/main/scala/day09/input/input.txt");
    val matrix = inputFile.getLines().toList.map(line => line.split("").toList.map(ch => ch.toInt))

    matrix.head.indices.flatMap(xPosition => matrix.indices
      .filter(yPosition =>
        isLowestPointInNeighborhood(matrix, xPosition, yPosition))
      .map(yPos => matrix(yPos)(xPosition))).map(number => number + 1).sum
  }

  def main(args: Array[String]): Unit = {
    println("result = " + getResult())
  }

}
