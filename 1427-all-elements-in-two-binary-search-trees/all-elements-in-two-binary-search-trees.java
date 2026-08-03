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
    Queue<Integer> qu1 = new LinkedList<>();
    Queue<Integer> qu2 = new LinkedList<>();
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list = new ArrayList<>();
        getElement(root1,qu1);
        getElement(root2,qu2);
        while(!qu1.isEmpty() && !qu2.isEmpty()) {
            if(qu1.peek() >= qu2.peek()) {
                list.add(qu2.poll());
            } else {
                list.add(qu1.poll());
            }
        }
        while (!qu1.isEmpty()) {
             list.add(qu1.poll());
        }
        while (!qu2.isEmpty()) {
            list.add(qu2.poll());
        }
        return list;

    }
    private void getElement(TreeNode node, Queue<Integer>qu) {
        if(node == null) {
            return;
        }
        getElement(node.left,qu);
        qu.offer(node.val);
        getElement(node.right,qu);
    }
}