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
    int count(TreeNode root,int val){
        if(root==null) return val;
        int left=count(root.left,val+1) ;
        int right=count(root.right,val+1) ;
        return Math.max(left,right);
    }
    public int maxDepth(TreeNode root) {
        return count(root,0);
    }
}
