class Solution {
    public String longestPalindrome(String s) {
        int idx=0;
        int len=0;
        int n=s.length();
        boolean[][] dp = new boolean[n][n];
        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                if(s.charAt(j)==s.charAt(i) && (j-i<=2 || dp[i+1][j-1])){
                    dp[i][j]=true;
                    len=Math.max(j-i+1,len);
                    idx=len==j-i+1 ? i : idx;
                }
            }
        }
        return s.substring(idx,idx+len);
    }
}
