
class Solution {
    class Pair {
        char task;
        int freq;

        Pair(char task, int freq) {
            this.task = task;
            this.freq = freq;
        }
    }

    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.freq - a.freq);

        HashMap<Character, Integer> map = new HashMap<>();
        for (char t : tasks) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        for (char key : map.keySet()) {
            pq.offer(new Pair(key, map.get(key)));
        }

        int time = 0;
        while (!pq.isEmpty()) {

            List<Pair> temp = new ArrayList<>();
            int cycle = n + 1;  
            while (cycle > 0 && !pq.isEmpty()) {
                Pair curr = pq.poll();

                curr.freq--;
                if (curr.freq > 0) {
                    temp.add(curr);
                }

                time++;
                cycle--;
            }
            for (Pair p : temp) {
                pq.offer(p);
            }
            if (!pq.isEmpty()) {
                time += cycle;
            }
        }

        return time;
    }
}