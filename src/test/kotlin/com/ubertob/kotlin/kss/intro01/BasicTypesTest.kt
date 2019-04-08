package com.ubertob.kotlin.kss.intro01

import assertk.assertThat
import assertk.assertions.*
import org.junit.jupiter.api.Test

class BasicTypesTest {

    //Basic rule: never change the assertions!

    @Test
    fun valOrVar(){

        var iCanChange = 5

        val iCannotChange = "42".toInt()

        iCanChange = 42
        //add something here to make it pass

        assertThat(iCanChange).isEqualTo(iCannotChange)

    }


    @Test
    fun multilineString(){

        //change string to pass the test
        val multiline = """
            line 1
            line 2
            line 3
            line 4
        """.trimIndent()

        assertThat(multiline.lines().size).isEqualTo(4)

    }

    @Test
    fun templateString(){

        //change string to pass the test
        val mid = "b c"
        val letters = "a $mid d".trimIndent()

        assertThat(letters).isEqualTo("a b c d")

    }


    @Test
    fun rangeChar(){

        val str = "hello123"
        var strip = ""
        for (c in str) {
            //fix the range to pass the test
            strip += if (c in 'a'..'z') c else '_'
        }

        assertThat(strip).isEqualTo("hello___")

    }


    @Test
    fun rangeNum(){

        var tot = 0

        //find the right range
        for (x in 1 .. 24) {
            tot += x * x
        }

        assertThat(tot).isEqualTo(70*70)

    }

    @Test
    fun downTo(){

        fun reverse(s: String): String{
            var rev = ""
            //find the right range
            for (i in s.length.downTo(1)) {
                rev += s[i - 1]
            }
            return rev
        }

        assertThat(reverse("Hello")).isEqualTo("olleH")

    }

    @Test
    fun arrays(){
        // fix the arguments to make test pass
        val odds: Array<Int> = arrayOf(1,3,5,7,9)

        val odds2 = (1 .. 10 step 2).toList().toTypedArray()

        assertThat(odds).containsExactly(*odds2)
    }


    @Test
    fun mutableList(){

        val myList: MutableList<Int> = mutableListOf()
        (1 .. 42).forEach{ myList.add(it) }

        assertThat(myList).hasSize(42)

    }


    @Test
    fun immutableList(){

        val myList = (1 .. 10).toList()

        var myList2 = listOf(1,2,3,4)

        myList2 += listOf(5,6,7,8,9,10)
        //add something to myList2 to make the test pass

        assertThat(myList).containsExactly(*myList2.toTypedArray())

    }


    @Test
    fun listPlusOperator(){

        val nums = ('0' .. '9').toList()

        val chars = ('a'..'z').toList()

        val all = nums + chars

        assertThat(all).containsAll('a', 'z', '0', '9')
    }

    @Test
    fun listMinusOperator(){

        val chars = ('a'..'z').toList()
        val vowels = listOf('a', 'e', 'i', 'o', 'u')

        val consonants = chars - vowels

        assertThat(consonants).containsAll('b', 'k', 'z')
        assertThat(consonants).containsNone('a', 'e', 'i', 'o', 'u')
    }

    @Test
    fun joinString(){

        val names = listOf("John", "Horton", "Conway")
        val fullName: String = names.joinToString(" ")

        assertThat(fullName).isEqualTo("John Horton Conway")

    }

}