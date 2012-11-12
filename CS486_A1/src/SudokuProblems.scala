object SudokuProblems {

  lazy val easyProblem = Array(
    Array(Cell(9), Cell(0), Cell(4), Cell(0), Cell(0), Cell(0), Cell(0), Cell(5), Cell(8)),
    Array(Cell(0), Cell(0), Cell(0), Cell(1), Cell(0), Cell(0), Cell(0), Cell(9), Cell(7)),
    Array(Cell(0), Cell(0), Cell(1), Cell(8), Cell(0), Cell(0), Cell(4), Cell(0), Cell(6)),
    Array(Cell(0), Cell(0), Cell(0), Cell(6), Cell(0), Cell(0), Cell(0), Cell(4), Cell(0)),
    Array(Cell(0), Cell(5), Cell(0), Cell(4), Cell(0), Cell(9), Cell(0), Cell(1), Cell(0)),
    Array(Cell(0), Cell(9), Cell(0), Cell(0), Cell(0), Cell(1), Cell(0), Cell(0), Cell(0)),
    Array(Cell(5), Cell(0), Cell(6), Cell(0), Cell(0), Cell(4), Cell(3), Cell(0), Cell(0)),
    Array(Cell(3), Cell(4), Cell(0), Cell(0), Cell(0), Cell(8), Cell(0), Cell(0), Cell(0)),
    Array(Cell(7), Cell(8), Cell(0), Cell(0), Cell(0), Cell(0), Cell(9), Cell(0), Cell(4))
  )

  lazy val mediumProblem = Array(
    Array(Cell(0), Cell(0), Cell(5), Cell(0), Cell(2), Cell(0), Cell(0), Cell(0), Cell(4)),
    Array(Cell(0), Cell(0), Cell(0), Cell(9), Cell(0), Cell(1), Cell(0), Cell(0), Cell(6)),
    Array(Cell(9), Cell(4), Cell(0), Cell(0), Cell(7), Cell(0), Cell(0), Cell(2), Cell(0)),
    Array(Cell(4), Cell(8), Cell(0), Cell(7), Cell(0), Cell(0), Cell(0), Cell(9), Cell(3)),
    Array(Cell(0), Cell(0), Cell(0), Cell(0), Cell(0), Cell(0), Cell(0), Cell(0), Cell(0)),
    Array(Cell(7), Cell(5), Cell(0), Cell(0), Cell(0), Cell(4), Cell(0), Cell(1), Cell(8)),
    Array(Cell(0), Cell(3), Cell(0), Cell(0), Cell(1), Cell(0), Cell(0), Cell(5), Cell(9)),
    Array(Cell(5), Cell(0), Cell(0), Cell(2), Cell(0), Cell(8), Cell(0), Cell(0), Cell(0)),
    Array(Cell(6), Cell(0), Cell(0), Cell(0), Cell(5), Cell(0), Cell(3), Cell(0), Cell(0))
  )

  lazy val difficultProblem = Array(
    Array(Cell(2), Cell(0), Cell(0), Cell(9), Cell(0), Cell(4), Cell(0), Cell(0), Cell(0)),
    Array(Cell(3), Cell(4), Cell(6), Cell(0), Cell(8), Cell(0), Cell(0), Cell(0), Cell(0)),
    Array(Cell(9), Cell(0), Cell(0), Cell(3), Cell(6), Cell(2), Cell(0), Cell(0), Cell(0)),
    Array(Cell(0), Cell(0), Cell(3), Cell(0), Cell(0), Cell(0), Cell(0), Cell(5), Cell(0)),
    Array(Cell(8), Cell(0), Cell(5), Cell(0), Cell(0), Cell(0), Cell(1), Cell(0), Cell(9)),
    Array(Cell(0), Cell(6), Cell(0), Cell(0), Cell(0), Cell(0), Cell(3), Cell(0), Cell(0)),
    Array(Cell(0), Cell(0), Cell(0), Cell(2), Cell(1), Cell(9), Cell(0), Cell(0), Cell(6)),
    Array(Cell(0), Cell(0), Cell(0), Cell(0), Cell(4), Cell(0), Cell(9), Cell(3), Cell(8)),
    Array(Cell(0), Cell(0), Cell(0), Cell(8), Cell(0), Cell(7), Cell(0), Cell(0), Cell(2))
  )

  lazy val evilProblem = Array(
    Array(Cell(0), Cell(2), Cell(0), Cell(0), Cell(0), Cell(8), Cell(6), Cell(0), Cell(0)),
    Array(Cell(8), Cell(0), Cell(0), Cell(0), Cell(0), Cell(7), Cell(0), Cell(0), Cell(0)),
    Array(Cell(0), Cell(7), Cell(3), Cell(0), Cell(4), Cell(0), Cell(0), Cell(0), Cell(0)),
    Array(Cell(2), Cell(0), Cell(0), Cell(0), Cell(0), Cell(5), Cell(0), Cell(9), Cell(0)),
    Array(Cell(5), Cell(0), Cell(0), Cell(6), Cell(0), Cell(9), Cell(0), Cell(0), Cell(4)),
    Array(Cell(0), Cell(8), Cell(0), Cell(3), Cell(0), Cell(0), Cell(0), Cell(0), Cell(5)),
    Array(Cell(0), Cell(0), Cell(0), Cell(0), Cell(9), Cell(0), Cell(3), Cell(1), Cell(0)),
    Array(Cell(0), Cell(0), Cell(0), Cell(2), Cell(0), Cell(0), Cell(0), Cell(0), Cell(7)),
    Array(Cell(0), Cell(0), Cell(2), Cell(4), Cell(0), Cell(0), Cell(0), Cell(8), Cell(0))
  )
}
