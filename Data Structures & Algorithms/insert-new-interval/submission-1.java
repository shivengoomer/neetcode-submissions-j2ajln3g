class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> res = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        while (i < n && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }

        int start = newInterval[0];
        int end = newInterval[1];

        while (i < n && intervals[i][0] <= end) {
            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
        }

        res.add(new int[]{start, end});

        while (i < n) {
            res.add(intervals[i]);
            i++;
        }

        int[][] ans = new int[res.size()][2];
        for (int j = 0; j < res.size(); j++) {
            ans[j] = res.get(j);
        }

        return ans;
    }
}