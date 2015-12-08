import scala.io.{BufferedSource, Source}
import scala.collection.Iterator
import scala.annotation.tailrec

var input:BufferedSource = Source.fromFile("./03/input")

class House {

  var numberOfGifts: Int

  var northernNeighbour: House
  var southernNeighbour: House
  var esaternNeighbour: House
  var westernNeighbour: House

}
