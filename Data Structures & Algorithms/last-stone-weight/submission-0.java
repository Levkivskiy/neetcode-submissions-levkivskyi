class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());

        for(int s : stones) {
            heap.offer(s);
        }

        while(heap.size() > 1) {
            int x = heap.poll();
            if(heap.isEmpty())
                break;
            int y = heap.poll();

            int sum = Math.abs(x - y);
            heap.offer(sum);
        }

        return heap.isEmpty() ? 0 : heap.peek();
    }
}
