class Solution {
    public int firstMissingPositive(int[] nums) {
        List<Integer> ls = new ArrayList<>();
        for(int i:nums){
            ls.add(i);
        }
        for(int i=1;i<Integer.MAX_VALUE;i++){
            if(!ls.contains(i)) return i;
        }
        return -1;
    }
}