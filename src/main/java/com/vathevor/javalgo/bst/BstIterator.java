package com.vathevor.javalgo.bst;

import com.vathevor.javalgo.bst.model.TreeNode;

import java.util.Stack;

/*
 * Implement an iterator over a binary search tree (BST).
 * Your iterator will be initialized with the root node of a BST.
 * next() and hasNext() should run in average O(1) time
 * and uses O(h) memory, where h is the height of the tree.
 */
public class BstIterator {

    private Stack<TreeNode> stack;

    public BstIterator(TreeNode root) {
        stack = new Stack<>();
        pushAllNodesOf(root);
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode currentNode = stack.pop();
        pushAllNodesOf(currentNode.getRight());
        return currentNode.getValue();
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushAllNodesOf(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.getLeft();
        }
    }
}
