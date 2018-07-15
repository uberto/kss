package com.gamasoft.kotlin.kss.intro01

import assertk.assert
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class FunTest {

    @Test
    fun defineAFunction(){

        fun myfun(): String { return TODO()}

        assert(myfun()).isEqualTo("Kotlin is Fun")
    }

}