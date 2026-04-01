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
        public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<Boolean> visited = new Stack<>();
        List<Integer> res = new ArrayList<>();
        stack.push(root);
        visited.push(false);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            boolean vis = visited.pop();
            if(curr != null) {
                if(vis)
                    res.add(curr.val);
                else {
                    stack.push(curr);
                    visited.push(true);
                    stack.push(curr.right);
                    visited.push(false);
                    stack.push(curr.left);
                    visited.push(false);
                }
            }
        }

        return res;
    }
}