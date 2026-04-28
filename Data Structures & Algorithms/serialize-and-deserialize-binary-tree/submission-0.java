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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";

        StringBuilder res = new StringBuilder();
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);

        while (!qu.isEmpty()) {
            TreeNode curr = qu.poll();

            if (curr == null) {
                res.append("#,");
                continue;
            }

            res.append(curr.val).append(",");

            qu.offer(curr.left);
            qu.offer(curr.right);
        }

        return res.toString();
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    if (data == null || data.length() == 0) return null;

    String[] nodes = data.split(",");
    if (nodes[0].equals("#")) return null;

    TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
    Queue<TreeNode> qu = new LinkedList<>();
    qu.offer(root);

    int i = 1;

    while (!qu.isEmpty() && i < nodes.length) {
        TreeNode curr = qu.poll();

        // Left 
        if (!nodes[i].equals("#")) {
            curr.left = new TreeNode(Integer.parseInt(nodes[i]));
            qu.offer(curr.left);
        }
        i++;
        //right
        if (i < nodes.length && !nodes[i].equals("#")) {
            curr.right = new TreeNode(Integer.parseInt(nodes[i]));
            qu.offer(curr.right);
        }
        i++;
    }

    return root;
}
}
