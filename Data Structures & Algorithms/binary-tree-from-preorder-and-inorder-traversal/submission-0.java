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
        int[] preorder;
    int[] inorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.inorder = inorder;
        this.preorder = preorder;
        if (preorder.length == 0) {
            return null;
        }

        return construct(0, 0, preorder.length - 1);
    }

    public TreeNode construct(int i, int l, int r) {
        if (l > r || i >= preorder.length) {
            return null;
        }
        int n = preorder[i];

        TreeNode node = new TreeNode(n);
        int inorderI = findI(n, l, r);
        int mid = inorderI - l;
        node.left = construct(i + 1, l, inorderI - 1);
        node.right = construct(i + mid + 1, inorderI + 1, r);

        return node;
    }

    public int findI(int n, int L, int R) {
        for (int i = L; i <= R; i++) {
            if (inorder[i] == n) {
                return i;
            }
        }
        return -1;
    }
}
