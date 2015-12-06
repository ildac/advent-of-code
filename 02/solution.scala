import scala.io.{BufferedSource, Source}
import scala.collection.Iterator
import scala.annotation.tailrec

var input:BufferedSource = Source.fromFile("./02/input")

def calculatePaperArea(length:Int, width:Int, height:Int): Int = {
  2 * length * width + 2 * width * height + 2 * height * length
}

def calculateExtraPaper(length:Int, width:Int, height:Int): Int = {
  val dimension = List(length, width, height).sorted
  dimension(0) * dimension(1)
}

@tailrec
def calculateTotalPaper(dimensions:Iterator[String], total:Int = 0): Int = {
  if (!dimensions.hasNext) total
  else {
    val dimension = dimensions.next.split("x")
    val paperArea = calculatePaperArea(
      dimension(0).toInt, dimension(1).toInt, dimension(2).toInt
    )
    val extraPaper = calculateExtraPaper(
      dimension(0).toInt, dimension(1).toInt, dimension(2).toInt
    )
    calculateTotalPaper(dimensions, total + paperArea + extraPaper)
  }
}

print("Paper area: ")
println(calculateTotalPaper(input.getLines))
input.close

input = Source.fromFile("./02/input")

def calculateRibbonForWrapping(dimension:Array[Int]): Int = {
  val d = dimension.sorted
  2 * d(0) + 2 * d(1)
}

def calculateRibbonForBow(dimension:Array[Int]): Int = {
  dimension.foldLeft(1)((total, d) => total*d)
}

@tailrec
def calculateTotalRibbon(dimensions:Iterator[String], total:Int = 0): Int = {
  if (!dimensions.hasNext) {
    total
  } else {
    val dimension = dimensions.next.split("x").map(d => d.toInt)
    val wrappingRibbonLength = calculateRibbonForWrapping(dimension)
    val bowRibbonLength = calculateRibbonForBow(dimension)
    calculateTotalRibbon(dimensions, total + wrappingRibbonLength + bowRibbonLength)
  }
}

print("Ribbon length: ")
println(calculateTotalRibbon(input.getLines))

input.close
