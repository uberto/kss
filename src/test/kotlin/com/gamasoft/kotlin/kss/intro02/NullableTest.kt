package com.gamasoft.kotlin.kss.intro02

import assertk.assert
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class NullableTest {

    @Test
    fun nullableVariable() {

        //replace TODO with a value to make the test pass

        val x: Int? = TODO()

        assert(x).isEqualTo(null)

    }

    @Test
    fun operations() {

        val x: Int? = 5

        var y = 7

        // uncomment and change x type to make test pass
//        val y += x

        assert(y).isEqualTo(12)

    }

    @Test
    fun questionMark() {

        //change the value to make the test pass
        val x: Int? = 7

        val y = x?.plus(5)

        assert(y).isEqualTo(null)

    }

    @Test
    fun orEmpty() {

        val a: String? = "World"
        val b = ""

        assert(a.orEmpty()).isEqualTo(b)
    }

    @Test
    fun middleName() {

        fun name(first: String, middle: String?, surname: String){
            TODO()
        }
        assert(name("James", "Tiberius", "Kirk")).isEqualTo("James T. Kirk")
        assert(name("John", null, "Doe")).isEqualTo("John Doe")

    }


//    let
//    apply
//    elvis
    // concat ?.?.

}