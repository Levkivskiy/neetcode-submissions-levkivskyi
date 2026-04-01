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

public class Codec {
    public String serialize(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfsSer(root, res);
        return String.join(",", res);
    }

    public void dfsSer(TreeNode root, List<String> arr) {
        if (root == null) {
            arr.add("Null");
            return;
        }
        arr.add(String.valueOf(root.val));
        dfsSer(root.left, arr);
        dfsSer(root.right, arr);
    }

    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        return dfsDes(vals, new int[]{0});
    }

    public TreeNode dfsDes(String[] vals, int[] index) {
        int i = index[0];
        if (vals[i].equals("Null")) {
            index[0]++;
            return null;
        }
        int nodeVal = Integer.parseInt(vals[i]);
        TreeNode node = new TreeNode(nodeVal);
        index[0]++;
        node.left = dfsDes(vals, index);
        node.right = dfsDes(vals, index);
        return node;
    }
}
