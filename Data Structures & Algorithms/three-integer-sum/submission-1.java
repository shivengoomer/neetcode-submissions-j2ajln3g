class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> finalList = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;

            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum < 0) {
                    start++;
                } else if (sum > 0) {
                    end--;
                } else {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[start], nums[end]);
                    if (!finalList.contains(triplet)) {
                        finalList.add(triplet);
                    }
                    start++;
                    end--;
                }
            }
        }
        return finalList;
    }
}
