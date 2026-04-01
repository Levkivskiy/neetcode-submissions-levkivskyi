class Solution {
    HashSet<Integer> canFinish = new HashSet<>();
    HashSet<Integer> visit = new HashSet<>();
    HashMap<Integer, List<Integer>> map = new HashMap<>();

    public boolean dfs(int node) {
        if (visit.contains(node)) {
            return false;
        }
        if (canFinish.contains(node) || map.get(node).isEmpty()) {
            return true;
        }
        visit.add(node);

        for(int pr : map.get(node)) {
            if(!dfs(pr)) {
                return false;
            }
        }
        visit.remove(node);
        canFinish.add(node);
        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        for (int[] edge : prerequisites) {
            int main = edge[0];
            int neigh = edge[1];
            if (!map.containsKey(main)) {
                map.put(main, new ArrayList<>());
            }
            if (!map.containsKey(neigh)) {
                map.put(neigh, new ArrayList<>());
            }
            map.get(main).add(neigh);
        }

        for (Integer key : map.keySet()) {
            if(!canFinish.contains(key)) {
                if(!dfs(key)) {
                    return false;
                }
            }
        }

        return true;
    }
}
