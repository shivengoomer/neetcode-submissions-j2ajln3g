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
    PriorityQueue<Integer> pq ;
    void dfs(TreeNode root){
        if(root==null) return;
        pq.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
    public int kthSmallest(TreeNode root, int k) {
       pq = new PriorityQueue<>();
        dfs(root);
        while(--k>0){
            pq.poll();;
        }
        return pq.poll();
    }
}
