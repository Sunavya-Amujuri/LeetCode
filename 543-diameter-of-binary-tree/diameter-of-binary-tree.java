/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
       if(root == null) return 0;

        int left = height(root.left);
        int right = height(root.right);

        int currdiameter = left + right;

        int leftdia = diameterOfBinaryTree(root.left);
        int rightdia = diameterOfBinaryTree(root.right);

        return Math.max(currdiameter, Math.max(leftdia, rightdia));
    }
    public static int height(TreeNode node){
        if(node == null) return 0;

        return 1 + Math.max(height(node.left), height(node.right));
    }
}