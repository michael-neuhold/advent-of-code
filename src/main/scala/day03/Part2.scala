package day03

import scala.io.Source

object Part2 {

  def calculateRating(numbers: List[List[Char]],
                                condition: (List[List[Char]], List[List[Char]]) => List[List[Char]]):
  List[List[Char]] = {
    var currentNumbers = numbers;
    for (position <- numbers.head.indices) {
      val groupedBinaryNumbers = currentNumbers.groupBy(number => number(position));
      val zeroGroup = groupedBinaryNumbers.filter(entry => entry._1 == '0').flatMap(entry => entry._2);
      val oneGroup = groupedBinaryNumbers.filter(entry => entry._1 == '1').flatMap(entry => entry._2);
      currentNumbers = condition(zeroGroup.toList, oneGroup.toList);
      if (currentNumbers.size == 1) return currentNumbers;
    }
    currentNumbers;
  }

  def getResult(): Int = {
    val inputFile = Source.fromFile("src/main/scala/day03/input/input.txt");
    val numbers = inputFile.getLines().toList.map(line => line.toList);

    val oxygenGeneratorRating =
      calculateRating(
        numbers,
        (zeroGroup, oneGroup) => {
          if (zeroGroup.size < oneGroup.size || oneGroup.size == zeroGroup.size) oneGroup
          else zeroGroup
        }
      ).head;

    val co2ScrubberRating =
      calculateRating(
        numbers,
        (zeroGroup, oneGroup) => {
          if (zeroGroup.size < oneGroup.size || oneGroup.size == zeroGroup.size) zeroGroup
          else oneGroup
        }
      ).head;

    inputFile.close();
    Integer.parseInt(oxygenGeneratorRating.mkString(""), 2) * Integer.parseInt(co2ScrubberRating.mkString(""), 2);
  }

  def main(args: Array[String]): Unit = {
    println("lifeSupportRating: " + getResult());
  }

}
