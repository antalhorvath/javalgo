package com.vathevor.javalgo.bst;

/*
 * Design a class to find the kth largest element in a stream.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Your KthLargest class will have a constructor which accepts an integer k
 * and an integer array nums, which contains initial elements from the stream.
 *
 * For each call to the method KthLargest.add,
 * return the element representing the kth largest element in the stream.
 *
 * Example
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5
 * kthLargest.add(9);   // returns 8
 * kthLargest.add(4);   // returns 8
 */
public class KthLargest {

    public static class TreeNode {

        private Integer value;
        private Integer numberOfNodes;
        private TreeNode left;
        private TreeNode right;

        TreeNode(Integer value) {
            this.value = value;
            this.numberOfNodes = 1;
        }
    }

    private static TreeNode insert(TreeNode root, int value) {
        if (root == null) {
            return new TreeNode(value);
        }
        TreeNode node = root;
        TreeNode parent = root;

        boolean valueGoesLeft = true;
        while (node != null) {
            parent = node;
            valueGoesLeft = value < node.value;
            node.numberOfNodes++;
            if (valueGoesLeft) {
                node = node.left;
            } else {
                node = node.right;
            }
        }

        if (valueGoesLeft) {
            parent.left = new TreeNode(value);
        } else {
            parent.right = new TreeNode(value);
        }
        return root;
    }

    private TreeNode root;
    private Integer k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.root = null;
        for (int num : nums) {
            root = insert(root, num);
        }
    }

    public int add(int val) {
        insert(root, val);
        return getKthLargest(root, k);
    }

    private int getKthLargest(TreeNode root, int k) {
        int m = root.right != null ? root.right.numberOfNodes : 0;
        // root is the m + 1 largest node in the BST
        if (k == m + 1) {
            return root.value;
        }
        if (k <= m) {
            // find kth largest in the right subtree
            return getKthLargest(root.right, k);
        } else {
            // find (k-m-1)th largest in the left subtree
            return getKthLargest(root.left, k - m - 1);
        }
    }
}
