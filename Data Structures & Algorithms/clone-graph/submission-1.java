class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> qu = new LinkedList<>();
        Node res = new Node(node.val);
        map.put(node, res);
        qu.offer(node);
        while (!qu.isEmpty()) {
            Node curr = qu.poll();
            for (Node n : curr.neighbors) {
                if (!map.containsKey(n)) {
                    map.put(n, new Node(n.val));
                    qu.offer(n);
                }
                map.get(curr).neighbors.add(map.get(n));
            }
        }

        return res;
    }
}