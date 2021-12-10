package day10

import org.scalatest.FunSuite

class Day10Test extends FunSuite {

  test("Day10.Part1.getResult") {
    assert(Part1.getResult() === 318081)
  }

  test("Day10.Part2.getResult") {
    assert(Part2.getResult() === 4361305341L)
  }

}
