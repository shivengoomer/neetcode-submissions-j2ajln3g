class FreqStack {

    class Node {
        int val;
        int freq;
        int time;

        Node(int v, int f, int t) {
            val = v;
            freq = f;
            time = t;
        }
    }

    HashMap<Integer, Integer> freq;
    PriorityQueue<Node> pq;
    int time;

    public FreqStack() {

        freq = new HashMap<>();
        time = 0;

        pq = new PriorityQueue<>((a, b) -> {
            if (a.freq == b.freq)
                return b.time - a.time;   // recent first
            return b.freq - a.freq;       // higher freq first
        });
    }

    public void push(int val) {

        int f = freq.getOrDefault(val, 0) + 1;
        freq.put(val, f);

        pq.add(new Node(val, f, time++));
    }

    public int pop() {

        Node node = pq.poll();

        freq.put(node.val, freq.get(node.val) - 1);

        return node.val;
    }
}