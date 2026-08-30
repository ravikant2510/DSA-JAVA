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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int sum =0;
        dfs(list,temp,root,targetSum,sum);
        return list;
    }
    private void dfs(List<List<Integer>>list,List<Integer>temp,TreeNode root, int targetSum,int sum) {
        if(root == null) {
            return;
        }
        temp.add(root.val);
        sum += root.val;
        if (root.left == null && root.right == null && sum == targetSum) {
            list.add(new ArrayList<>(temp));
        }
        if(root.left != null) {
            dfs(list,temp,root.left,targetSum,sum);
        }
        if(root.right != null) {
            dfs(list,temp,root.right,targetSum,sum);
        }
        temp.remove(temp.size()-1);
    }
}