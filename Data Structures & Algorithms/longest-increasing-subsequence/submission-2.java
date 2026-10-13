class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int ct = 0;
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            dp[i]=1;
            for (int j = i-1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max=Math.max(dp[i],max);
                }
            }
        }
        return max;
    }
}
