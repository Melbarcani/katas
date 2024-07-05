package com.example.leet;

public class BalanceBTreeSearch {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode solutionBalance(TreeNode root) {
            if (root == null) return null;
            int left = height(root.left);
            int right = height(root.right);
            if (Math.abs(left - right) > 1) {
                if (left > right) {
                    root = rotateRight(root);
                } else {
                    root = rotateLeft(root);
                }
            }
            root.left = solutionBalance(root.left);
            root.right = solutionBalance(root.right);
            return root;
        }

        public int height(TreeNode root) {
            if (root == null) return 0;
            return 1 + Math.max(height(root.left), height(root.right));
        }

        public TreeNode rotateRight(TreeNode root) {
            TreeNode newRoot = root.left;
            root.left = newRoot.right;
            newRoot.right = root;
            return newRoot;
        }

        public TreeNode rotateLeft(TreeNode root) {
            TreeNode newRoot = root.right;
            root.right = newRoot.left;
            newRoot.left = root;
            return newRoot;
        }
    }
}
