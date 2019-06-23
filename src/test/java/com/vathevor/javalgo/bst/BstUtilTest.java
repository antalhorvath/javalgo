package com.vathevor.javalgo.bst;

import com.vathevor.javalgo.bst.model.TreeNode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.util.Objects.isNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BstUtilTest {

    private static final TreeNode<Integer> NOT_VALID_BST_ROOT;
    private static final TreeNode<Integer> BST_01_ROOT;
    private static final TreeNode<Integer> BST_02_ROOT;
    private static final TreeNode<Integer> BST_03_ROOT;

    static {
        /*
         *         5
         *       /   \
         *      1     4
         *           / \
         *          3   6
         */
        TreeNode<Integer> left = new TreeNode<>(1);
        TreeNode<Integer> leftOf4 = new TreeNode<>(3);
        TreeNode<Integer> rightOf4 = new TreeNode<>(6);
        TreeNode<Integer> right = new TreeNode<>(4, leftOf4, rightOf4);
        NOT_VALID_BST_ROOT = new TreeNode<>(5, left, right);
    }

    static {
        /*
         *           4
         *         /   \
         *        2     6
         *       / \   / \
         *      1   3 5   7
         */
        TreeNode<Integer> leftOfLeft = new TreeNode<>(1);
        TreeNode<Integer> rightOfLeft = new TreeNode<>(3);
        TreeNode<Integer> left = new TreeNode<>(2, leftOfLeft, rightOfLeft);
        TreeNode<Integer> leftOfRight = new TreeNode<>(5);
        TreeNode<Integer> rightOfRight = new TreeNode<>(7);
        TreeNode<Integer> right = new TreeNode<>(6, leftOfRight, rightOfRight);
        BST_01_ROOT = new TreeNode<>(4, left, right);
    }

    static {
        /*
         *          20
         *         /  \
         *        8    22
         *       / \
         *      4   12
         *         /  \
         *       10    14
         */
        TreeNode<Integer> leftOf12 = new TreeNode<>(10);
        TreeNode<Integer> rightOf12 = new TreeNode<>(14);
        TreeNode<Integer> leftOf8 = new TreeNode<>(4);
        TreeNode<Integer> rightOf8 = new TreeNode<>(12, leftOf12, rightOf12);
        TreeNode<Integer> leftOf20 = new TreeNode<>(8, leftOf8, rightOf8);
        TreeNode<Integer> rightOf20 = new TreeNode<>(22);
        BST_02_ROOT = new TreeNode<>(20, leftOf20, rightOf20);
    }

    static {
        /*
         *           15
         *         /    \
         *       10      20
         *       / \    /  \
         *      8  12  16  25
         */
        TreeNode<Integer> leftOf10 = new TreeNode<>(8);
        TreeNode<Integer> rightOf10 = new TreeNode<>(12);
        TreeNode<Integer> leftOf15 = new TreeNode<>(10, leftOf10, rightOf10);
        TreeNode<Integer> leftOf20 = new TreeNode<>(16);
        TreeNode<Integer> rightOf20 = new TreeNode<>(25);
        TreeNode<Integer> rightOf15 = new TreeNode<>(20, leftOf20, rightOf20);
        BST_03_ROOT = new TreeNode<>(15, leftOf15, rightOf15);
    }

    @Test
    void shouldBeValid() {
        boolean valid = BstUtil.isValid(BST_01_ROOT);

        assertTrue(valid);
    }

    @Test
    void shouldBeInvalid() {
        boolean valid = BstUtil.isValid(NOT_VALID_BST_ROOT);

        assertFalse(valid);
    }

    @Test
    void shouldReturnTheNodeWithValueTwoAs() {
        TreeNode<Integer> node = new TreeNode<>(1);

        TreeNode<Integer> inorderSuccessor = BstUtil.getInorderSuccessor(BST_01_ROOT, node);

        assertEquals(2, inorderSuccessor.getValue());
    }

    /*
    In Binary Search Tree, Inorder Successor of an input node can also be defined as
    the node with the smallest key greater than the key of input node.
     */
    @ParameterizedTest
    @MethodSource("inorderSuccessorTestCases")
    void shouldReturnInorderSuccessor(TestCase testCase) {
        TreeNode<Integer> node = new TreeNode<>(testCase.nodeValue);

        TreeNode<Integer> inorderSuccessor = BstUtil.getInorderSuccessor(BST_02_ROOT, node);

        assertEquals(testCase.expectedResult, inorderSuccessor.getValue());
    }

    private static class TestCase {
        int nodeValue;
        Integer expectedResult;

        private TestCase(int nodeValue, Integer expectedResult) {
            this.nodeValue = nodeValue;
            this.expectedResult = expectedResult;
        }

        static TestCase of(int nodeValue, Integer expectedResult) {
            return new TestCase(nodeValue, expectedResult);
        }

    }

    static Stream<TestCase> inorderSuccessorTestCases() {
        return Stream.of(
                TestCase.of(8, 10),
                TestCase.of(10, 12),
                TestCase.of(14, 20));
    }


    /*
    In Binary Search Tree, Inorder Predecessor of an input node can also be defined as
    the node with the greater key less than the key of input node.
     */
    @ParameterizedTest
    @MethodSource("bst02InorderPredecessorTestCases")
    void givenBst02_whenGetInorderPredecessor_thenReturnExpectedValue(TestCase testCase) {
        TreeNode<Integer> node = new TreeNode<>(testCase.nodeValue);

        TreeNode<Integer> inorderSuccessor = BstUtil.getInorderPredecessor(BST_02_ROOT, node);

        assertEquals(testCase.expectedResult, inorderSuccessor.getValue());
    }

    static Stream<TestCase> bst02InorderPredecessorTestCases() {
        return Stream.of(
                TestCase.of(10, 8),
                TestCase.of(12, 10),
                TestCase.of(20, 14));
    }

    @ParameterizedTest
    @MethodSource("bst03InorderPredecessorTestCases")
    void givenBst03_whenGetInorderPredecessor_thenReturnExpectedValue(TestCase testCase) {
        TreeNode<Integer> node = new TreeNode<>(testCase.nodeValue);

        TreeNode<Integer> inorderSuccessor = BstUtil.getInorderPredecessor(BST_03_ROOT, node);

        if (isNull(testCase.expectedResult)) {
            assertNull(inorderSuccessor);
        } else {
            assertEquals(testCase.expectedResult, inorderSuccessor.getValue());
        }
    }

    static Stream<TestCase> bst03InorderPredecessorTestCases() {
        return Stream.of(
                TestCase.of(8, null),
                TestCase.of(10, 8),
                TestCase.of(20, 16));
    }
}