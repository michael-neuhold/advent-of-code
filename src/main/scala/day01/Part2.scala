package day01

import scala.io.Source

object Part2 {

  def getResult(): Int = {
    val inputFile = Source.fromFile("src/main/scala/day01/input/input.txt");
    val measures = inputFile.getLines().toList.map(line => line.toInt);
    var previousWindow = measures(0) + measures(1)+ measures(2);
    var increases = 0;
    for (i <- 1 until measures.length - 2) {
      val currentWindow = measures(i) + measures(i + 1)+ measures(i + 2);
      if (previousWindow < currentWindow) {
        increases += 1;
      }
      previousWindow = currentWindow;
    }
    increases
  }

  def main(args: Array[String]): Unit = {
      print("There are " + getResult() + " sums that are larger than the previous sum.");
  }

}
