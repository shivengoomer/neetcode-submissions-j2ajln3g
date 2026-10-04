class Solution {
    public int[][] merge(int[][] intervals) {

        List<List<Integer>> lst = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            if (end >= intervals[i][0]) {
                end = Math.max(end, intervals[i][1]);
            } 
            else {
                lst.add(new ArrayList<>(Arrays.asList(start, end)));

                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        // add last interval
        lst.add(new ArrayList<>(Arrays.asList(start, end)));

        int[][] res = new int[lst.size()][2];

        for (int i = 0; i < lst.size(); i++) {
            res[i][0] = lst.get(i).get(0);
            res[i][1] = lst.get(i).get(1);
        }

        return res;
    }
}