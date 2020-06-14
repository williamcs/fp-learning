package rank.practice.func_structure

import scala.collection.mutable

/**
  * A binary tree is a tree where each node has at most two children.
  * It is characterized by any of the following properties:
  *
  * It can be an empty tree, where root = null.
  * It can contain a root node which contain some value and two subtree, left subtree and right subtree,
  * which are also binary tree.
  * A binary tree is a binary search tree (BST) if all the non-empty nodes follows both two properties:
  *
  * Each node's left subtree contains only values less than it, and
  * Each node's right subtree contains only values greater than it.
  * Preorder traversal is a tree traversal method where the current node is visited first,
  * then the left subtree and then the right subtree. More specifically,
  * let's represent the preorder traversal of a tree by a list. Then this list is constructed in following way:
  *
  * If the tree is empty, then this list be a null list.
  * For non-empty tree, let's represent the preorder of left subtree as L and of right subtree as R.
  * Then the preorder of tree is obtained by appending L to current node, and then appending R to it.
  *
  * 1         2          3
  * \       / \        / \
  * 3     1   3      2   5
  * /                /   / \
  * 2                1   4   6
  * (a)       (b)        (c)
  * For the above trees, preorder will be
  *
  * (a) 1 3 2
  * (b) 2 1 3
  * (c) 3 2 1 5 4 6
  * Given a list of numbers, determine whether it can represent the preorder traversal of a binary search tree(BST).
  *
  * Input
  * The first line contains the number of test cases, T. Then T test cases follow.
  * The first line of each test case contains the number of nodes in the tree, N.
  * In next line there will a list of N unique numbers, where each number is from set [1, N].
  *
  * Output
  * For each test case, print "YES" if there's exist a BST whose preorder is equal to the list otherwise "NO" (without quotes).
  *
  * Constraints
  * 1 <= T <= 10
  * 1 <= N <= 100
  *
  * Sample Input
  *
  * 5
  * 3
  * 1 2 3
  * 3
  * 2 1 3
  * 6
  * 3 2 1 5 4 6
  * 4
  * 1 3 4 2
  * 5
  * 3 4 5 1 2
  * Sample Output
  *
  * YES
  * YES
  * YES
  * NO
  * NO
  * Explanation
  * First three cases are from examples. And last two test cases are invalid because the subtree for 3 is not valid as 2 and 4 are in the wrong order.
  *
  *
  * https://www.geeksforgeeks.org/check-if-a-given-array-can-represent-preorder-traversal-of-binary-search-tree/
  *
  */
object ValidBST {

  def isValidBST(preorder: Array[Int]): Boolean = {
    val stack: mutable.Stack[Int] = new mutable.Stack[Int]()

    var root = Int.MinValue

    for (ele <- preorder) {
      if (ele < root) {
        return false
      }

      while (!stack.isEmpty && stack.top < ele) {
        root = stack.top
        stack.pop()
      }

      stack.push(ele)
    }

    true
  }

  def isValidBST(preorder: Array[Int], start: Int, end: Int): Boolean = {
    if (start >= end) true
    else {
      val root = preorder(start)
      val nextLargerIndex = preorder.indexWhere(_ > root, start + 1)

      if (nextLargerIndex == -1) {
        isValidBST(preorder, start + 1, end)
      } else {
        isValidBST(preorder, start + 1, nextLargerIndex) &&
        !lesserExists(preorder, root, nextLargerIndex, end) &&
        isValidBST(preorder, nextLargerIndex, end)
      }
    }
  }

  def lesserExists(preorder: Array[Int], root: Int, start: Int, end: Int): Boolean = {
    for (i <- start until end) {
      if (preorder(i) < root) {
        return true
      }
    }

    false
  }

  def test(): Unit = {
    for (_ <- 0 until scala.io.StdIn.readInt) {
      val n = scala.io.StdIn.readInt
      val preorder = scala.io.StdIn.readLine.split(" ").map(_.toInt)

      if (isValidBST(preorder)) {
        println("YES")
      } else {
        println("NO")
      }
    }
  }

  def isBST(xs: List[Int]): Boolean = xs match {
    case Nil => true
    case head :: tail => {
      val (l, r) = tail.span(_ < head)
      if (r.exists(_ < head))
        false
      else
        isBST(l) && isBST(r)
    }
  }

  def test1(): Unit = {
    val t = scala.io.StdIn.readInt
    for (i <- 0 until t) {
      val n = scala.io.StdIn.readInt
      val xs = scala.io.StdIn.readLine.split(" ").map(_.toInt).toList
      println(if (isBST(xs)) "YES" else "NO")
    }
  }

  def main(args: Array[String]): Unit = {
    test1()
  }
}
