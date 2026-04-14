class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if(root == null) return ans;

        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);

        while(!qu.isEmpty()){

            int size = qu.size();
            List<Integer> sublist = new ArrayList<>();

            for(int i = 0; i < size; i++){

                TreeNode curr = qu.poll();

                sublist.add(curr.val);
                if(curr.left != null) qu.add(curr.left);
                if(curr.right != null) qu.add(curr.right);
            }

            ans.add(sublist);
        }
        return ans;
    }
}
