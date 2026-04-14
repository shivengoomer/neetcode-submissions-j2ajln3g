class Solution {

    int compute(Stack<Integer> stack, String op) {
        int b = stack.pop();   
        int a = stack.pop();   

        if (op.equals("+")) return a + b;
        if (op.equals("-")) return a - b;
        if (op.equals("*")) return a * b;
        return a / b;
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String t : tokens) {
            if (t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/")) {
                int res = compute(stack, t);
                stack.push(res);
            } else {
                stack.push(Integer.parseInt(t));
            }
        }
        return stack.pop();
    }
}