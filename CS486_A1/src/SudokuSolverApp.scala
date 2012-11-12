
object SudokuSolverApp extends App {
  val solver = new SudokuSolver
  println("Easy: ")
  var startTime = System.currentTimeMillis()
  solver.solve(SudokuProblems.easyProblem)
  println("Execution time: " + (System.currentTimeMillis()-startTime) + "ms")
  println("Medium: ")
  startTime = System.currentTimeMillis()
  solver.solve(SudokuProblems.mediumProblem)
  println("Execution time: " + (System.currentTimeMillis()-startTime) + "ms")
  println("Difficult: ")
  startTime = System.currentTimeMillis()
  solver.solve(SudokuProblems.difficultProblem)
  println("Execution time: " + (System.currentTimeMillis()-startTime) + "ms")
  println("Evil: ")
  startTime = System.currentTimeMillis()
  solver.solve(SudokuProblems.evilProblem)
  println("Execution time: " + (System.currentTimeMillis()-startTime) + "ms")
}
