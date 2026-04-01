class Solution {
    TreeMap<Integer, Integer> multiset = new TreeMap<>();

    public void put(int n) {
        multiset.put(n, multiset.getOrDefault(n, 0) + 1);
    }

    public void remove(int n) {
        int count = multiset.getOrDefault(n, 0);
        if(count <= 1) {
            multiset.remove(n);
        } else {
            multiset.put(n, count - 1);
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int L = 0;
        List<Integer> res = new ArrayList<>();

        for (int R = 0; R < nums.length; R++) {
            put(nums[R]);
            if (R - L + 1 > k) {
                remove(nums[L++]);
            }
            if (R - L + 1 == k) {
                res.add(multiset.lastKey());
            }
        }

        return res.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
