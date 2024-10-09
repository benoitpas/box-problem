case class Cell(col: Int, row: Int)

object BoxProblem {
  def solve(nbCol: Int, nbRow: Int) = ???

  def generateCombinations(nbCol: Int, nbRow: Int): List[(Cell, Cell)] =
    val oneCell = (for
      col <- 1 to nbCol
      row <- 1 to nbRow
    yield Cell(col, row)).toList

    for
      c1 <- oneCell
      c2 <- oneCell
    yield (c1, c2)

  def distances(col: Int, row: Int, nbCol: Int, nbRow: Int): (Int, Int) =
    val h = col + (row - 1) * nbCol
    val v = (col - 1) * nbRow + row
    (h, v)
}
