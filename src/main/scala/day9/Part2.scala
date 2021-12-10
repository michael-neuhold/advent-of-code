package day9

import day9.shared.Util.{getNeighbors, isLowestPointInNeighborhood}

import scala.io.Source

object Part2 {

  def expandPosition(matrix: List[List[Int]], currentPositionX: Int, currentPositionY: Int, basin: Set[(Int, Int)]): List[(Int, Int)] = {
    getNeighbors(matrix, currentPositionX, currentPositionY)
      .filter(position =>
        !basin.contains(position) &&
        matrix(position._2)(position._1) > matrix(currentPositionY)(currentPositionX) &&
        matrix(position._2)(position._1) < 9)
  }

  def getBasinSizeOf(matrix: List[List[Int]], position: (Int, Int), basin: Set[(Int, Int)]): Set[(Int, Int)] = {
    val neighborhoodToCheck = expandPosition(matrix, position._1,position._2, basin);
    val newBasin = basin + position;
    neighborhoodToCheck.size match {
      case 0 => newBasin
      case _ => newBasin ++ neighborhoodToCheck.flatMap(check => getBasinSizeOf(matrix, check, newBasin))
    }
  }

  def main(args: Array[String]): Unit = {
    val inputFile = Source.fromFile("src/main/scala/day9/input/input.txt");
    val matrix = inputFile.getLines().toList.map(line => line.split("").toList.map(ch => ch.toInt))

    val lowestPoints = matrix.head.indices.flatMap(xPosition => matrix.indices
      .filter(yPosition => isLowestPointInNeighborhood(matrix, xPosition, yPosition)).map(yPos => (xPosition, yPos)))

    val basinSizes = lowestPoints.map(pos => getBasinSizeOf(matrix, pos, Set[(Int, Int)]()));
    println("result = " + basinSizes.map(basin => basin.size).map(i => i.toLong).sorted(Ordering[Long].reverse).take(3).product)
    inputFile.close();
  }

}
