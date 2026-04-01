class MedianFinder {

    PriorityQueue<Integer> small = new PriorityQueue<>(Comparator.reverseOrder());
    PriorityQueue<Integer> bigger = new PriorityQueue<>();

    public MedianFinder() {
    }

    public void addNum(int num) {
        small.add(num);

        if (!small.isEmpty() && !bigger.isEmpty() && small.peek() > bigger.peek()) {
            bigger.add(small.poll());
        }

        if (small.size() - bigger.size() > 1) {
            bigger.add(small.poll());
        }
        if (bigger.size() - small.size() > 1) {
            small.add(bigger.poll());
        }
    }

    public double findMedian() {
        if (small.size() > bigger.size()) {
            return small.peek();
        } else if (bigger.size() > small.size()) {
            return bigger.peek();
        } else {
            return (double) (small.peek() + bigger.peek()) / 2;
        }
    }
}