class Solution {

    class Pair {
        int index;
        int entryTime;
        int processTime;

        Pair(int idx, int et, int pt) {
            this.index = idx;
            this.entryTime = et;
            this.processTime = pt;
        }
    }

    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;

        // Step 1: Convert to Pair and store original index
        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(i, tasks[i][0], tasks[i][1]);
        }
        Arrays.sort(arr, (a, b) -> a.entryTime - b.entryTime);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.processTime == b.processTime) {
                return a.index - b.index;
            }
            return a.processTime - b.processTime;
        });

        int time = 0;
        int i = 0;
        int[] result = new int[n];
        int idx = 0;
        while (idx < n) {
            if (pq.isEmpty() && time < arr[i].entryTime) {
                time = arr[i].entryTime;
            }
            while (i < n && arr[i].entryTime <= time) {
                pq.offer(arr[i]);
                i++;
            }

            Pair curr = pq.poll();
            result[idx++] = curr.index;

            time += curr.processTime;
        }

        return result;
    }
}