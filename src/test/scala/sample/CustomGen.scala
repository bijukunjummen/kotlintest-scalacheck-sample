package sample

import org.scalacheck.Prop.forAll
import org.scalacheck.{Gen, Properties}

case class Person(name: String, age: Int)

object CustomGenPerson extends Properties("Custom Generators") {
  val genPerson = for {
    name <- Gen.alphaStr
    age <- Gen.choose(1, 50)
  } yield Person(name, age)

  genPerson.sample


  property("all people less are aged between 1 and 50") = forAll(genPerson) { (p: Person) =>
    p.age <= 50
  }
}


sealed trait BinTree[+A]

case class Leaf[A](value: A) extends BinTree[A]

case class Branch[A](left: BinTree[A], right: BinTree[A]) extends BinTree[A]


object CustomGenTree extends Properties("Binary Tree") {

  def genTree[A](genA: Gen[A]): Gen[BinTree[A]] = Gen.lzy(Gen.oneOf(genLeaf(genA), genBranch(genA)))

  def genLeaf[A](genA: Gen[A]): Gen[Leaf[A]] = genA.map(Leaf(_))

  def genBranch[A](genA: Gen[A]): Gen[Branch[A]] =
    for {
      l <- genTree(genA)
      r <- genTree(genA)
    } yield Branch(l, r)

  println(genTree(Gen.choose(1, 1000)).sample)
}


