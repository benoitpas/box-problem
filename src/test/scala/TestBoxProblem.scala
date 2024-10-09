import org.junit.Test
import org.junit.Assert._
import javax.swing.CellEditor

class TestBoxProblem:
  @Test def test5x3(): Unit =
    assertEquals((92, 84, 49), BoxProblem.solve(5, 3))

  val nbCol = 2
  val nbRow = 3

  @Test def testGenerateCombinations(): Unit =
    val c = BoxProblem.generateCombinations(nbCol, nbRow)
    val nbCell = nbCol * nbRow
    val l = c
      .map((c1: Cell, c2: Cell) =>
        (c1.col - 1) + (c1.row - 1) * nbCol + (c2.col - 1) * nbCell + (c2.row - 1) * nbCell * nbCol
      )
      .sorted
    assertEquals((0 to nbCell * nbCell - 1).toList, l)

  @Test def distances1(): Unit =
    assertEquals((1, 1), BoxProblem.distances(1, 1, nbCol, nbRow))

  @Test def distances2(): Unit =
    assertEquals((nbCol * nbRow, nbCol * nbRow), BoxProblem.distances(nbCol, nbRow, nbCol, nbRow))

  @Test def distances3(): Unit =
    assertEquals((nbCol + 1, 2), BoxProblem.distances(1, 2, nbCol, nbRow))

  @Test def distances4(): Unit =
    assertEquals((2, nbRow + 1), BoxProblem.distances(2, 1, nbCol, nbRow))
