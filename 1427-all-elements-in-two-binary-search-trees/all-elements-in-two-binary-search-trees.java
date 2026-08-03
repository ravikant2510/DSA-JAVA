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
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list = new ArrayList<>();
        getElements(root1);
        getElements(root2);
        while(!pq.isEmpty()) {
            list.add(pq.poll());
        }
        return list;
    }
    public void getElements(TreeNode node1) {
        if(node1 == null) {
            return;
        }
        pq.offer(node1.val);
        getElements(node1.left);
        getElements(node1.right);
    }
}