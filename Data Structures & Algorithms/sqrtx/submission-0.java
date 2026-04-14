class Solution {
    public int mySqrt(int x) {
        int start=0,end=x;
        while(start<=end){
            int mid=(start+end)/2;
            if((long) mid*mid==(long)x) return mid;
            else if((long) mid*mid > (long) x) end=mid-1;
            else{
                start=mid+1;
            }
        }
        return end;
    }
}