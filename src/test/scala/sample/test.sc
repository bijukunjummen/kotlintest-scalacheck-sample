import org.scalacheck.Gen
import org.scalacheck.Arbitrary.arbitrary

case class Person(name: String, age: Int)

val genPerson = for {
  name <- Gen.alphaStr
  age <- Gen.choose(1, 50)
} yield Person(name, age)


val oddInt = Gen.choose(1, 100) suchThat (_ % 2 != 0)

genPerson.sample
oddInt.sample