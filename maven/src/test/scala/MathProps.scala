import org.scalacheck.Prop.forAll
import org.scalatest.FunSuite
import org.scalatest.prop.Checkers

class MathProps extends FunSuite with Checkers {
  test("max") {
    forAll {
      (x: Int, y: Int) =>
        val z = java.lang.Math.max(x, y)
        (z == x || z == y) && (z >= x && z >= y)
    }
  }
}
