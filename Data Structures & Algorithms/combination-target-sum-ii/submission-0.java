class Solution {
    Set<List<Integer>> res = new HashSet<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates, target, 0, 0, new ArrayList<>());
        return res.stream().toList();
    }

    public void helper(int[] candidates, int target, int currSum, int i, List<Integer> curr) {
        if (currSum == target) {
            res.add(new ArrayList<>(curr));
        }
        if (i >= candidates.length || currSum > target) return;

        curr.add(candidates[i]);
        currSum += candidates[i];
        helper(candidates, target, currSum, i + 1, curr);

        while (i + 1 != candidates.length && candidates[i] == candidates[i + 1]) i++;

        curr.removeLast();
        currSum -= candidates[i];
        helper(candidates, target, currSum, i + 1, curr);
    }
}
