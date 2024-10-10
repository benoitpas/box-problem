case class Cell(col: Int, row: Int)

object BoxProblem {
  def solve(nbCol: Int, nbRow: Int): (Int, Int, Int) =
    val dHV = generateCombinations(nbCol, nbRow).map((c1, c2) => {
      val d1 = distances(c1.col, c1.row, nbCol, nbRow)
      val d2 = distances(c2.col, c2.row, nbCol, nbRow)
      (math.min(d1._1, d2._1), math.min(d1._2, d2._2))
    })
    dHV.foldRight((0, 0, 0)) { (hv, acc) =>
      hv match
        case (h, v) if (h < v) => (acc._1 + 1, acc._2, acc._3)
        case (h, v) if (h > v) => (acc._1, acc._2 + 1, acc._3)
        case _                 => (acc._1, acc._2, acc._3 + 1)
    }

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
