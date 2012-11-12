import scala.Array

object SudokuSolver {
  var nodesEncountered : List[Cell] = List()

  def addEncounteredNode(cell: Cell) {
    nodesEncountered = cell :: nodesEncountered
  }

  def cloneConfiguration(configuration : Array[Array[Cell]]) : Array[Array[Cell]] = {
    val clonedConfig = new Array[Array[Cell]](9, 9)

    for(y <- 0 to 8; x <- 0 to 8){
      clonedConfig(y)(x) = configuration(y)(x).clone()
    }

    clonedConfig
  }

  //Returns True if domain is still non-empty. False if there are no more potential values to set.
  def setNewDomains(unassignedCells : List[Cell], configuration : Array[Array[Cell]]) : (Boolean, Int) = {
    var domainSizeDifference = 0

    for(cell <- unassignedCells) {
      val x = cell.x
      val y = cell.y

      //Get values used in row
      val usedValuesInRow = (for (v <- configuration(y)) yield v.value).toList

      //Get values used in column
      val usedValuesInColumn = (for (row <- configuration) yield row(x).value).toList

      //Get values used in square
      val usedValuesInSquare = {
        val xOffset = x match {
          case z if 0 to 2 contains z => 0
          case z if 3 to 5 contains z => 3
          case _ => 6
        }
        val yOffset = y match {
          case z if 0 to 2 contains z => 0
          case z if 3 to 5 contains z => 3
          case _ => 6
        }

        (
          configuration(yOffset)(xOffset)     :: configuration(yOffset)(xOffset + 1)     :: configuration(yOffset)(xOffset + 2)     ::
          configuration(yOffset + 1)(xOffset) :: configuration(yOffset + 1)(xOffset + 1) :: configuration(yOffset + 1)(xOffset + 2) ::
          configuration(yOffset + 2)(xOffset) :: configuration(yOffset + 2)(xOffset + 1) :: configuration(yOffset + 2)(xOffset + 2) :: List()
        ).map(_.value)
      }

      val usedValues = ((usedValuesInRow union usedValuesInColumn union usedValuesInSquare) filterNot(_ == 0)).distinct

      val previousDomainSize = cell.domain.size
      cell.domain = (1 to 9).filterNot(usedValues.contains(_)).toList

      domainSizeDifference = domainSizeDifference + (previousDomainSize - cell.domain.size)

      if(cell.domain.isEmpty)
        return (false, domainSizeDifference)
    }

    return (true, domainSizeDifference)
  }
}

class SudokuSolver {
  def solve(puzzle : Array[Array[Cell]]) {

    var unassignedCells : List[Cell] = List()

    //Assign coordinates and find empty cells
    for (y <- 0 to 8; x <- 0 to 8) {
      val cell = puzzle(y)(x)
      cell.setCoordinates(x, y)

      if (cell.value == 0) {
        unassignedCells = cell :: unassignedCells
      }
    }

    //Initialize domains for all empty cells
    SudokuSolver.setNewDomains(unassignedCells, puzzle)

    val (returnStatus, config) = solveHelper(unassignedCells, puzzle)

    if (!returnStatus)
      println("Failure")

    for(row <- config) {
      println((for(cell <- row) yield cell.value).grouped(3).map(_.mkString(" ")).mkString(" | "))
    }

    println("Nodes encountered: " + SudokuSolver.nodesEncountered.length)
  }

  private def solveHelper(unassignedCells : List[Cell], configuration : Array[Array[Cell]]) : (Boolean, Array[Array[Cell]]) = {

    if (unassignedCells.isEmpty)
      return (true, configuration)

    //Forward-checking
    if(unassignedCells.exists(_.domain.isEmpty))
      return (false, configuration)

    //var originalConfiguration = SudokuSolver.cloneConfiguration(configuration)

    //Most-constrained-variable heuristic
    val groupedCells = unassignedCells.groupBy(_.domain.size).toList

    //Most-constraining-variable heuristic
    groupedCells.foreach(_._2.sortWith((c1, c2) => {

      def numCellsAffected(c : Cell) = {
        unassignedCells.count(cell => {
          cell.x == c.x || //Column
          cell.y == c.y || //Row
          (cell.x / 3 == c.x / 3 && cell.y / 3 == c.y / 3) //Square
        })
      }

      numCellsAffected(c1) > numCellsAffected(c2)
    }))

    //Most-constrained-variable heuristic
    val heuristicizedCells = groupedCells.sortWith((t1, t2) => t1._1 < t2._1).map(_._2).flatten

    val (cellToAssign, cellsLeftToAssign) = (heuristicizedCells.head.clone(), heuristicizedCells.tail.map(_.clone()))

    //Increment a counter of nodes encountered
    SudokuSolver.addEncounteredNode(cellToAssign)

    //Least-constraining-value heuristic
    cellToAssign.domain.sortWith((d1, d2) => {
      def numDomainValuesAltered(v : Int) = {
        val cellsCopy = cellsLeftToAssign.map(_.clone())
        configuration(cellToAssign.y)(cellToAssign.x).value = v
        val domainValuesAltered = SudokuSolver.setNewDomains(cellsCopy, configuration)._2
        configuration(cellToAssign.y)(cellToAssign.x).value = 0

        domainValuesAltered
      }

      numDomainValuesAltered(d1) < numDomainValuesAltered(d2)
    })

    for (d <- cellToAssign.domain) {
      configuration(cellToAssign.y)(cellToAssign.x).value = d

      //Everything is OK, new domains have been set, no new domains are empty
      //Forward-checking
      if(SudokuSolver.setNewDomains(cellsLeftToAssign, configuration)._1) {
        //Solve recursively, return true if recursive call succeeds in finding a solution, continue with other values otherwise, as per backtracking strategy
        solveHelper(cellsLeftToAssign, configuration) match {
          case (true, config) => return (true, config)
          case (false, _) =>
        }
      }

      configuration(cellToAssign.y)(cellToAssign.x).value = 0
    }

    (false, configuration)
  }
}
