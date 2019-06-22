package com.vathevor.javalgo.bst;

import com.vathevor.javalgo.bst.model.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BstUtilTest {

    @Test
    void shouldBeValid() {
        TreeNode<Integer> leftOfLeft = new TreeNode<>(1);
        TreeNode<Integer> rightOfLeft = new TreeNode<>(3);
        TreeNode<Integer> left = new TreeNode<>(2, leftOfLeft, rightOfLeft);
        TreeNode<Integer> leftOfRight = new TreeNode<>(5);
        TreeNode<Integer> rightOfRight = new TreeNode<>(7);
        TreeNode<Integer> right = new TreeNode<>(6, leftOfRight, rightOfRight);
        TreeNode<Integer> root = new TreeNode<>(4, left, right);

        boolean valid = BstUtil.isValid(root);

        assertTrue(valid);
    }

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
}