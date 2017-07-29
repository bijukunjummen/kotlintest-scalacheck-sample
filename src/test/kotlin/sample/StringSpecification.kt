package sample

import io.kotlintest.properties.Gen
import io.kotlintest.properties.forAll
import io.kotlintest.specs.StringSpec

class StringSpecification : StringSpec() {
    init {
        "startsWith" {
            forAll { a: String, b: String ->
                (a + b).startsWith(a)
            }
        }

        "concatenate" {
            forAll { a: String, b: String ->
                (a + b).length > a.length && (a + b).length > b.length
            }
        }

        "substring" {
            forAll { a: String, b: String, c: String ->
                (a + b + c).substring(a.length, a.length + b.length) == b
            }
        }
    }
}




