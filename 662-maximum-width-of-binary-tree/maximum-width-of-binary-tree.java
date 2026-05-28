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
    class Pair{
        int index;
        TreeNode node;
        Pair(TreeNode node, int index){
            this.node = node;
            this.index = index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        int maxwidth = 0;
        if(root == null) return maxwidth;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while(!q.isEmpty()){
            int size = q.size();
            int min = q.peek().index;

            int first = 0;
            int last = 0;

            for(int i=0; i<size; i++){
                Pair pair = q.poll();
                TreeNode node = pair.node;
                int currindex = pair.index-min;

                if(i == 0) first = currindex;
                if(i == size-1) last = currindex;

                if(node.left != null) q.add(new Pair(node.left, 2*currindex+1));
                if(node.right != null) q.add(new Pair(node.right, 2*currindex+2));
            }
            maxwidth = Math.max(maxwidth, last-first+1);
        }
        return maxwidth;
    }
}