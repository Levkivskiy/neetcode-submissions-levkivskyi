class MovingAverage {

        Queue<Integer> queue = new ArrayDeque<>();
    int maxSize;
    int sum = 0;

    public MovingAverage(int size) {
        maxSize = size;
    }

    public double next(int val) {
        queue.offer(val);
        sum += val;

        if (queue.size() > maxSize) {
            sum -= queue.poll();
        }

        return (double) sum / queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
