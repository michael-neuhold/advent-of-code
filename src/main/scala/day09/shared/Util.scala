package day09.shared

object Util {

  def isLowestPointInNeighborhood(matrix: List[List[Int]], currentPositionX: Int, currentPositionY: Int) : Boolean =
    !getNeighbors(matrix, currentPositionX, currentPositionY)
      .exists(position =>
        matrix(position._2)(position._1) <= matrix(currentPositionY)(currentPositionX))

  def getNeighbors(matrix: List[List[Int]], currentPositionX: Int, currentPositionY: Int): List[(Int, Int)] = {
    Seq(
      (currentPositionX - 1, currentPositionY + 0), (currentPositionX + 0, currentPositionY - 1),
      (currentPositionX + 1, currentPositionY + 0), (currentPositionX + 0, currentPositionY + 1))
      .filter(position =>
        position._1 >= 0 &&
          position._2 >= 0 &&
          position._1 < matrix.head.length &&
          position._2 < matrix.length)
      .toList
  }

}
