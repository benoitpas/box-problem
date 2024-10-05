import org.junit.Test
import org.junit.Assert._

object tests {
  @Test def test5x3(): Unit =
    assertEquals((0, 0, 1), BoxProblem.solve(5, 3))
}
