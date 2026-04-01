class Solution {
        public record Pair(int n, int sum) {
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(2002);
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Pair> heap = new PriorityQueue<>(Comparator.comparingInt(Pair::sum));

        for (var entry : map.entrySet()) {
            heap.add(new Pair(entry.getKey(), entry.getValue()));
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] res = new int[heap.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = heap.poll().n;
        }
        return res;
    }
}