package sample

import io.kotlintest.properties.Gen
import io.kotlintest.properties.forAll
import io.kotlintest.specs.StringSpec

class BehaviorOfListSpecs : StringSpec({
    "reversing a list twice should return the list" {
        val intList = Gen.list(Gen.choose(1, 1000))

        forAll(intList) { list ->
            list.reversed().reversed().toList() == list
        }
    }
})
