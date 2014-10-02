
import org.scalacheck.Gen
import org.scalacheck.Prop.forAll
import org.scalatest.{Matchers, FunSuite}
import org.scalatest.prop.Checkers

class ArticleDescriptionProps
  extends FunSuite with Checkers with Matchers {

  val genSize = Gen.oneOf(Size.values())
  val genColor = Gen.oneOf(Color.values())
  val genDescription = Gen.oneOf(
    "shirt", "dress", "trousers", "shoes")
  val genArticle = for {
    size <- genSize
    color <- genColor
    description <- genDescription
  } yield new ArticleDescription(size, color, description)

  test("article descriptions") {
    check(forAll(genArticle) {
      article =>
        val stringRep = article.toString
        stringRep.contains(article.getColor.toString) &&
        stringRep.contains(article.getSize.toString) &&
        stringRep.contains(article.getDescription)
    })
  }
}
