package day10

import scala.collection.mutable
import scala.io.Source
import scala.util.control.Breaks.{break, breakable}

object Part1 {

  def getResult(): Int = {
    val inputFile = Source.fromFile("src/main/scala/day10/input/input.txt");
    val lines = inputFile.getLines().map(line => line.split("").map(str => str.head).toList)

    var error = 0;

    lines.foreach(line => {
      val syntaxStack = mutable.Stack[Char]()
      line.foreach(ch => {
        breakable {
          if (Set('(', '<', '[', '{').contains(ch)) {
            syntaxStack.push(ch)
          } else {
            val topCh = syntaxStack.pop()
            ch match {
              case ')' if (topCh == '(') =>
              case '>' if (topCh == '<') =>
              case '}' if (topCh == '{') =>
              case ']' if (topCh == '[') =>
              case ')' => error += 3; break;
              case '>' => error += 25137; break;
              case '}' => error += 1197; break;
              case ']' => error += 57; break;
            }
          }
        }
      })
    })
    error
  }

  def main(args: Array[String]): Unit = {
    println("result part 1 = " + getResult())
  }

}
