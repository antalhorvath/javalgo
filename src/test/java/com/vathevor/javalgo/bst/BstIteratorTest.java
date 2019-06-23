package com.vathevor.javalgo.bst;

import com.vathevor.javalgo.bst.model.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BstIteratorTest {

    private static final TreeNode<Integer> BST_01_ROOT;

    static {
        /*
         *         7
         *       /   \
         *      3     15
         *           /  \
         *          9    20
         */
        TreeNode<Integer> leftOf7 = new TreeNode<>(3);
        TreeNode<Integer> leftOf15 = new TreeNode<>(9);
        TreeNode<Integer> rightOf15 = new TreeNode<>(20);
        TreeNode<Integer> rightOf7 = new TreeNode<>(15, leftOf15, rightOf15);
        BST_01_ROOT = new TreeNode<>(7, leftOf7, rightOf7);
    }

    @Test
    void testIterator() {
        BstIterator iterator = new BstIterator(BST_01_ROOT);
        assertEquals(3, iterator.next());
        assertEquals(7, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(9, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(15, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(20, iterator.next());
        assertFalse(iterator.hasNext());
    }
}