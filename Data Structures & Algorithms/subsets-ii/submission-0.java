class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    void backtrack(int[] nums, List<Integer> temp, int i){
        if(i == nums.length){
            if(!ans.contains(temp)) {
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        temp.add(nums[i]);
        backtrack(nums, temp, i+1);
        temp.remove(temp.size()-1);
        backtrack(nums, temp, i+1);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, new ArrayList<>(), 0);
        return ans;
    }
}