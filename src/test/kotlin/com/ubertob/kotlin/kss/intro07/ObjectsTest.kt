package com.ubertob.kotlin.kss.intro07

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isLessThan
import org.junit.jupiter.api.Test
import java.time.Instant
import kotlin.random.Random

class ObjectsTest {

    data class User (val name: String, val since: Instant) {
        companion object {
            fun createRnd():User = User(name = "user" + Random.nextInt(1000), since = Instant.now())
        }
    }

    @Test
    fun companionObjectLikeStaticMethod(){

        val u1 = User.createRnd()
        Thread.sleep(1)
        val u2 = User.createRnd()

        assertk.assertThat(u1.since).isLessThan(u2.since)

    }

    sealed class OptionType{
        object Call: OptionType()
        object Put: OptionType()
    }

    @Test
    fun objectLikeEnum(){

        val u1 = User.createRnd()
        Thread.sleep(1)
        val u2 = User.createRnd()

        assertk.assertThat(u1.since).isLessThan(u2.since)

    }

    //Algebraic Data Type
    sealed class TreeNode{
        object Root: TreeNode()  //root of the tree has no parent
        data class Leaf(val parent: TreeNode, val value: Int): TreeNode()
    }

    @Test
    fun nodeTree(){
        fun desc(node: TreeNode): String =
        when (node){
            is TreeNode.Root -> "root"
            is TreeNode.Leaf -> "leaf ${node.value}"
        }

        assertThat(desc(TreeNode.Root)).isEqualTo("root")
        assertThat(desc(TreeNode.Leaf(TreeNode.Root, 42))).isEqualTo("leaf 42")
    }


    @Test
    fun navigateTree(){
        val n1 = TreeNode.Leaf(TreeNode.Root, 3)
        val n2 = TreeNode.Leaf(n1, 4)
        val n3 = TreeNode.Leaf(n1, 5)
        val n4 = TreeNode.Leaf(n2, 6)


        fun partialsum(node: TreeNode, acc: Int): Int =
                when(node){
                    is TreeNode.Root -> acc
                    is TreeNode.Leaf -> partialsum(node.parent, acc + node.value)
                }

        fun sumToRoot(node: TreeNode): Int =  //return the sum of values of all parents from node to root
            partialsum(node, 0)


        assertThat(sumToRoot(n3)).isEqualTo(8)
        assertThat(sumToRoot(n4)).isEqualTo(13)

    }

    //object can be used as a singleton
    object MyCache: HashMap<String, Int>()


    @Test
    fun objectAsSingleton(){

        //assign some values to the cache to pass the test
        MyCache["ten"] = 10
        MyCache["five"] = 5

        assertThat(MyCache["ten"]).isEqualTo(10)
        assertThat(MyCache["five"]).isEqualTo(5)

    }

    @Test
    fun objectAsInstanceOfAnonClass(){

        val firstOddNumbers = object : Comparator<Int> {
            override fun compare(o1: Int, o2: Int): Int =
                    if (o1.isOdd() && !o2.isOdd()) {
                        -1
                    } else if (!o1.isOdd() && o2.isOdd()) {
                        1
                    } else{
                        o1 - o2
                    }

        }

        val sortedList = listOf(4,6,2,6,7,9,0,5).sortedWith(firstOddNumbers)

        assertThat(sortedList.first()).isEqualTo(5)

    }


}

private fun Int.isOdd(): Boolean = this % 2 == 1
