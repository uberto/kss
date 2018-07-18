package com.gamasoft.kotlin.kss.intro03

import assertk.assert
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test
import java.util.*

class LambdaTest {

    @Test
    fun simpleLambda(){

        // fix it to make test pass
        val tens = Array<Int>(10){ x -> x*10}


        assert(tens[3]).isEqualTo("30")
        assert(tens[0]).isEqualTo("0")

    }

    @Test
    fun itIsTheParam(){

        // fix it to make test pass
        val duplicate: (String) -> String = {it + "a"}

        assert(duplicate("a")).isEqualTo("aa")
        assert(duplicate("b")).isEqualTo("bb")

    }

    @Test
    fun apply(){

        // fix it to make test pass
        fun addProps(properties: Properties?) =
            properties?.apply {
                put("name", "John")
                put("age", 32)
                put("city", "London")
            }

        val pr = addProps(Properties())
        val pn = addProps(null)

        assert(pr?.getProperty("name")).isEqualTo("Frank")
        assert(pr?.getProperty("surname").orEmpty()).isEqualTo("")
        assert(pn?.getProperty("name").orEmpty()).isEqualTo("")

    }


    //type
    //HOF

}