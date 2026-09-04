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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) {
            return null;
        }
        if(key<root.val) {
           root.left = deleteNode(root.left,key);
        } else if(key > root.val) {
           root.right = deleteNode(root.right,key);
        } else {
            if(root.left == null && root.right == null) {
                return null;
            }
            if(root.right == null && root.left != null) {
                return root.left;
            }
            if(root.left == null && root.right != null) {
                return root.right;
            }
            TreeNode successor = inorderSuccesor(root.right);
            root.val = successor.val;
           root.right = deleteNode(root.right,successor.val);  
        }
        return root;
    }
    private TreeNode inorderSuccesor(TreeNode root) {
        while(root.left != null) {
            root = root.left;
        }
        return root;
    }
}