class Solution {
    public int maxProduct(int[] nums) {
        int max=0;
        int prev=1;
        if(nums.length==1) return nums[0];
        for(int i=0;i<nums.length;i++){
            prev*=nums[i];
            max=Math.max(prev,max);
            if(prev==0) prev=1;
        }
        prev=1;
        for(int i=nums.length-1;i>=0;i--){
            prev*=nums[i];
            max=Math.max(prev,max);
            if(prev==0) prev=1;
        }
        return max;
    }
}
