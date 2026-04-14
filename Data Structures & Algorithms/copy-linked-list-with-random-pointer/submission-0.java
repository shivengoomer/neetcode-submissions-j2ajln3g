class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        ArrayList<Node> original = new ArrayList<>();
        ArrayList<Node> copied = new ArrayList<>();

        Node temp = head;
        while (temp != null) {
            original.add(temp);
            copied.add(new Node(temp.val));
            temp = temp.next;
        }

        for (int i = 0; i < copied.size() - 1; i++) {
            copied.get(i).next = copied.get(i + 1);
        }

        for (int i = 0; i < original.size(); i++) {
            Node origRandom = original.get(i).random;
            if (origRandom != null) {
                int idx = original.indexOf(origRandom);
                copied.get(i).random = copied.get(idx);
            }
        }

        return copied.get(0);
    }
}
