import org.junit.Test
import org.junit.Assert._
import javax.swing.CellEditor

class TestBoxProblem:
  @Test def test5x3(): Unit =
    assertEquals((0, 0, 1), BoxProblem.solve(5, 3))

  @Test def testGenerateCombinations(): Unit =
    val nbCol = 2
    val nbRow = 3
    val c = BoxProblem.generateCombinations(nbCol, nbRow)
    val nbCell = nbCol * nbRow
    val l = c
      .map((c1: Cell, c2: Cell) =>
        (c1.col - 1) + (c1.row - 1) * nbRow + (c2.col - 1) * nbCell + (c2.row - 1) * nbRow * nbCell
      )
      .sorted
    assertEquals(Seq.range(1, nbCell * nbCell + 1).toList, l)
