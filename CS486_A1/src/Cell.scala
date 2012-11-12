class Cell(valuec : Int, domainc : List[Int] = List()) extends Cloneable {
  var value = valuec
  var domain = domainc
  var x = -1
  var y = -1

  def isSet : Boolean = value != 0
  def isSettable : Boolean = domain.length > 0

  def setCoordinates(x : Int, y : Int) {
    this.x = x
    this.y = y
  }

  override def toString = "[" + x + ", " + y + "]"

  override def clone() = {
    val returnCell = Cell(value, domain)
    returnCell.x = x
    returnCell.y = y

    returnCell
  }
}

object Cell {
  def apply(value : Int, domain : List[Int] = List()) = new Cell(value, domain)
}
