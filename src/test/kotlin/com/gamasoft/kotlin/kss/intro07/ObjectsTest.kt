package com.gamasoft.kotlin.kss.intro07

import assertk.assert
import assertk.assertions.isEqualTo
import assertk.assertions.isLessThan
import org.junit.jupiter.api.Test
import java.time.Instant

class ObjectsTest {

    data class User (val name: String, val since: Instant) {
        companion object {
            fun createRnd():User = TODO()
        }
    }

    @Test
    fun companionObjectLikeStaticMethod(){

        val u1 = User.createRnd()
        Thread.sleep(1)
        val u2 = User.createRnd()

        assertk.assert(u1.since).isLessThan(u2.since)

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

        assertk.assert(u1.since).isLessThan(u2.since)

    }

    sealed class TreeNode{
        object Root: TreeNode()
        data class Node(val parent: TreeNode, val value: Int): TreeNode()
    }

    @Test
    fun navigateAndBuildTree(){
        val n1 = TreeNode.Node(TreeNode.Root, 3)
        val n2 = TreeNode.Node(n1, 4)
        val n3 = TreeNode.Node(n1, 5)
        val n4 = TreeNode.Node(n2, 6)

        fun sumToRoot(node: TreeNode): Int = TODO() //return the sum of values of all parents from node to root

        assert(sumToRoot(n3)).isEqualTo(8)
        assert(sumToRoot(n4)).isEqualTo(13)

    }

    object MyCache: HashMap<String, String>()


    @Test
    fun objectAsSingleton(){

        TODO()

        assert(MyCache["ten"]).isEqualTo(10)
        assert(MyCache["five"]).isEqualTo(5)

    }

    @Test
    fun objectAsInstanceOfAnonClass(){

        val firstOddNumbers = object : Comparator<Int> {
            override fun compare(o1: Int?, o2: Int?): Int {
                TODO()
            }

        }

        val sortedList = listOf(4,6,2,6,7,9,0,5).sortedWith(firstOddNumbers)

        assert(sortedList.first()).isEqualTo(5)

    }


}