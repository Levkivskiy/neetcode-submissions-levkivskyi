class Solution {
    Map<Character, Integer> map = new HashMap<>('Z' - 'A');

    public int sumWithoutLongest() {
        var coll = map.values();
        int highest = -1;
        int sum = 0;
        for (int n : coll) {
            highest = Math.max(n, highest);
            sum += n;
        }
        return sum - highest;
    }

    public int characterReplacement(String s, int k) {
        int L = 0;
        int max = 0;
        int currSize = 0;

        for (int R = 0; R < s.length(); R++) {
            char curr = s.charAt(R);
            if (map.containsKey(curr)) {
                int temp = map.get(curr);
                map.replace(curr, temp + 1);
            } else {
                map.put(curr, 1);
            }
            currSize++;
            if (sumWithoutLongest() > k) {
                int currL = map.get(s.charAt(L));
                map.replace(s.charAt(L), currL - 1);
                L++;
                currSize--;
            }
            max = Math.max(max, currSize);
        }

        return currSize;
    }
}
