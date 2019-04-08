package com.ubertob.kotlin.kss.functionalKatas

import assertk.assert
import assertk.assertThat
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

        assertThat(fizzBuzz(1)).isEqualTo("1")
        assertThat(fizzBuzz(2)).isEqualTo("2")
        assertThat(fizzBuzz(3)).isEqualTo("fizz")
        assertThat(fizzBuzz(4)).isEqualTo("4")
        assertThat(fizzBuzz(5)).isEqualTo("buzz")
        assertThat(fizzBuzz(6)).isEqualTo("fizz")
        assertThat(fizzBuzz(7)).isEqualTo("7")
        assertThat(fizzBuzz(8)).isEqualTo("8")
        assertThat(fizzBuzz(9)).isEqualTo("fizz")
        assertThat(fizzBuzz(10)).isEqualTo("buzz")
        assertThat(fizzBuzz(15)).isEqualTo("fizzbuzz")

    }


    @Test
    fun extension(){

        assertThat(fizzBuzzGulp(1)).isEqualTo("1")
        assertThat(fizzBuzzGulp(2)).isEqualTo("gulp")
        assertThat(fizzBuzzGulp(3)).isEqualTo("fizz")
        assertThat(fizzBuzzGulp(4)).isEqualTo("gulp")
        assertThat(fizzBuzzGulp(5)).isEqualTo("buzz")
        assertThat(fizzBuzzGulp(6)).isEqualTo("fizzgulp")
        assertThat(fizzBuzzGulp(7)).isEqualTo("7")
        assertThat(fizzBuzzGulp(8)).isEqualTo("gulp")
        assertThat(fizzBuzzGulp(9)).isEqualTo("fizz")
        assertThat(fizzBuzzGulp(10)).isEqualTo("buzzgulp")
        assertThat(fizzBuzz(15)).isEqualTo("fizzbuzz")

    }
}