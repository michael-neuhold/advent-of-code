package day03

import scala.collection.mutable.ListBuffer
import scala.io.Source

object Part1 {

  def getResult(): Int = {
    val inputFile = Source.fromFile("src/main/scala/day03/input/input.txt");
    val numbers = inputFile.getLines().toList.map(line => line.toList);

    val gamma_rate = ListBuffer[Int]();
    for (position <- numbers.head.indices) {
      val zeroGroup = numbers.filter(number => number(position) == '0');
      val oneGroup = numbers.filter(number => number(position) == '1');
      if (zeroGroup.size < oneGroup.size) gamma_rate += 1;
      else gamma_rate += 0;
    }
    val epsilonRate = gamma_rate.map(bit => if (bit == 1) 0 else 1);
    inputFile.close();
    Integer.parseInt(gamma_rate.mkString(""), 2) * Integer.parseInt(epsilonRate.mkString(""), 2);
  }

  def main(args: Array[String]): Unit = {
    println("power consumption: " + getResult());
  }

}
