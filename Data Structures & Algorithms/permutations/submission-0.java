class Solution {
    List<List<Integer>> res= new ArrayList<>();
    void backtrack(int[] nums, boolean[] used,List<Integer> subans){
        if(subans.size()==nums.length){
            res.add(new ArrayList<>(subans));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            subans.add(nums[i]);
            used[i]=true;
            backtrack(nums,used,subans);
            subans.remove(subans.size()-1);
            used[i] = false;
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> subans= new ArrayList<>();
        boolean[] used= new boolean[nums.length];
        backtrack(nums,used,subans);
        return res;
    }
}
