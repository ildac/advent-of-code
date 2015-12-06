import scala.io._
import scala.collection.Iterator
import scala.annotation.tailrec

val input:BufferedSource = Source.fromFile("input")
var inputs = input.duplicate

def calculateFloor(floor:Int, a:Char):Int =
  {
    if (a == ')') { floor - 1 }
    else if (a == '(') { floor + 1 }
    else floor
  }

val totalFloor = inputs._1.foldLeft(0)(calculateFloor)

println(totalFloor)

// part two
val i = inputs._2.zipWithIndex

@tailrec
def calculateBasementPosition(indications:Iterator[(Char,Int)], actualFloor:Int = 0, index:Int = 0): Int = {
  if (!indications.hasNext) actualFloor
  else if (actualFloor == -1) index + 1
  else {
    val indication = indications.next
    if (indication._1 == ')') calculateBasementPosition(indications, actualFloor-1, indication._2)
    else if (indication._1 == '(') calculateBasementPosition(indications, actualFloor + 1, indication._2)
    else calculateBasementPosition(indications, actualFloor, indication._2)
  }
}

println(calculateBasementPosition(i))

input.close
