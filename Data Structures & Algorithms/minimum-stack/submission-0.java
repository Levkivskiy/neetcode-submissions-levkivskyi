class MinStack {

    static class StackData {
        int data;
        int currentMin;

        public StackData(int _data, int _min) {
            data = _data;
            currentMin = _min;
        }
    }

    Deque<StackData> stack = new ArrayDeque<>();

    public MinStack() {

    }

    public void push(int val) {
        int updatedMin;
        if (stack.isEmpty()) {
            updatedMin = val;
        } else {
            updatedMin = Math.min(stack.peek().currentMin, val);
        }

        stack.push(new StackData(val, updatedMin));
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        assert stack.peek() != null;
        return stack.peek().data;
    }

    public int getMin() {
        assert stack.peek() != null;
        return stack.peek().currentMin;
    }
}
