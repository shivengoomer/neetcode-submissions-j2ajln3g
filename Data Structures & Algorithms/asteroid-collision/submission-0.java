class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        st.push(asteroids[asteroids.length - 1]);

        for (int i = asteroids.length - 2; i >= 0; i--) {
            int curr = asteroids[i];
            while (!st.isEmpty() && curr > 0 && st.peek() < 0) {

                if (Math.abs(curr) > Math.abs(st.peek())) {
                    st.pop();          
                } 
                else if (Math.abs(curr) == Math.abs(st.peek())) {
                    st.pop();          
                    curr = 0;
                    break;
                } 
                else {
                    curr = 0;          
                    break;
                }
            }

            if (curr != 0) {
                st.push(curr);
            }
        }
        int[] ans = new int[st.size()];
        int i = 0;
        while (!st.isEmpty()) {
            ans[i++] = st.pop();
        }

        return ans;
    }
}