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
    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode curr = root;
        List<Integer> res = new ArrayList<>();

        while(curr != null){
            if(curr.left == null){
                res.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode prev = curr.left;
                // find IP
                while(prev.right != null && prev.right != curr){
                    prev = prev.right;
                }
                if(prev.right == null){
                    // create thread
                    prev.right = curr;
                    curr = curr.left;
                } else {
                    // remove thread
                    prev.right = null;
                    res.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return res;
    }
}