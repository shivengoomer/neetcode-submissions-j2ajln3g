class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        Stack<int[]> st = new Stack<>();
        st.push(intervals[0]);

        int i = 1;
        int count = 0;

        while (i < intervals.length) {
            if (st.peek()[1] > intervals[i][0]) {
                int[] curr = st.pop();
                if (curr[1] <= intervals[i][1])
                    st.push(curr);
                else
                    st.push(intervals[i]);

                count++;
            } else {
                st.push(intervals[i]);
            }

            i++;
        }

        return count;
    }
}