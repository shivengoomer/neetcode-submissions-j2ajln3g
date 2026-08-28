class Solution {

    public int minimumEffortPath(int[][] heights) {

        int m = heights.length;
        int n = heights[0].length;
        int[][] effort = new int[m][n];
        for (int[] row : effort) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );
        pq.offer(new int[]{0, 0, 0});
        effort[0][0] = 0;
        int[][] dirs = {
            {-1, 0},
            {0, -1},
            {1, 0},
            {0, 1}
        };
        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int currEffort = curr[0];
            int i = curr[1];
            int j = curr[2];
            if (i == m - 1 && j == n - 1) {
                return currEffort;
            }
            if (currEffort > effort[i][j]) {
                continue;
            }

            for (int[] dir : dirs) {

                int ni = i + dir[0];
                int nj = j + dir[1];

                if (ni < 0 || nj < 0 || ni >= m || nj >= n) {
                    continue;
                }

                int edgeDiff = Math.abs(
                    heights[i][j] - heights[ni][nj]
                );
                int newEffort = Math.max(
                    currEffort,
                    edgeDiff
                );

                if (newEffort < effort[ni][nj]) {

                    effort[ni][nj] = newEffort;

                    pq.offer(new int[]{
                        newEffort,
                        ni,
                        nj
                    });
                }
            }
        }

        return 0;
    }
}