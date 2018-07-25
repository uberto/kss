package com.gamasoft.kotlin.kss.functionalKatas

import assertk.assert
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class FizzBuzzTest {

    //implement the 3 small functions and the composeFun to pass the tests. Note the nullable Strings...
    fun fizz(x: Int): String? = TODO()
    fun buzz(x: Int): String? = TODO()
    fun gulp(x: Int): String? = TODO()

    fun fizzBuzz(x: Int):String = composeFun(::fizz, ::buzz)(x)
    fun fizzBuzzGulp(x: Int):String = composeFun(::fizz, ::buzz, ::gulp)(x)

    private fun composeFun(vararg funs: (Int) -> String?): (Int) -> String = TODO()

    @Test
    fun baseKata(){

        assert(fizzBuzz(1)).isEqualTo("1")
        assert(fizzBuzz(2)).isEqualTo("2")
        assert(fizzBuzz(3)).isEqualTo("fizz")
        assert(fizzBuzz(4)).isEqualTo("4")
        assert(fizzBuzz(5)).isEqualTo("buzz")
        assert(fizzBuzz(6)).isEqualTo("fizz")
        assert(fizzBuzz(7)).isEqualTo("7")
        assert(fizzBuzz(8)).isEqualTo("8")
        assert(fizzBuzz(9)).isEqualTo("fizz")
        assert(fizzBuzz(10)).isEqualTo("buzz")
        assert(fizzBuzz(15)).isEqualTo("fizzbuzz")

    }


    @Test
    fun extension(){

        assert(fizzBuzzGulp(1)).isEqualTo("1")
        assert(fizzBuzzGulp(2)).isEqualTo("gulp")
        assert(fizzBuzzGulp(3)).isEqualTo("fizz")
        assert(fizzBuzzGulp(4)).isEqualTo("gulp")
        assert(fizzBuzzGulp(5)).isEqualTo("buzz")
        assert(fizzBuzzGulp(6)).isEqualTo("fizzgulp")
        assert(fizzBuzzGulp(7)).isEqualTo("7")
        assert(fizzBuzzGulp(8)).isEqualTo("gulp")
        assert(fizzBuzzGulp(9)).isEqualTo("fizz")
        assert(fizzBuzzGulp(10)).isEqualTo("buzzgulp")
        assert(fizzBuzz(15)).isEqualTo("fizzbuzz")

    }
}