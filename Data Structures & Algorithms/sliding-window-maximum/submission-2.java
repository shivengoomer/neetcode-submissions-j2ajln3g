class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) return nums;
        int start = 0;
        int end = 0;
        int max = Integer.MIN_VALUE;
        int[] ans = new int[nums.length - k + 1];
        for (end = 0; end < k; end++) {
            max = Math.max(max, nums[end]);
        }
        ans[start++] = max;

        while (end < nums.length) {
            if (max == nums[end - k]) {
                max = Integer.MIN_VALUE;
                for (int i = start; i < end; i++) {
                    max = Math.max(max, nums[i]);
                }
            }

            max = Math.max(max, nums[end]);
            ans[start++] = max;
            end++;
        }

        return ans;
    }
}