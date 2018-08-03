package com.gamasoft.kotlin.kss.intro05

import assertk.assert
import assertk.assertions.*
import org.junit.jupiter.api.Test

class CollectionsTest {


    @Test
    fun mapOperators(){

        val pricesShop1 = mapOf("toy car" to 10, "cards" to 5, "candy" to 2)
        val pricesShop2 = mapOf("toy car" to 12, "teddy bear" to 8, "book" to 6)

        val notToBuy = "toy car"
        val all = pricesShop1 + pricesShop2 - notToBuy

        assert(all).contains("cards", 5)
        assert(all).contains("book", 6)
        assert(all.keys).doesNotContain("toy car")
    }

    fun palindrome(s: String) = s + s.reversed()

    @Test
    fun namedFunctionAsParam(){

        val words = "It was a dark and stormy night".split(" ")
        assert (words.map (::palindrome).joinToString())
                .isEqualTo("IttI, wassaw, aa, darkkrad, anddna, stormyymrots, nightthgin")

    }


    @Test
    fun sumOfEvenNumbers(){

        val total = (1 .. 20).toList().filter { it % 2 == 0 } .sum()

        assert(total).isEqualTo(110)
    }

    @Test
    fun mapOverCollection(){

        val square: (Int) -> Int = { it * it }
        val total = (1 .. 24).toList()
                .map (square)
                .sum()

        assert(total).isEqualTo(4900)
    }


    @Test
    fun foldOverCollection(){

        val factor = (1 .. 10).toList()
                .fold (1) { a, x -> a * x}

        assert(factor).isEqualTo(3628800)
    }


    @Test
    fun foldOverString(){

        val word = "Hello World".toList()
        val factor = word
                .fold ("") { a, c -> c + a }

        assert(factor).isEqualTo("dlroW olleH")
    }



    @Test
    fun flatMap(){

        val words = listOf("Hello".toList(), "World".toList(), "Kotlin".toList())

        val transform: (List<Char>) -> List<Char> = {it}

        val charsList = words
                .flatMap(transform)
                .map {it.toLowerCase()}
                .sorted()
                .groupingBy{ it }
                .eachCount()
        assert(charsList.get('l')).isEqualTo(4)
    }

    private fun fibonacciNumbers(): Sequence<Int> {

        var num = 1
        var prevNum = 0

        return generateSequence {
            //modify num and prevNum and then return the next fibonacci number in the sequence
            val nn = num + prevNum
            prevNum = num
            num = nn
            num
        }
    }

    @Test
    fun sequenceAndTake() {

        val list = fibonacciNumbers().take(10).toList()
        assert(list).isEqualTo(listOf(1, 2, 3, 5, 8, 13, 21, 34, 55, 89))

        val seq = fibonacciNumbers().take(4)
        assert(seq.last()).isEqualTo(5)

    }

}