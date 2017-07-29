package sample

import org.scalacheck.Prop.forAll
import org.scalacheck.{Gen, Properties}

object StringSpecification extends Properties("String") {

  property("startsWith") = forAll { (a: String, b: String) =>
    (a + b).startsWith(a)
  }

  property("concatenate") = forAll { (a: String, b: String) =>
    (a + b).length > a.length && (a + b).length > b.length
  }

  property("substring") = forAll { (a: String, b: String, c: String) =>
    (a + b + c).substring(a.length, a.length + b.length) == b
  }
}

object ListSpecification extends Properties("List") {
  val intList = Gen.listOf(Gen.choose(1, 1000))
  property("reversing a list twice should return the list") = forAll(intList) { (a: List[Int]) =>
    a.reverse.reverse == a
  }
}