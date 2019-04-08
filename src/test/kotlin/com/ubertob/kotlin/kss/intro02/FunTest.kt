package com.ubertob.kotlin.kss.intro02

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isNotNull
import org.junit.jupiter.api.Test
import java.util.*

class FunTest {

    @Test
    fun defineAFunctionWithoutAClass(){

        //replace TODO with a value to make the test pass
        fun myfun(): String {
            return "Kotlin is Fun"
        }

        assertThat(myfun()).isEqualTo("Kotlin is Fun")
    }

    @Test
    fun singleStatementFunctionsDontNeedReturn(){

        //replace TODO with a value to make the test pass
        fun myfun(): String = "Kotlin is Fun"

        assertThat(myfun()).isEqualTo("Kotlin is Fun")
    }

    @Test
    fun nestedFun(){

        //replace TODO with a value to make the test pass
        fun myFun(): String {
            fun myNestedFun(): String {
                return "Kotlin Fun can be nested!"
            }
            return myNestedFun()
        }

        assertThat(myFun()).isEqualTo("Kotlin Fun can be nested!")
    }


    @Test
    fun singleStatementFunDeclaration(){

        //replace TODO with a value to make the test pass
        fun double(x: Int): Int = x + x

        assertThat(double(5)).isEqualTo(10)

    }

    @Test
    fun createJavaObject(){

        //replace TODO with a value to make the test pass

        val now: java.util.Date = Date()

        assertThat(now).isNotNull()

    }

    @Test
    fun defaultParameter(){

        // fix it to make test pass
        fun answer(x: Int = 42): String{
            return x.toString()
        }

        assertThat(answer(12)).isEqualTo("12")
        assertThat(answer()).isEqualTo("42")

    }



    @Test
    fun namedParameters(){

        //replace TODO with a value to make the test pass
        fun pitagora(hypotenuse: Double, leg: Double): Double =
                Math.sqrt(hypotenuse*hypotenuse - leg*leg)

        assertThat(pitagora(5.0, 4.0)).isEqualTo(3.0)
        assertThat(pitagora(leg = 4.0, hypotenuse = 5.0)).isEqualTo(3.0)

    }



    @Test
    fun spreadAndVarArgs(){

        fun myConcat(vararg xs: String): String{

            return xs.joinToString()

        }

        val nums = arrayOf("1","2","3")

        val result = myConcat(*nums)

        val result2 = myConcat("1","2","3") //choose correct arguments

        assertThat(result).isEqualTo(result2)
    }


}