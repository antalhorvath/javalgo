package com.vathevor.javalgo.bst.model;

public class TreeNode {

    private Integer value;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(Integer value) {
        this.value = value;
    }

    public TreeNode(Integer value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public Integer getValue() {
        return value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
