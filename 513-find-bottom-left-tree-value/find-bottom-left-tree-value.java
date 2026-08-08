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
    public int findBottomLeftValue(TreeNode root) {
        int max=maxDepth(root);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int count =0;
        while(!q.isEmpty()) {
            int size = q.size();
            count++;
            for(int i =0;i<size;i++) {
                TreeNode current = q.poll();
                if(max == count) {
                    return current.val;
                }
                if(current.left != null) {
                    q.offer(current.left);
                }
                if(current.right != null) {
                    q.offer(current.right);
                }
            }
        }
        return -1;

    }
    private int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);
        return 1+Math.max(lh,rh);
    }
}