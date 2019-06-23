package com.vathevor.javalgo.bst;

import com.vathevor.javalgo.bst.model.TreeNode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BstUtilTest {

    @Test
    void shouldBeValid() {
        TreeNode<Integer> root = createValidBinarySearchTree();

        boolean valid = BstUtil.isValid(root);

        assertTrue(valid);
    }

    /*
             4
           /   \
          2     6
         / \   / \
        1   3 5   7
     */
    private TreeNode<Integer> createValidBinarySearchTree() {
        TreeNode<Integer> leftOfLeft = new TreeNode<>(1);
        TreeNode<Integer> rightOfLeft = new TreeNode<>(3);
        TreeNode<Integer> left = new TreeNode<>(2, leftOfLeft, rightOfLeft);
        TreeNode<Integer> leftOfRight = new TreeNode<>(5);
        TreeNode<Integer> rightOfRight = new TreeNode<>(7);
        TreeNode<Integer> right = new TreeNode<>(6, leftOfRight, rightOfRight);
        return new TreeNode<>(4, left, right);
    }

    /*
         5
       /   \
      1     4
           / \
          3   6
    */
    @Test
    void shouldBeInvalid() {
        TreeNode<Integer> left = new TreeNode<>(1);
        TreeNode<Integer> leftOf4 = new TreeNode<>(3);
        TreeNode<Integer> rightOf4 = new TreeNode<>(6);
        TreeNode<Integer> right = new TreeNode<>(4, leftOf4, rightOf4);
        TreeNode<Integer> root = new TreeNode<>(5, left, right);

        boolean valid = BstUtil.isValid(root);

        assertFalse(valid);
    }

    @Test
    void shouldReturnTheNodeWithValueTwoAs() {
        TreeNode<Integer> root = createValidBinarySearchTree();
        TreeNode<Integer> node = new TreeNode<>(1);

        TreeNode<Integer> inorderSuccessor = BstUtil.getInorderSuccessor(root, node);

        assertEquals(2, inorderSuccessor.getValue());
    }

    /*
    In Binary Search Tree, Inorder Successor of an input node can also be defined as
    the node with the smallest key greater than the key of input node.
     */
    @ParameterizedTest
    @MethodSource("inorderSuccessorTestCases")
    void shouldReturnInorderSuccessor(TestCase testCase) {
        TreeNode<Integer> root = createAnotherValidBinarySearchTree();
        TreeNode<Integer> node = new TreeNode<>(testCase.nodeValue);

        TreeNode<Integer> inorderSuccessor = BstUtil.getInorderSuccessor(root, node);

        assertEquals(testCase.expectedInorderSuccessor, inorderSuccessor.getValue());
    }

    private static class TestCase {
        int nodeValue;
        int expectedInorderSuccessor;

        private TestCase(int nodeValue, int expectedInorderSuccessor) {
            this.nodeValue = nodeValue;
            this.expectedInorderSuccessor = expectedInorderSuccessor;
        }

        static TestCase of(int nodeValue, int expectedInorderSuccessor) {
            return new TestCase(nodeValue, expectedInorderSuccessor);
        }
    }

    static Stream<TestCase> inorderSuccessorTestCases() {
        return Stream.of(
                TestCase.of(8, 10),
                TestCase.of(10, 12),
                TestCase.of(14, 20));
    }

    /*
            20
           /  \
          8    22
         / \
        4   12
           /  \
         10    14
     */
    private TreeNode<Integer> createAnotherValidBinarySearchTree() {
        TreeNode<Integer> leftOf12 = new TreeNode<>(10);
        TreeNode<Integer> rightOf12 = new TreeNode<>(14);
        TreeNode<Integer> leftOf8 = new TreeNode<>(4);
        TreeNode<Integer> rightOf8 = new TreeNode<>(12, leftOf12, rightOf12);
        TreeNode<Integer> leftOf20 = new TreeNode<>(8, leftOf8, rightOf8);
        TreeNode<Integer> rightOf20 = new TreeNode<>(22);
        return new TreeNode<>(20, leftOf20, rightOf20);
    }

}