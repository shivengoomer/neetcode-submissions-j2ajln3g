class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st= new Stack<>();
        for(int i=temperatures.length-1;i>=0;i--){
            st.push(temperatures[i]);
        }
        int[] ans= new int[temperatures.length];
        int i=0;
        while(!st.isEmpty()){
            int curr = st.pop();
            Stack<Integer> temp = (Stack<Integer>) st.clone();            
            int ct=1;
            while(!temp.isEmpty() && curr >= temp.peek() ){
                ct++;
                temp.pop();
            }
            ans[i++]=temp.isEmpty() ? 0 : ct;
        }
        return ans;
    }
}
