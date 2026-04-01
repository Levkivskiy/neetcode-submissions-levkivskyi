class Solution {
    Map<Integer, Integer> par = new HashMap<>();
    Map<Integer, Integer> rank = new HashMap<>();

    public int countComponents(int n, int[][] edges) {
        for (int i = 0; i < n; i++) {
            par.put(i, i);
            rank.put(i, 0);
        }

        int sum = n;
        for (int[] edge : edges) {
            if (union(edge[0], edge[1])) {
                sum--;
            }
        }

        return sum;
    }

    public int find(int x) {
        if (x != par.get(x)) {
            par.replace(x, find(par.get(x)));
        }
        return par.get(x);
    }

    public boolean union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);

        if (p1 == p2) {
            return false;
        }

        if (rank.get(p1) < rank.get(p2)) {
            int temp = p2;
            p2 = p1;
            p1 = temp;
        }
        par.put(p2, p1);
            rank.replace(p1, rank.get(p1) + 1 + rank.get(p2));
        return true;
    }
}
