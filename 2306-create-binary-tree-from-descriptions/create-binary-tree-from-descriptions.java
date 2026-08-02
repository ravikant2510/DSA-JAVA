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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer,TreeNode> map = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        for(int[] desc:descriptions) {
            int parentval = desc[0];
            int childval = desc[1];
            int isLeft = desc[2];
        map.putIfAbsent(parentval,new TreeNode(parentval));
        map.putIfAbsent(childval,new TreeNode(childval));

        TreeNode parent = map.get(parentval);
        TreeNode child = map.get(childval);

        if(isLeft == 1) {
            parent.left = child;
        } else {
            parent.right = child;
        }
        children.add(childval);
        }

        for(int key:map.keySet()) {
            if(!children.contains(key)){
                return map.get(key);
            }
        }
        return null;
    }
}