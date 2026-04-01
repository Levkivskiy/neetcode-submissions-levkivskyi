class Solution {
    record Pair(int node, double weight) {
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer, ArrayList<Pair>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            double w = succProb[i];
            adj.get(edge[0]).add(new Pair(edge[1], w));
            adj.get(edge[1]).add(new Pair(edge[0], w));
        }

        Map<Integer, Double> paths = new HashMap<>();
        PriorityQueue<Pair> heap = new PriorityQueue<>(Comparator.comparingDouble(Pair::weight).reversed());
        heap.add(new Pair(start_node, 1.0));

        while (!heap.isEmpty()) {
            Pair pair = heap.poll();
            if(paths.containsKey(pair.node))
                continue;

            paths.put(pair.node, pair.weight);
            if (pair.node == end_node) break;

            for(Pair neighbor : adj.get(pair.node)) {
                if(!paths.containsKey(neighbor.node)) {
                    heap.add(new Pair(neighbor.node, neighbor.weight * pair.weight));
                }
            }
        }

        return paths.getOrDefault(end_node, 0.0);
    }
}