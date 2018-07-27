package com.gamasoft.kotlin.kss.intro04

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

    @Test
    fun lambdaType(){

        val myLambda: (Int) -> String

        //replace todo with an actual lambda and pass the test
        myLambda = TODO()

        assert(myLambda(4)).isEqualTo("value of x is 4")

    }

    @Test
    fun functionAsReturnValue(){

        //fix the code to pass the test
        fun plusFactory(x: Int): (Int) -> Int = { y -> x - y }

        val plus3 = plusFactory(3)
        assert (plus3(4)).isEqualTo(7)

    }

    @Test
    fun higherOrderFunctions(){

        val combine: ((Int) -> Int, (Int) -> Int) -> ((Int) -> Int)

        val square: (Int) -> Int = {it * it}
        val double: (Int) -> Int = {x -> x * 2 + 1}

        //replace todo with an actual lambda and pass the test
        combine = TODO()
        val doubleSquarePlusOne = combine(square, double)

        assert(doubleSquarePlusOne(5)).isEqualTo(51)

    }

}