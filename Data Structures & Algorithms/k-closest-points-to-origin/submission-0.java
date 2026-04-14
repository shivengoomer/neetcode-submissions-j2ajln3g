class Solution {
    class Pair {
        int index;
        int distance;

        Pair(int idx, int d) {
            index = idx;
            distance = d;
        }
    }

    int distance(int x, int y) {
        return x * x + y * y; 
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> minHeap =
                new PriorityQueue<>(Comparator.comparingInt(p -> p.distance));
        for (int i = 0; i < points.length; i++) {
            minHeap.offer(new Pair(i, distance(points[i][0], points[i][1])));
        }

        int[][] res = new int[k][2];

        for (int i = 0; i < k; i++) {
            int idx = minHeap.poll().index;
            res[i] = points[idx];
        }

        return res;
    }
}