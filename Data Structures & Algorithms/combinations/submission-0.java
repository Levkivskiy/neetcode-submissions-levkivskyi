class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> subset = new ArrayList<>();
    int k = 0;
    int n = 0;

    public void helper(int i) {
        if(subset.size() == k) {
            res.add(new ArrayList<>(subset));
            return;
        } else if(i > n) {
            return;
        }

        subset.add(i);
        helper(i + 1);
        subset.remove(subset.size() - 1);
        helper(i + 1);
    }

    public List<List<Integer>> combine(int n, int k) {
        this.k = k;
        this.n = n;
        helper(1);
        return res;
    }
}