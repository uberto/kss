package com.ubertob.kotlin.kss.intro08

import assertk.assert
import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test
import java.util.*

class AdvancedFunTest {

    tailrec fun sillyMulti(x: Int, times: Int, a: Int = 0): Int {
        return if (times == 0) a
        else TODO()
    }


    @Test
    fun tailRecursionSafe(){

        val res = sillyMulti(3, 50000)

        assertThat(res).isEqualTo(150000)

    }

    @Test
    fun classExtension(){

        fun Int.hello(): String = TODO()

        assertk.assertThat(5.hello()).isEqualTo("Hi, I'm 5")
        assertk.assertThat(42.hello()).isEqualTo("Hi, I'm 42")

    }

    @Test
    fun nullableClassExtension(){

        fun Int?.hello(): String = TODO()

        assertk.assertThat(5.hello()).isEqualTo("Hi, I'm 5")
        assertk.assertThat(null.hello()).isEqualTo("Hi, I'm no one")

    }

    @Test
    fun infixNotation(){

        infix fun <A,B>A.pp(other: B): Pair<A,B> = TODO()

        assertk.assertThat(5 pp 8).isEqualTo(Pair(5, 8))
        assertk.assertThat("joe" pp 45).isEqualTo(Pair("joe", 45))

    }


    @Test
    fun funNames(){

        infix fun <A,B>A.`@`(other: B): Pair<A,B> = TODO()

        assertk.assertThat(5 `@` 8).isEqualTo(Pair(5, 8))
        assertk.assertThat("joe" `@` 45).isEqualTo(Pair("joe", 45))

    }


    interface DbContext{
        fun DbContext.fetchFromDb(key: String):String
    }

    class InMemDb: DbContext{
        override fun DbContext.fetchFromDb(key: String): String {
            TODO()
        }
    }

    @Test
    fun extFunInScoped(){
        val dbConn = InMemDb()

        dbConn.apply {
            val userName = fetchFromDb("u1234")

            assertThat(userName).isEqualTo("joe")
        }

    }


    inline fun <reified T> getOrDefault(value: T?):T {
        return if (value == null)
            T::class.java.getDeclaredConstructor().newInstance()
        else
            value
    }

    @Test
    fun reifiedGeneric(){

        val s1 = getOrDefault(" ") //find the value to make test pass
        val s2 = getOrDefault<String>(null)

        assertThat(s1).isEqualTo(s2)

        val d1 = getOrDefault(Date(0)) //find the value to make test pass
        val d2 = getOrDefault<Date>(null)

        assertThat(d1.toString()).isEqualTo(d2.toString())

    }

}