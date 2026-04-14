class Solution {
    void backtrack(int[] nums, int target, int i, List<Integer> subans, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(subans));
            return;
        }
        if (target < 0 || i == nums.length) {
            return;
        }

        subans.add(nums[i]);
        backtrack(nums, target - nums[i], i, subans, ans); 
        subans.remove(subans.size() - 1);
        backtrack(nums, target, i + 1, subans, ans);
    }
    
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> subans = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, target, 0, subans, ans);
        return ans;
    }
}