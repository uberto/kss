package com.ubertob.kotlin.kss.intro01

import assertk.assertThat
import assertk.assertions.containsAll
import assertk.assertions.containsNone
import assertk.assertions.hasSize
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class BasicTypesTest {

    //Basic rule: never change the assertions!

    @Test
    fun valOrVar(){

        var iCanChange = 5

        val iCannotChange = "42".toInt()

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
        """.trimIndent()

        assertThat(multiline.lines().size).isEqualTo(4)

    }

    @Test
    fun templateString(){

        //change string to pass the test
        val mid = "123"
        val letters = "a $mid d".trimIndent()

        assertThat(letters).isEqualTo("a b c d")

    }


    @Test
    fun rangeChar(){

        val str = "hello123"
        var strip = ""
        for (c in str) {
            //fix the range to pass the test
            strip += if (c in 'a'..'a') c else '_'
        }

        assertThat(strip).isEqualTo("hello___")

    }


    @Test
    fun rangeNum(){

        var tot = 0

        //find the right range for the for loop
        for (x in 1 .. 10) {
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
                rev += s[i]
            }
            return rev
        }

        assertThat(reverse("Hello")).isEqualTo("olleH")

    }

    @Test
    fun arrays(){
        // fix the arguments to make test pass
        val odds: Array<Int> = arrayOf(1,2,3)

        val odds2 = (1 .. 10 step 2).toList().toTypedArray()

        assertThat(odds).isEqualTo(odds2)
    }


    @Test
    fun mutableList(){

        val myList: MutableList<Int> = mutableListOf()

        for (i in 1 .. 10){  //change the range to make test pass
            myList.add(i)
        }

        assertThat(myList).hasSize(42)

    }


    @Test
    fun immutableList(){

        val myList = (1 .. 10).toList()

        //add something to myList2 constructor to make the test pass
        val myList2 = listOf(1,2,3,4)

        assertThat(myList).isEqualTo(myList2)

    }


    @Test
    fun listPlusOperator(){

        val nums = ('1' .. '9').toList()

        val chars = ('a'..'z').toList()

        // fix the lists combination
        val all = nums + chars

        assertThat(all).containsAll('a', 'z', '0', '9')
    }

    @Test
    fun listMinusOperator(){

        //find the error
        val chars = ('a'..'z').toList()
        val vowels = listOf('a', 'e', 'u')

        val consonants = chars - vowels

        assertThat(consonants).containsAll('b', 'k', 'z')
        assertThat(consonants).containsNone('a', 'e', 'i', 'o', 'u')
    }

    @Test
    fun joinString(){

        val names = listOf("John", "Horton", "Conway")

        // substitute TODO with the correct function
        val fullName: String = TODO()

        assertThat(fullName).isEqualTo("John Horton Conway")

    }

}