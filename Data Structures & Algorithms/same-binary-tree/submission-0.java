class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();

        st1.push(p);
        st2.push(q);

        while(!st1.isEmpty() && !st2.isEmpty()) {

            TreeNode n1 = st1.pop();
            TreeNode n2 = st2.pop();
            if(n1 == null && n2 == null) continue;
            if(n1 == null || n2 == null) return false;
            if(n1.val != n2.val) return false;
            st1.push(n1.left);
            st2.push(n2.left);
            st1.push(n1.right);
            st2.push(n2.right);
        }

        return st1.isEmpty() && st2.isEmpty();
    }
}
