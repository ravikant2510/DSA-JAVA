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
class FindElements {
    TreeNode root;
    public FindElements(TreeNode root) {
        this.root = root;
        if(root != null) {
            root.val = 0;
            recover(root);
        }       
    }
    private void recover(TreeNode node) {
        if(node == null) {
            return;
        }
        if(node.left != null) {
            node.left.val = (node.val*2)+1;
        }
        if(node.right != null) {
            node.right.val = (node.val*2)+2;
        }
        recover(node.left);
        recover(node.right);

    }
    
    public boolean find(int target) {
        return search(root,target);
    }
    private boolean search(TreeNode root, int target) {
        if(root == null) {
            return false;
        }
        if(root.val == target) {
            return true;
        }
        return search(root.left,target) || search(root.right,target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */