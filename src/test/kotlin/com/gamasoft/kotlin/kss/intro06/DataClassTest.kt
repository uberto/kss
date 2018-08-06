package com.gamasoft.kotlin.kss.intro06

import assertk.assert
import assertk.assertions.hasSize
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

data class Person(val name: String, val age: Int)

data class Point(val x: Int, val y: Int) {
    val dist: Double
    init {
        dist = Math.sqrt ((x*x + y*y).toDouble())
    }

    operator fun plus(other: Point):Point = Point(x+other.x, y + other.y)
}


sealed class FinancialInstrument(val name: String)
    data class Option(val underlying: String, val type: String) : FinancialInstrument("Option")
    data class Future(val underlying: String, val expiry: Int) : FinancialInstrument("Future")
    data class EquitySwap(val underlying: String) : FinancialInstrument("TRS")


typealias FinancialFun =(String) -> FinancialInstrument


class DataClassTest {


    @Test
    fun aSimpleDataClass(){

        //change people data to make the test pass
        val people = listOf(
                Person("joe", 42),
                Person("anne", 28),
                Person("mary", 42))

        val under30 = people.filter { it.age < 30 }

        assert (under30).hasSize(1)

    }

    @Test
    fun dataClassAreImmutable(){

        val joey = Person("joey", 25)

//        joey.name = "joe" doesn't compile

        val joe = joey.copy(name = "joe", age = 27)

        assert (joe.name).isEqualTo("joe")
        assert (joe.age).isEqualTo(27)
    }

    @Test
    fun dataClassInitialized(){

        val p1 = Point(3, 4)
        val p2 = Point(6, 8)

        assert (p1.dist).isEqualTo(5.0)
        assert (p2.dist).isEqualTo(10.0)
    }


    @Test
    fun destructorInLambdas(){

        val people = listOf(
                Person("joe", 24),
                Person("anne", 25),
                Person("mary", 26))


        val profiles= people.map { (name, age) -> "$name: $age" }

        assert (profiles[0]).isEqualTo("joe: 24")
        assert (profiles[1]).isEqualTo("anne: 25")
        assert (profiles[2]).isEqualTo("mary: 26")
    }

    @Test
    fun destructorInReturn(){

        fun middlePoint(p1: Point, p2: Point):Point = Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2)

        val (x, y) = middlePoint(Point(4, 7), Point(6, 9))

        assert (x).isEqualTo(5)
        assert (y).isEqualTo(8)
    }

    @Test
    fun dataClassSealed(){

        fun getName(instr: FinancialInstrument): String {
            return instr.name
        }

        assert (getName(Option("VOD.L", "Call"))).isEqualTo("Option")
        assert (getName(Future("BT.L", 60))).isEqualTo("Future")
    }


    @Test
    fun returnAsTuple(){

        fun splitDate(date: String): Triple<Int, Int, Int> {
            val parts = date.split("/").map { it.toInt() }
            return Triple(parts[0], parts[1], parts[2])
        }

        val (day, month, year) = splitDate("12/05/2018")
        assert(day).isEqualTo(12)
        assert(month).isEqualTo(5)
        assert(year).isEqualTo(2018)

    }


    @Test
    fun operatorOverloading(){

        //implement the operator function plus of Point to pass the test
        val p1 = Point(2,3)
        val p2 = Point(5,9)

        val p3 = p1 + p2

        assert(p3).isEqualTo(Point(7,12))

    }

    @Test
    fun whenAndSealedClasses(){

        fun fullDescription(instr: FinancialInstrument): String = when (instr) {
            is Option -> "${instr.name} ${instr.type} ${instr.underlying}"
            is Future -> "${instr.name} ${instr.expiry} days ${instr.underlying}"
            is EquitySwap -> "${instr.name} ${instr.underlying}"
        }

        assert (fullDescription(Option("VOD.L", "Call"))).isEqualTo("Option Call VOD.L")
        assert (fullDescription(Future("BT.L", 60))).isEqualTo("Future 60 days BT.L")
    }


    @Test
    fun typeAlias(){
        //FinancialFun is a typealias defined on top

        val futureSixtyDaysFactory: FinancialFun = {Future(it, 60)}
        val callOptionFactory: FinancialFun = {Option(it, "Call")}

        fun instr(f: FinancialFun, stock: String): FinancialInstrument = f(stock)

        assert (instr(futureSixtyDaysFactory, "IBM.N")).isEqualTo(Future("IBM.N", 60))
        assert (instr(callOptionFactory, "AAPL.OQ")).isEqualTo(Option("AAPL.OQ", "Call"))
    }

}