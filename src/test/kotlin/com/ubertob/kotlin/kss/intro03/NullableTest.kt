package com.ubertob.kotlin.kss.intro03

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
    fun questionMark() {

        //change the value to make the test pass
        val x: Int? = 7

        val y = x?.plus(5)

        assert(y).isEqualTo(null)

    }

    @Test
    fun orEmpty() {
        //replace TODO with a value to make the test pass

        val a: String? = TODO()

        assert(a.orEmpty()).isEqualTo("")
    }


    @Test
    fun smartCast() {

        fun double(x: Int) = x * 2

        //replace TODO with a value to make the test pass
        fun nullDouble(x: Int?) = if (x == null) TODO() else double(x)


        assert(nullDouble(5)).isEqualTo(10)
        assert(nullDouble(null)).isEqualTo(0)
    }

    @Test
    fun safeCalls() {

        //fix parameters to make test pass
        fun triple(x: Int?) = x?.times(5)

        assert(triple(null)).isEqualTo(null)
        assert(triple(4)).isEqualTo(12)
    }

    @Test
    fun elvisOperator() {

        fun double(x: Int) = x * 2

        //replace TODO with a value to make the test pass
        fun nullDouble(x: Int?) = double(x ?: TODO())

        assert(nullDouble(5)).isEqualTo(10)
        assert(nullDouble(null)).isEqualTo(0)
    }

    @Test
    fun middleName() {
        //replace TODO with a value to make the test pass

        fun name(first: String, middle: String?, surname: String){
            TODO()
        }
        assert(name("James", "Tiberius", "Kirk")).isEqualTo("James T. Kirk")
        assert(name("John", null, "Doe")).isEqualTo("John Doe")

    }



}