package com.ubertob.kotlin.kss.intro04

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test
import java.util.*

class LambdaTest {

    @Test
    fun simpleLambda(){

        // fix it to make test pass
        val tens = Array<Int>(10){ x -> x*10}


        assertThat(tens[3]).isEqualTo("30")
        assertThat(tens[0]).isEqualTo("0")

    }

    @Test
    fun itIsTheParam(){

        // fix it to make test pass
        val duplicate: (String) -> String = {it + "a"}

        assertThat(duplicate("a")).isEqualTo("aa")
        assertThat(duplicate("b")).isEqualTo("bb")

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

        assertThat(pr?.getProperty("name")).isEqualTo("Frank")
        assertThat(pr?.getProperty("surname").orEmpty()).isEqualTo("")
        assertThat(pn?.getProperty("name").orEmpty()).isEqualTo("")

    }

    @Test
    fun lambdaType(){

        val myLambda: (Int) -> String

        //replace todo with an actual lambda and pass the test
        myLambda = TODO()

        assertThat(myLambda(4)).isEqualTo("value of x is 4")

    }


    @Test
    fun functionAsParam(){
        //fix the code to pass the test
        fun applyFun(x: String, f: (String) -> String): String = TODO()

        assertThat(applyFun("Abc"){it + it}).isEqualTo("AbcAbc")
        assertThat(applyFun("Zack"){it.toLowerCase()}).isEqualTo("zack")

    }


    @Test
    fun functionAsReturnValue(){

        //fix the code to pass the test
        fun plusFactory(x: Int): (Int) -> Int = TODO()

        val plus3 = plusFactory(3)
        assertThat(plus3(4)).isEqualTo(7)

    }



    @Test
    fun higherOrderFunctions(){

        val combine: ((Int) -> Int, (Int) -> Int) -> ((Int) -> Int)

        val square: (Int) -> Int = {it * it}
        val double: (Int) -> Int = {x -> x * 2 + 1}

        //replace todo with an actual lambda and pass the test
        combine = TODO()
        val doubleSquarePlusOne = combine(square, double)

        assertThat(doubleSquarePlusOne(5)).isEqualTo(51)

    }

}