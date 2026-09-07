class Solution {
    int compute(int n){
        int res=0;
        while(n>0){
            res+=Math.pow(n%10,2);
            n/=10;
        }
        return res;
    }
    public boolean isHappy(int n) {
        Set<Integer> seen= new HashSet<>();
        int num=n;
        while(!seen.contains(num)){
            int out=compute(num);
            if(out==1) return true;
            seen.add(num);
            num=out;
        }
        return false;
    }
}
