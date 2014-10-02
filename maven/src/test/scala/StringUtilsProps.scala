import org.scalacheck.Gen.{alphaStr, listOf, numChar}
import org.scalacheck.Prop.forAll
import org.scalatest.{Matchers, FunSuite}
import org.scalatest.prop.Checkers

class StringUtilsProps extends FunSuite with Checkers with Matchers {

  test("truncate") {
    check {
      (sampleString: String, maxLength: Int) =>
        lazy val t = StringUtils.truncate(sampleString, maxLength)
        if (maxLength < 0) {
          a [StringIndexOutOfBoundsException] should be thrownBy t
          true
        } else {
          (sampleString.length <= maxLength && t == sampleString) ||
            (sampleString.length > maxLength && t == sampleString.take(maxLength) + "...")
        }
    }
  }

  test("tokenize") {
    check(forAll(listOf(alphaStr), numChar) {
      (tokens: List[String], delimiter: Char) =>
        import org.scalacheck.Prop.AnyOperators
        val str = tokens.mkString(delimiter.toString)
        StringUtils.tokenize(str, delimiter).toList ?= tokens
    })
  }
}
