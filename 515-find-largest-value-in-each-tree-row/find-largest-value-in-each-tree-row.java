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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            int max = Integer.MIN_VALUE;
            for(int i = 0; i<size;i++) {
                TreeNode current = q.poll();
                if(current.val>max) {
                    max = current.val;
                }
                if(current.left != null) {
                    q.offer(current.left);
                }
                if(current.right != null) {
                    q.offer(current.right);
                }
            }
            list.add(max);
        }
        return list;
    }
}