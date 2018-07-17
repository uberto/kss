package com.gamasoft.kotlin.kss.intro01

import assertk.assert
import assertk.assertions.isEqualTo
import assertk.assertions.isInstanceOf
import assertk.assertions.isNotNull
import org.junit.jupiter.api.Test
import java.util.*

class FunTest {

    @Test
    fun defineAFunctionWithoutAClass(){

        //replace TODO with a value to make the test pass
        fun myfun(): String { return TODO()}

        assert(myfun()).isEqualTo("Kotlin is Fun")
    }

    @Test
    fun nestedFun(){

        //replace TODO with a value to make the test pass
        fun myFun(): String {
            fun myNestedFun(): String {
                return TODO()
            }
            return myNestedFun()
        }

        assert(myFun()).isEqualTo("Kotlin Fun can be nested!")
    }




    @Test
    fun valOrVar(){

        var iCanChange = 5

        val iCannotChange = "42".toInt()

        //add something here to make it pass

        assert(iCanChange).isEqualTo(iCannotChange)

    }

    @Test
    fun createJavaObject(){

        val now: java.util.Date = TODO()

        assert(now).isNotNull()

    }

    @Test
    fun defaultParameter(){

        fun answer(x: Int){
            x.toString()
        }


        assert(answer(12)).isEqualTo("12")

//uncomment and make it work
//        assert(answer()).isEqualTo("42")

    }


    @Test
    fun namedParameters(){

        //replace TODO with a value to make the test pass
        fun pitagora(hypotenuse: Double, leg: Double): Double = TODO()

        assert(pitagora(5.0, 4.0)).isEqualTo(3.0)
        assert(pitagora(leg = 4.0, hypotenuse = 5.0)).isEqualTo(3.0)

    }



}