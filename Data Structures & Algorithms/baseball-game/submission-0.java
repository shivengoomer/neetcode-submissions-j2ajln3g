class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();
        for (String op : operations) {
            if (op.equals("C")) {
                st.pop();
            } 
            else if (op.equals("D")) {
                st.push(st.peek() * 2);
            } 
            else if (op.equals("+")) {
                int last = st.pop();
                int newScore = last + st.peek();
                st.push(last); 
                st.push(newScore);
            } 
            else {
                st.push(Integer.parseInt(op));
            }
        }

        int sum = 0;
        for (int score : st) {
            sum += score;
        }

        return sum;
    }
}