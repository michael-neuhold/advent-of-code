package day5.shared

import day5.{Coordinate, Line}

import scala.collection.mutable.ListBuffer
import scala.io.Source

object Util {

  def getLinesToDraw: ListBuffer[Line] = {
    val inputFile = Source.fromFile("src/main/scala/day5/input/input.txt");
    val linesToDraw = new ListBuffer[Line];
    for (line <- inputFile.getLines()) {
      val parts = line.split("->");
      val startParts = parts(0).split(",");
      val endParts = parts(1).split(",");
      val startCoordinates = Coordinate(startParts(0).trim.toInt, startParts(1).trim.toInt);
      val endCoordinates = Coordinate(endParts(0).trim.toInt, endParts(1).trim.toInt);
      linesToDraw += Line(startCoordinates, endCoordinates);
    }
    inputFile.close();
    linesToDraw;
  }

}
