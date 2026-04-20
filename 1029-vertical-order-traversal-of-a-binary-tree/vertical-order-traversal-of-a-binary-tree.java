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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<Tuple> list = new ArrayList<>();

        Queue<Object[]> q = new LinkedList<>();
        q.offer(new Object[]{root, 0, 0}); // node, row, col

        // BFS
        while (!q.isEmpty()) {
            Object[] arr = q.poll();
            TreeNode node = (TreeNode) arr[0];
            int row = (int) arr[1];
            int col = (int) arr[2];

            list.add(new Tuple(col, row, node.val));

            if (node.left != null) {
                q.offer(new Object[]{node.left, row + 1, col - 1});
            }

            if (node.right != null) {
                q.offer(new Object[]{node.right, row + 1, col + 1});
            }
        }

        // Sort
        Collections.sort(list, (a, b) -> {
            if (a.col != b.col) return a.col - b.col;
            if (a.row != b.row) return a.row - b.row;
            return a.val - b.val;
        });

        // Group by column
        List<List<Integer>> res = new ArrayList<>();
        int prevCol = Integer.MIN_VALUE;

        for (Tuple t : list) {
            if (t.col != prevCol) {
                res.add(new ArrayList<>());
                prevCol = t.col;
            }
            res.get(res.size() - 1).add(t.val);
        }

        return res;
    }
    static class Tuple{
        int row, col, val;

        public Tuple(int col, int row, int val){
            this.val = val;
            this.row = row;
            this.col = col;
        }
    }
}