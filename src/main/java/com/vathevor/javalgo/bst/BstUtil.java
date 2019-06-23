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
    static boolean isValid(TreeNode root) {
        return isValid(root, null, null);
    }

    private static boolean isValid(TreeNode node, Integer low, Integer high) {
        if (node == null) {
            return true;
        }
        return (low == null || low < node.getValue()) &&
                (high == null || node.getValue() < high) &&
                isValid(node.getLeft(), low, node.getValue()) &&
                isValid(node.getRight(), node.getValue(), high);
    }

    /**
     * Determines the successor of the given node in the Binary Search Tree.
     *
     * @param root the root node of the Binary Search Tree
     * @param node the node whose successor should be returned
     * @return the successor of given node
     */
    static TreeNode getInorderSuccessor(TreeNode root, TreeNode node) {
        TreeNode successor = null;
        while (root != null) {
            if (node.getValue() < root.getValue()) {
                successor = root;
                root = root.getLeft();
            } else {
                root = root.getRight();
            }
        }
        return successor;
    }


    /**
     * Determines the predecessor of the given node in the Binary Search Tree.
     *
     * @param root the root node of the Binary Search Tree
     * @param node the node whose successor should be returned
     * @return the successor of given node
     */
    static TreeNode getInorderPredecessor(TreeNode root, TreeNode node) {
        TreeNode predecessor = null;
        while (root != null) {
            if (node.getValue().equals(root.getValue())) {
                root = root.getLeft();
            } else if (node.getValue() < root.getValue()) {
                root = root.getLeft();
            } else {
                predecessor = root;
                root = root.getRight();
            }
        }
        return predecessor;
    }

    /**
     * Finds the TreeNode by value in the Binary Search Tree.
     *
     * @param root  root of the BST
     * @param value value of TreeNode to find
     * @return the found TreeNode or null BST does not contain such value
     */
    static TreeNode search(TreeNode root, int value) {
        TreeNode node = root;
        while (node != null && !node.getValue().equals(value)) {
            if (value < node.getValue()) {
                node = node.getLeft();
            } else {
                node = node.getRight();
            }
        }
        return node;
    }

    /**
     * Inserts a node into the Binary Search Tree.
     *
     * @param root  root of the BST
     * @param value value of TreeNode to insert
     * @return the found TreeNode or null BST does not contain such value
     */
    static TreeNode insert(TreeNode root, int value) {
        return null;
    }
}
