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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;

        int lh = height(root.left);
        int rh = height(root.right);

        max = Math.max(max, root.val + lh + rh);

        maxPathSum(root.left);
        maxPathSum(root.right);

        return max;
    }
    public int height(TreeNode node){
        if(node == null) return 0;
        int lh = height(node.left);
        int rh = height(node.right);

        return Math.max(0, node.val + Math.max(lh, rh));
    }
}