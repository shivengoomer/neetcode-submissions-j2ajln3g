class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set= new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int max=0;
        for(int i:set){
            if(!set.contains(i-1)){
                int curr=i;
                int len=1;
                while(set.contains(curr+1)){
                    len++;
                    curr++;
                }
                max=Math.max(max,len);
            }
        }
        return max;
    }
}
