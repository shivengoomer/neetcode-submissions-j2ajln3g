class Solution {

    boolean check(TreeNode a, TreeNode b){
        if(a == null && b == null) return true;
        if(a == null || b == null) return false;

        if(a.val != b.val) return false;

        return check(a.left, b.left) && check(a.right, b.right);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if(root == null) return false;

        if(root.val == subRoot.val && check(root, subRoot))
            return true;

        return isSubtree(root.left, subRoot) ||
               isSubtree(root.right, subRoot);
    }
}
