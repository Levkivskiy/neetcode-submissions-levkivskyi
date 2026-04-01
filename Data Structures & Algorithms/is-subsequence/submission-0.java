class Solution {
    int[][] memo;

    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) return true;
        if (t.isEmpty()) return false;
        memo = new int[s.length()][t.length()];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }
        return dfs(s, t, 0, 0) > 0;
    }

    public int dfs(String left, String right, int i, int j) {
        if (i == left.length()) {
            return 1;
        }

        if (j == right.length()) {
            return 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (left.charAt(i) == right.charAt(j)) {
            memo[i][j] = dfs(left, right, i + 1, j + 1);
        } else {
            memo[i][j] = dfs(left, right, i, j + 1);
        }

        return memo[i][j];
    }
}