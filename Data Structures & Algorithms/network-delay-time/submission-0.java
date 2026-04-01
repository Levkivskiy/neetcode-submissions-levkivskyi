class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, ArrayList<int[]>> edges = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            edges.put(i, new ArrayList<>());
        }
        for (int[] edge : times) {
            edges.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }

        HashMap<Integer, Integer> shortest = new HashMap<>();
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(weigh -> weigh[1]));
        heap.add(new int[]{k, 0});

        while (!heap.isEmpty()) {
            var edge = heap.poll();
            int node = edge[0], weight = edge[1];

            if (shortest.containsKey(node))
                continue;

            shortest.put(node, weight);
            for (int[] neigh : edges.get(node)) {
                int e = neigh[0], w = neigh[1];
                if (!shortest.containsKey(e)) {
                    heap.add(new int[]{e, w + weight});
                }
            }
        }

        if (shortest.size() != n) return -1;
        return Collections.max(shortest.values());
    }
}
