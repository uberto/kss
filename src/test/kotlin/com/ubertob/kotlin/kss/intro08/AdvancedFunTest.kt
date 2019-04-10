package com.ubertob.kotlin.kss.intro08

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test
import java.util.*

class AdvancedFunTest {

    tailrec fun sillyMulti(x: Int, times: Int, a: Int = 0): Int {
        return if (times == 0) a
        else sillyMulti(x , times -1, a + x)
    }


    @Test
    fun tailRecursionSafe(){
        //fix the sillyMulti function to make the test work
        val res = sillyMulti(3, 50000)

        assertThat(res).isEqualTo(150000)

    }

    @Test
    fun classExtension(){

        fun Int.hello(): String = "Hi, I'm $this"

        assertThat(5.hello()).isEqualTo("Hi, I'm 5")
        assertThat(42.hello()).isEqualTo("Hi, I'm 42")

    }

    @Test
    fun nullableClassExtension(){

        fun Int?.hello(): String = "Hi, I'm " + (this ?: "no one")

        assertThat(5.hello()).isEqualTo("Hi, I'm 5")
        assertThat(null.hello()).isEqualTo("Hi, I'm no one")

    }

    @Test
    fun infixNotation(){

        infix fun <A,B>A.pp(other: B): Pair<A,B> = Pair(this, other)

        assertThat(5 pp 8).isEqualTo(Pair(5, 8))
        assertThat("joe" pp 45).isEqualTo(Pair("joe", 45))

    }


    @Test
    fun funNames(){

        infix fun <A,B>A.`@`(other: B): Pair<A,B> = Pair(this, other)

        assertThat(5 `@` 8).isEqualTo(Pair(5, 8))
        assertThat("joe" `@` 45).isEqualTo(Pair("joe", 45))

    }


    interface DbContext{
        fun DbContext.fetchFromDb(id: Int):String
    }

    class InMemDb: DbContext{
        override fun DbContext.fetchFromDb(id: Int): String = when (id){
            1 -> "Joe"
            2 -> "Fred"
            else -> "No one"
        }
    }

    @Test
    fun extFunInScoped(){
        val dbConn = InMemDb()

        dbConn.apply {

            assertThat(fetchFromDb(1)).isEqualTo("Joe")
            assertThat(fetchFromDb(2)).isEqualTo("Fred")
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

        val s1 = getOrDefault("") //find the value to make test pass
        val s2 = getOrDefault<String>(null)

        assertThat(s1).isEqualTo(s2)

        val d1 = getOrDefault(Date()) //find the value to make test pass
        val d2 = getOrDefault<Date>(null)

        assertThat(d1.toString()).isEqualTo(d2.toString())

    }

}

//left to cover:
//types Unit, Nothing, Generics in/out, Any?
//scope functions, receiver lambdas, currying
//interfaces, open class, by, properties, invoke
//coroutines