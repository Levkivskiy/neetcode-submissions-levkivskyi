class KthLargest {

    PriorityQueue<Integer> heap = new PriorityQueue<>();
    int k = 0;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int n : nums) {
            heap.add(n);
            if (heap.size() > k) heap.poll();
        }
    }

    public int add(int val) {
        heap.offer(val);
        if(heap.size() > k) heap.poll();
        return heap.peek();
    }
}
