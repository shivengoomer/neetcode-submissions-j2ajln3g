class Solution {
    boolean compare(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;
        if (root.val != subRoot.val) return false;
        return compare(root.left, subRoot.left)
            && compare(root.right, subRoot.right);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (compare(root, subRoot)) return true;
        return isSubtree(root.left, subRoot)
            || isSubtree(root.right, subRoot);
    }
}