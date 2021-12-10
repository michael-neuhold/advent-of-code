package day02

import org.scalatest.FunSuite

class Day02Test extends FunSuite {

  test("Day02.Part1.getResult") {
    assert(Part1.getResult() === 1580000)
  }

  test("Day02.Part2.getResult") {
    assert(Part2.getResult() === 1251263225)
  }

}
