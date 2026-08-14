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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<String>();
        String Path = "";
        if(root != null) {
          search(root,Path,list);
        }
        return list;
    }
    private void search(TreeNode root,String Path, List<String>list) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) list.add(Path + root.val);
        search(root.left,Path+root.val+"->",list);
        search(root.right,Path+root.val+"->",list);
    }
}