package com.vathevor.javalgo.bst;

import com.vathevor.javalgo.bst.model.TreeNode;

public class BstUtil {

    /**
     * Determines if the given Binary Search Tree is valid.
     * It is valid if:
     * The left subtree of a node contains only nodes with value less than the node's value.
     * The right subtree of a node contains only nodes with greater than the node's value.
     * Bot the left and right subtree is Binary Search Trees.
     */
    static boolean isValid(TreeNode<Integer> root) {
        return isValid(root, null, null);
    }

    private static boolean isValid(TreeNode<Integer> node, Integer low, Integer high) {
        if (node == null) {
            return true;
        }
        return (low == null || low < node.getValue()) &&
                (high == null || node.getValue() < high) &&
                isValid(node.getLeft(), low, node.getValue()) &&
                isValid(node.getRight(), node.getValue(), high);
    }
}
