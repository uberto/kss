package com.ubertob.kotlin.kss.intro06

import assertk.assertThat
import assertk.assertions.hasSize
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

data class Person(val name: String, val age: Int)

data class Point(val x: Int, val y: Int) {
    val dist: Double
    init {
        dist = Math.sqrt ((x*x + y*y).toDouble())
    }

    operator fun plus(other: Point):Point = TODO()
}


sealed class FinancialInstrument(val name: String)
    data class Option(val underlying: String, val type: String) : FinancialInstrument("Option")
    data class Future(val underlying: String, val expiry: Int) : FinancialInstrument("Future")
    data class EquitySwap(val underlying: String) : FinancialInstrument("TRS")


typealias FinancialFun =(String) -> FinancialInstrument


class DataClassTest {


    @Test
    fun aSimpleDataClass(){

        val people = listOf(
                Person("joe", 42),
                Person("anne", 42),
                Person("mary", 42))

        val under30 = people.filter { it.age < 30 }

        assertThat(under30).hasSize(1)

    }

    @Test
    fun dataClassAreImmutable(){

        val joey = Person("joey", 25)

//        joe.name = "joe" doesn't compile

        val joe = joey.copy(name = "joe")

        assertThat(joe.name).isEqualTo("joe")
        assertThat(joe.age).isEqualTo(27)
    }

    @Test
    fun dataClassInitialized(){

        val p1 = Point(3, 4)
        val p2 = Point(6, -7)

        assertThat(p1.dist).isEqualTo(5.0)
        assertThat(p2.dist).isEqualTo(10.0)
    }


    @Test
    fun destructorInLambdas(){

        val people = listOf(
                Person("joe", 24),
                Person("anne", 25),
                Person("mary", 26))


        val profiles= people.map { (name, age) -> name +age }

        assertThat(profiles[0]).isEqualTo("joe: 24")
        assertThat(profiles[1]).isEqualTo("anne: 25")
        assertThat(profiles[2]).isEqualTo("mary: 26")
    }

    @Test
    fun destructorInReturn(){

        fun middlePoint(p1: Point, p2: Point):Point = TODO()

        val (x, y) = middlePoint(Point(4, 7), Point(6, 9))

        assertThat(x).isEqualTo(5)
        assertThat(y).isEqualTo(8)
    }

    @Test
    fun dataClassSealed(){

        fun getName(instr: FinancialInstrument): String {
            TODO()
        }

        assertThat(getName(Option("VOD.L", "Call"))).isEqualTo("Option")
        assertThat(getName(Future("BT.L", 60))).isEqualTo("Future")
    }


    @Test
    fun returnAsTuple(){

        fun splitDate(date: String): Triple<Int, Int, Int> = TODO()

        val (day, month, year) = splitDate("12/05/2018")
        assertThat(day).isEqualTo(12)
        assertThat(month).isEqualTo(5)
        assertThat(year).isEqualTo(2018)

    }


    @Test
    fun operatorOverloading(){

        //implement the operator function plus of Point to pass the test
        val p1 = Point(2,3)
        val p2 = Point(5,9)

        val p3 = p1 + p2

        assertThat(p3).isEqualTo(Point(7,12))

    }

    @Test
    fun whenAndSealedClasses(){

        fun fullDescription(instr: FinancialInstrument): String = when (instr) {
            is Option -> TODO()
            is Future -> TODO()
            is EquitySwap -> TODO()
        }

        assertThat(fullDescription(Option("VOD.L", "Call"))).isEqualTo("Option Call VOD.L")
        assertThat(fullDescription(Future("BT.L", 60))).isEqualTo("Future 60 days BT.L")
    }


    @Test
    fun typeAlias(){
        //FinancialFun is a typealias defined on top

        val futureSixtyDaysFactory: FinancialFun = TODO()
        val callOptionFactory: FinancialFun = TODO()

        fun instr(f: FinancialFun, stock: String): FinancialInstrument = TODO()

        assertThat(instr(futureSixtyDaysFactory, "IBM.N")).isEqualTo(Future("IBM.N", 60))
        assertThat(instr(callOptionFactory, "AAPL.OQ")).isEqualTo(Option("AAPL.OQ", "Call"))
    }

}