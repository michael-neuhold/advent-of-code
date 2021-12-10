package day9

import day9.shared.Util.{isLowestPointInNeighborhood}

import scala.io.Source

object Part1 {

  def main(args: Array[String]): Unit = {
    val inputFile = Source.fromFile("src/main/scala/day9/input/input.txt");
    val matrix = inputFile.getLines().toList.map(line => line.split("").toList.map(ch => ch.toInt))

    val result = matrix.head.indices.flatMap(xPosition => matrix.indices
      .filter(yPosition =>
        isLowestPointInNeighborhood(matrix, xPosition, yPosition))
      .map(yPos => matrix(yPos)(xPosition))).map(number => number + 1).sum

    println("result = " + result)
  }

}
