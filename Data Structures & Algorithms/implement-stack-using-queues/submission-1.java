class MyStack {

    Queue<Integer> main = new ArrayDeque<>();
    Queue<Integer> second = new ArrayDeque<>();

    public MyStack() {

    }

    public void push(int x) {
        if (main.isEmpty()) {
            second.offer(x);
        } else {
            main.offer(x);
        }
    }

    public int pop() {
        int last = -1;
        if (main.isEmpty()) {
            while (!second.isEmpty()) {
                last = second.poll();
                if (!second.isEmpty()) {
                    main.offer(last);
                }
            }
        } else {
            while (!main.isEmpty()) {
                last = main.poll();
                if (!main.isEmpty()) {
                    second.offer(last);
                }
            }
        }
        return last;
    }

    public int top() {
        int last = pop();
        push(last);
        return last;
    }

    public boolean empty() {
        return main.isEmpty() && second.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */