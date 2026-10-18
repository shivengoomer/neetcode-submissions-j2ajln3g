/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals.size()<=1) return true; 
        Collections.sort(intervals,(a,b)->a.start-b.start);
        Stack<Interval> st= new Stack<>();
        st.push(intervals.get(0));
        int i=1;
        while (i < intervals.size()) {
            if(intervals.get(i).start < st.peek().end) return false;
            st.pop();
            st.push(intervals.get(i));
            i++;
        }
        return true;
    }
}
