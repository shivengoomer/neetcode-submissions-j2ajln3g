class Solution {

    int search(TreeNode root){
        if(root == null) return 0;

        int left = search(root.left);
        int right = search(root.right);

        return 1 + Math.max(left, right);
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int left = search(root.left);
        int right = search(root.right);
        if(Math.abs(left - right) > 1)
            return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
}
