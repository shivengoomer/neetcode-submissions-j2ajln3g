class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (!st.isEmpty() &&
               ((st.peek() == '(' && ch == ')') ||
                (st.peek() == '{' && ch == '}') ||
                (st.peek() == '[' && ch == ']'))) {
                st.pop();
            } else {
                st.push(ch);
            }
            i++;
        }
        return st.isEmpty();
    }
}