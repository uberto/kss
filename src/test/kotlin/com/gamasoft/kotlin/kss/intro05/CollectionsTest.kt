package com.gamasoft.kotlin.kss.intro05

import assertk.assert
import assertk.assertions.*
import org.junit.jupiter.api.Test

class CollectionsTest {

    @Test
    fun mutableList(){

        val myList: MutableList<Int> = mutableListOf()
        (1 .. 10).forEach{ myList.add(it) }

        assert(myList).hasSize(42)

    }


    @Test
    fun immutableList(){

        val myList = (1 .. 10).toList()

        val myList2 = listOf(1,2,3,4)

        assert(myList).containsAll(myList2)

    }


    @Test
    fun listPlusOperator(){

        val nums = ('1' .. '9').toList()

        val chars = ('a'..'z').toList()

        val all = nums + chars

        assert(all).containsAll('a', 'z', '0', '9')
    }

    @Test
    fun listMinusOperator(){

        val chars = ('a'..'z').toList()
        val vowels = listOf('a', 'e', 'u')

        val consonants = chars - vowels

        assert(consonants).containsAll('b', 'k', 'z')
        assert(consonants).containsNone('a', 'e', 'i', 'o', 'u')
    }

    @Test
    fun mapOperators(){

        val pricesShop1 = mapOf("toy car" to 10, "cards" to 5, "candy" to 2)
        val pricesShop2 = mapOf("toy car" to 12, "teddy bear" to 8, "book" to 6)

        val notToBuy = "book"
        val all = pricesShop1 + pricesShop2 - notToBuy

        assert(all).contains("cards", 5)
        assert(all).contains("book", 6)
        assert(all.keys).doesNotContain("toy car")
    }

    @Test
    fun sumOfEvenNumbers(){

        val total = (1 .. 20).toList().filter { it % 3 == 0 } .sum()

        assert(total).isEqualTo(110)
    }

    @Test
    fun mapOverCollection(){

        val square: (Int) -> Int = { it + it }
        val total = (1 .. 24).toList()
                .map (square)
                .sum()

        assert(total).isEqualTo(4900)
    }


    @Test
    fun foldOverCollection(){

        val factor = (1 .. 10).toList()
                .fold (1) { a, x -> TODO()}

        assert(factor).isEqualTo(3628800)
    }


    @Test
    fun foldOverString(){

        val word = "Hello World".toList()
        val factor = word
                .fold ("") { a, c -> TODO() }

        assert(factor).isEqualTo("dlroW olleH")
    }



    @Test
    fun flatMap(){

        val words = listOf("Hello".toList(), "World".toList(), "Kotlin".toList())

        val transform: (List<Char>) -> List<Char> = TODO()

        val charsList = words
                .flatMap(transform)
                .map {it.toLowerCase()}
                .sorted()
                .groupingBy{ it }
                .eachCount()
        assert(charsList.get('l')).isEqualTo(4)
    }

    @Test
    fun sequenceAndTake() {

        var num = 1
        var prevNum = 1
        val fibonacci = generateSequence {
            num + prevNum
        }

        assert(fibonacci.take(10).last()).isEqualTo(144)

    }

}