package com.gamasoft.kotlin.kss.intro06

import assertk.assert
import assertk.assertions.hasSize
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class DataClassTest {

    data class Person(val name: String, val age: Int)

    data class Point(val x: Int, val y: Int) {
        val dist: Double
        init {
            dist = Math.sqrt ((x*x + y*y).toDouble())
        }
    }


    sealed class FinancialInstrument(val name: String) {
        data class Option(val underlying: String, val type: String) : FinancialInstrument("Option")
        data class Future(val underlying: String, val expiry: Int) : FinancialInstrument("Future")
        data class EquitySwap(val underlying: String) : FinancialInstrument("TRS")
    }

    @Test
    fun aSimpleDataClass(){

        val people = listOf(
                Person("joe", 42),
                Person("anne", 42),
                Person("mary", 42))

        val under30 = people.filter { it.age < 30 }

        assert (under30).hasSize(1)

    }

    @Test
    fun dataClassAreImmutable(){

        val joey = Person("joey", 25)

//        joe.name = "joe" doesn't compile

        val joe = joey.copy(name = "joe")

        assert (joe.name).isEqualTo("joe")
        assert (joe.age).isEqualTo(27)
    }

    @Test
    fun dataClassInitialized(){

        val p1 = Point(3, 4)
        val p2 = Point(6, -7)

        assert (p1.dist).isEqualTo(5.0)
        assert (p2.dist).isEqualTo(10.0)
    }


    @Test
    fun destructor(){


        val people = listOf(
                Person("joe", 24),
                Person("anne", 25),
                Person("mary", 26))


        val profiles= people.map { (name, age) -> name +age }

        assert (profiles[0]).isEqualTo("joe: 24")
        assert (profiles[1]).isEqualTo("anne: 25")
        assert (profiles[2]).isEqualTo("mary: 26")
    }


    @Test
    fun dataClassSealed(){

        fun getName(instr: FinancialInstrument): String {
            TODO()
        }

        assert (getName(FinancialInstrument.Option("VOD.L", "Call"))).isEqualTo("Option")
        assert (getName(FinancialInstrument.Future("BT.L", 60))).isEqualTo("Future")
    }



    @Test
    fun whenAndSealedClasses(){

        fun fullDescription(instr: FinancialInstrument): String = when (instr) {
            is FinancialInstrument.Option -> TODO()
            is FinancialInstrument.Future -> TODO()
            is FinancialInstrument.EquitySwap -> TODO()
        }

        assert (fullDescription(FinancialInstrument.Option("VOD.L", "Call"))).isEqualTo("Option Call VOD.L")
        assert (fullDescription(FinancialInstrument.Future("BT.L", 60))).isEqualTo("Future 60 days BT.L")
    }

    @Test
    fun returnAsTuple(){

        fun splitDate(date: String): Triple<Int, Int, Int> = TODO()

        val (day, month, year) = splitDate("12/05/2018")
        assert(day).isEqualTo(12)
        assert(month).isEqualTo(5)
        assert(year).isEqualTo(2018)

    }


}