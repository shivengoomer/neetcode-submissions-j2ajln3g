class Solution {
    public List<String> ans= new ArrayList<>();

    void backtrack(String[] maped,String digits,int i,String curr){
        if(i==digits.length()){
            ans.add(curr);
            return;
        }

        String letters = maped[digits.charAt(i)-'0'];

        for(int j=0; j<letters.length(); j++){
            backtrack(maped,digits,i+1,curr + letters.charAt(j));
        }
    }

    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) return ans;

        String[] maped = {"","", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        backtrack(maped,digits,0,"");
        return ans;
    }
}