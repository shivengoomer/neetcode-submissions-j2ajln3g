class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> qu = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) return res;
        qu.offer(root);
        while (!qu.isEmpty()) {
            int size = qu.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = qu.poll();
                temp.add(curr.val);

                if (curr.left != null) {
                    qu.offer(curr.left);
                }

                if (curr.right != null) {
                    qu.offer(curr.right);
                }
            }

            res.add(temp);
        }

        return res;
    }
}