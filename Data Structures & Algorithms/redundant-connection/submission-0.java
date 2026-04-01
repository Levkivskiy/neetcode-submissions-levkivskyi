class Solution {
        int[] parent;
    int[] rank;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];
        rank = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        for (int i = 0; i < n; i++) {
            if (union(edges[i][0], edges[i][1])) {
                return new int[]{edges[i][0], edges[i][1]};
            }
        }

        return new int[]{-1, -1};
    }

    public int find(int n) {
        if (n != parent[n]) {
            parent[n] = find(parent[n]);
        }
        return parent[n];
    }

    public boolean union(int n1, int n2) {
        int childNode = find(n1), parentNode = find(n2);
        if (childNode == parentNode) {
            return true;
        }

        if (rank[childNode] > rank[parentNode]) {
            int temp = childNode;
            childNode = parentNode;
            parentNode = temp;
        }

        parent[childNode] = parentNode;
        rank[parentNode] += rank[childNode] + 1;

        return false;
    }
}
