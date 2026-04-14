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
    void search(TreeNode root,List<Integer> ans){
        if(root==null){
            return;
        }
        search(root.left,ans);
        ans.add(root.val);
        search(root.right,ans);
        
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode curr=root;
        List<Integer> ans = new ArrayList<>();
        search(curr,ans);
        return ans;
    }
}