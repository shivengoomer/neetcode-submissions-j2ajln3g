class Solution {
    int backtrack(int idx, int xor, int[] nums) {
        if (idx == nums.length) {
            return xor;
        }
        return backtrack(idx + 1, xor ^ nums[idx], nums)
             + backtrack(idx + 1, xor, nums);
    }

    public int subsetXORSum(int[] nums) {
        return backtrack(0, 0, nums);
    }
}