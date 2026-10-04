class Solution {
    List<List<Integer>> res;

    void backtrack(int[] nums, List<Integer> temp, int target, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (nums[i] > target) continue;
            temp.add(nums[i]);
            backtrack(nums, temp, target - nums[i], i);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, new ArrayList<>(), target, 0);
        return res;
    }
}