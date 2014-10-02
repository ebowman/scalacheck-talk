import org.scalacheck.Gen.{alphaStr, listOf, numChar}
import org.scalacheck.{Prop, Properties}

object StringUtilsProps extends Properties("StringUtils") {

  property("truncate") =
    Prop.forAll {
      (sampleString: String, maxLength: Int) =>
        val t = StringUtils.truncate(sampleString, maxLength)
        (sampleString.length <= maxLength && t == sampleString) ||
          (sampleString.length > maxLength && t == sampleString.take(maxLength) + "...")
    }

  property("tokenize") =
    Prop.forAll(listOf(alphaStr), numChar) {
      (tokens: List[String], delimiter: Char) =>
        val str = tokens.mkString(delimiter.toString)
        StringUtils.tokenize(str, delimiter).toList == tokens
    }
}
