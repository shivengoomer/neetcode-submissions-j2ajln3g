class Solution {
    List<String> ans= new ArrayList<>();
void backtrack(int n, int open, int close, StringBuilder temp){

    if(open == n && close == n){
        ans.add(temp.toString());
        return;
    }

    if(open < n){
        temp.append("(");
        backtrack(n, open+1, close, temp);
        temp.deleteCharAt(temp.length()-1);
    }

    if(close < open){
        temp.append(")");
        backtrack(n, open, close+1, temp);
        temp.deleteCharAt(temp.length()-1);
    }
}
    public List<String> generateParenthesis(int n) {
        backtrack(n,0,0,new StringBuilder(""));
        return ans;

    }
}
