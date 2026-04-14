class StockSpanner {
    Stack<int[]> st;
    public int min=1;

    public StockSpanner() {
        st= new Stack<>();
    }
    public int next(int price) {
        int min = 1;
        while (!st.isEmpty() && st.peek()[0] <= price) {
            min += st.pop()[1];
        }
        st.push(new int[] {price, min});
        return min;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */