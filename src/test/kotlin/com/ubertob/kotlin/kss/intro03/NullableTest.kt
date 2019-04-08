package com.ubertob.kotlin.kss.intro03

import assertk.assert
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class NullableTest {

    @Test
    fun nullableVariable() {

        //replace TODO with a value to make the test pass

        val x: Int? = null

        assert(x).isEqualTo(null)

    }


    @Test
    fun questionMark() {

        //change the value to make the test pass
        val x: Int? = null

        val y = x?.plus(5)

        assert(y).isEqualTo(null)

    }

    @Test
    fun orEmpty() {
        //replace TODO with a value to make the test pass

        val a: String? = null

        assert(a.orEmpty()).isEqualTo("")
    }


    @Test
    fun smartCast() {

        fun double(x: Int) = x * 2

        //replace TODO with a value to make the test pass
        fun nullDouble(x: Int?) = if (x == null) 0 else double(x)


        assert(nullDouble(5)).isEqualTo(10)
        assert(nullDouble(null)).isEqualTo(0)
    }

    @Test
    fun safeCalls() {

        //fix parameters to make test pass
        fun triple(x: Int?) = x?.times(3)

        assert(triple(null)).isEqualTo(null)
        assert(triple(4)).isEqualTo(12)
    }

    @Test
    fun elvisOperator() {

        fun double(x: Int) = x * 2

        //replace TODO with a value to make the test pass
        fun nullDouble(x: Int?) = double(x ?: 0)

        assert(nullDouble(5)).isEqualTo(10)
        assert(nullDouble(null)).isEqualTo(0)
    }

    @Test
    fun middleName() {
        //replace TODO with a value to make the test pass

        fun name(first: String, middle: String?, surname: String): String{
            val mi = middle?.firstOrNull()?.plus(". ").orEmpty()
            return "$first $mi$surname"
        }
        assert(name("James", "Tiberius", "Kirk")).isEqualTo("James T. Kirk")
        assert(name("John", null, "Doe")).isEqualTo("John Doe")

    }



}