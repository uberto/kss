package com.ubertob.kotlin.kss.functionalKatas

import assertk.assert
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class ReversePolishNotationTest {


    fun rpn(exp: String): Int = TODO()

    @Test
    fun simpleOperations(){
        assert(rpn("3 4 +")).isEqualTo(7)
        assert(rpn("-5 20 +")).isEqualTo(15)
        assert(rpn("13 4 -")).isEqualTo(9)
        assert(rpn("4 5 *")).isEqualTo(20)
        assert(rpn("-2 10 *")).isEqualTo(-20)
    }

    @Test
    fun longerExp(){
        assert(rpn("3 4 5 * −")).isEqualTo(14)
        assert(rpn("5 3 4 − *")).isEqualTo(14)
        assert(rpn("2 3 4 + *")).isEqualTo(14)
        assert(rpn("4 2 3 4 + * 4 - * 2 +")).isEqualTo(42)
        assert(rpn("7 1 1 + − 3 * 2 1 1 + + −")).isEqualTo(11)
    }

}