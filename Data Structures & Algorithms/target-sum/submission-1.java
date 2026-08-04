class Solution {

    int dfs(int[] nums, int target, int curr, int ct) {
        if (curr == nums.length) {
            if (target == 0) return 1;
            return 0;
        }
        int ans = 0;
        ans += dfs(nums, target - nums[curr], curr + 1, ct + 1);
        ans += dfs(nums, target + nums[curr], curr + 1, ct + 1);
        return ans;
    }

    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums, target, 0, 0);
    }
}