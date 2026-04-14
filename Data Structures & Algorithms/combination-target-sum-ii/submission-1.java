class Solution {
    void backtrack(int[] cand, int tar, int i , List<Integer> subans , List<List<Integer>> ans){
        if(tar == 0){
            ans.add(new ArrayList<>(subans));
            return;
        }
        if(i >= cand.length || tar < 0){
            return;
        }

        subans.add(cand[i]);
        backtrack(cand, tar - cand[i], i + 1, subans, ans);
        subans.remove(subans.size() - 1);
        int next = i + 1;
        while(next < cand.length && cand[next] == cand[i]) next++;
        backtrack(cand, tar, next, subans, ans);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); 
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }
}