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

        //replace TODO with a value to make the test pass
        val x: Int? = TODO()

        val y = x?.plus(5)

        assert(y).isEqualTo(null)

    }

    @Test
    fun orEmpty() {

        val a: String? = "World"
        val b = ""

        assert(a.orEmpty()).isEqualTo(b)

    }

}