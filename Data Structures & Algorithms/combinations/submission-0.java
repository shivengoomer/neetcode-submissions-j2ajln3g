class Solution {
    public List<List<Integer>> ans;

    void backtrack(List<Integer> temp, int n , int k, int i){

        if(n - i + 1 < k - temp.size()) return;

        if(temp.size() == k){
            ans.add(new ArrayList<>(temp));
            return;
        }

        if(i > n) return;

        temp.add(i);
        backtrack(temp,n,k,i+1);

        temp.remove(temp.size()-1);

        backtrack(temp,n,k,i+1);
    }

    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        backtrack(new ArrayList<>(),n,k,1);
        return ans;
    }
}