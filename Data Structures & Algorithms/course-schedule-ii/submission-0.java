class Solution {
    
    Set<Integer> visit = new HashSet<>();
    List<Integer> topSort = new ArrayList<>();
    Set<Integer> path = new HashSet<>();
    Map<Integer, List<Integer>> adj = new HashMap<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int[] edge : prerequisites) {
            int src = edge[0], dst = edge[1];
            adj.get(src).add(dst);
        }

        for (int src : adj.keySet()) {
            if (!dfs(src)) {
                return new int[]{};
            }
        }
        return topSort.stream().mapToInt(Integer::intValue).toArray();
    }

    public boolean dfs(int src) {
        if (path.contains(src)) {
            return false;
        }
        if (visit.contains(src)) {
            return true;
        }
        visit.add(src);
        path.add(src);
        for (int neigh : adj.get(src)) {
            if (!dfs(neigh)) {
                return false;
            }
        }
        path.remove(src);
        topSort.add(src);

        return true;
    }
}
