package com.vathevor.javalgo.bst;

import com.vathevor.javalgo.bst.model.TreeNode;

public class BstUtil {

    /**
     * Determines if the given Binary Search Tree is valid.
     * It is valid if:
     * The left subtree of a node contains only nodes with value less than the node's value.
     * The right subtree of a node contains only nodes with greater than the node's value.
     * Bot the left and right subtree is Binary Search Trees.
     *
     * @param root the root node of the Binary Search Tree
     * @return the result of the validity check
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

    /**
     * Determines the successor of h given node in the Binary Search Tree.
     *
     * @param root the root node of the Binary Search Tree
     * @param node the node whose successor should be returned
     * @return the successor of given node
     */
    static TreeNode<Integer> getInorderSuccessor(TreeNode<Integer> root, TreeNode<Integer> node) {
        return null;
    }
}
