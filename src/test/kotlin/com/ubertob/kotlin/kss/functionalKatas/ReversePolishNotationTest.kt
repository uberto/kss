package com.ubertob.kotlin.kss.functionalKatas

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class ReversePolishNotationTest {


    fun rpn(exp: String): Int = TODO()

    @Test
    fun simpleOperations(){
        assertThat(rpn("3 4 +")).isEqualTo(7)
        assertThat(rpn("-5 20 +")).isEqualTo(15)
        assertThat(rpn("13 4 -")).isEqualTo(9)
        assertThat(rpn("4 5 *")).isEqualTo(20)
        assertThat(rpn("-2 10 *")).isEqualTo(-20)
    }

    @Test
    fun longerExp(){
        assertThat(rpn("3 4 5 * −")).isEqualTo(14)
        assertThat(rpn("5 3 4 − *")).isEqualTo(14)
        assertThat(rpn("2 3 4 + *")).isEqualTo(14)
        assertThat(rpn("4 2 3 4 + * 4 - * 2 +")).isEqualTo(42)
        assertThat(rpn("7 1 1 + − 3 * 2 1 1 + + −")).isEqualTo(11)
    }

}