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
        Collections.sort(intervals,(a,b)->a.start-b.start);
        int pastS=Integer.MAX_VALUE;
        int pastE=Integer.MIN_VALUE;
        for(Interval i : intervals){
            if(pastE > i.start ) return false;
            pastE=i.end;
            pastS=i.start;

        }
        return true;
    }
}
