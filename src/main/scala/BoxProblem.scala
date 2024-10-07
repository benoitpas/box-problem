case class Cell(col: Int, row: Int)

object BoxProblem {
  def solve(nbCol: Int, nbRow: Int) = (0, 0, 1)

  def generateCombinations(nbCol: Int, nbRow: Int): List[(Cell, Cell)] =
    val oneCell = (for
      col <- 1 to nbCol
      row <- 1 to nbRow
    yield Cell(col, row)).toList

    for
      c1 <- oneCell
      c2 <- oneCell
    yield (c1, c2)
}
