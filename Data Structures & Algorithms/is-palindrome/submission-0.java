class Solution {
    public boolean isPalindrome(String s) {
        String tempS = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        for(int i=0;i<tempS.length();i++){
            if(tempS.charAt(i)!=tempS.charAt(tempS.length()-1-i)) return false;
        }
        return true;
    }
}
