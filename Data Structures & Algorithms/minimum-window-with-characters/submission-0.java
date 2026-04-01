class Solution {
    public String minWindow(String s, String t) {
        int mapLength = 'z' + 1;
        int[] map = new int[mapLength];

        for (char c : t.toCharArray()) {
            map[c]++;
        }

        int[] currMap = new int[mapLength];

        int currCharCount = 0;
        int need = t.length();
        String max = "";
        int L = 0;

        for (int R = 0; R < s.length(); R++) {
            char curr = s.charAt(R);

            if (map[curr] > 0 && currMap[curr] < map[curr]) currCharCount++;

            if (map[curr] > 0) {
                currMap[curr]++;

                while (currCharCount == need) {
                    max = max.isEmpty() || R - L + 1 < max.length() ? s.substring(L, R + 1) : max;

                    char left = s.charAt(L);
                    currMap[left]--;
                    if (map[left] > 0 && currMap[left] < map[left]) currCharCount--;
                    L++;
                }
            }
        }

        return max;
    }
}
