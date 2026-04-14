class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n = (word1.length()>word2.length())? word1.length() : word2.length();
        int i=0;
        StringBuilder ans= new StringBuilder();
        while(i<n){
            if(i<word1.length() && i < word2.length()){
                ans.append(word1.charAt(i));
                ans.append(word2.charAt(i));
            }
            if(i > word1.length()-1){
                ans.append(word2.charAt(i));
            }
            if(i > word2.length()-1){
                ans.append(word1.charAt(i));
            }
            i++;
        }
        return ans.toString();
    }

}