package day10

import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.io.Source
import scala.util.control.Breaks.{break, breakable}

object Part2 {

  def main(args: Array[String]): Unit = {
    val inputFile = Source.fromFile("src/main/scala/day10/input/input.txt");
    val lines = inputFile.getLines().map(line => line.split("").map(str => str.head).toList)

    var errorList = ListBuffer[Long]();
    var error = 0;

    lines.foreach(line => {
      val syntaxStack = mutable.Stack[Char]()
      var invalidLine = false
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
              case ')' => error += 3; invalidLine = true; break;
              case '>' => error += 25137; invalidLine = true; break;
              case '}' => error += 1197; invalidLine = true; break;
              case ']' => error += 57; invalidLine = true; break;
            }
          }
        }
      })
      if (syntaxStack.nonEmpty && !invalidLine) {
        var score = 0L;
        while(syntaxStack.nonEmpty) {
          val topCh = syntaxStack.pop();
          score *= 5;
          topCh match {
            case '(' => score += 1
            case '<' => score += 4
            case '[' => score += 2
            case '{' => score += 3
          }
        }
        errorList = errorList.appended(score)
      }
    })

    val sorted =  errorList.sorted;
    println("result part 1 = " + error)
    println("result part 2 = " + sorted(errorList.size / 2));
  }

}
