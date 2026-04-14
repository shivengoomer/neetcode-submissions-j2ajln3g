class Solution {
    void backtrack(int i,int[] nums, List<List<Integer>> ans,List<Integer> sub){
        if(i>=nums.length){
            ans.add(new ArrayList<>(sub));
            return;
        }
        sub.add(nums[i]);
        backtrack(i+1,nums,ans,sub);
        sub.remove(sub.size()-1);
        backtrack(i+1,nums,ans,sub);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        backtrack(0,nums,ans,sub);
        return ans;
    }
}
