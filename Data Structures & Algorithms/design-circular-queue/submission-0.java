class MyCircularQueue {

    class Node{
        int val;
        Node next, prev;
        Node(int val){
            this.val = val;
        }
    }

    int capacity;
    Node head; 
    Node temp; 

    public MyCircularQueue(int k) {
        capacity = k;
        head = new Node(-1);
        head.next = head;
        head.prev = head;
        temp = head;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) return false;
        Node node = new Node(value);
        node.next = head;
        node.prev = temp;
        temp.next = node;
        head.prev = node;
        temp = node;
        capacity--;

        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) return false;

        Node first = head.next;

        head.next = first.next;
        first.next.prev = head;

        if (temp == first)
            temp = head;

        capacity++;
        return true;
    }
    
    public int Front() {
        if (isEmpty()) return -1;
        return head.next.val;
    }
    
    public int Rear() {
        if (isEmpty()) return -1;
        return temp.val;
    }
    
    public boolean isEmpty() {
        return head==temp;
    }
    
    public boolean isFull() {
        return  capacity==0;
    }
}
