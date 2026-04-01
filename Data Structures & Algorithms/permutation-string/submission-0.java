class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] charTemp = s1.toCharArray();
        List<Character> s1Sort = new ArrayList<>();
        for (char c : charTemp) s1Sort.add(c);
        Collections.sort(s1Sort);

        TreeMap<Character, Integer> map = new TreeMap<>();

        int L = 0;
        for (int R = 0; R < s2.length(); R++) {
            map.merge(s2.charAt(R), 1, Integer::sum);
            if (R - L + 1 == s1.length()) {
                List<Character> currSort = new ArrayList<>();

                for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                    for (int i = 0; i < entry.getValue(); i++) {
                        currSort.add(entry.getKey());
                    }
                }

                if (currSort.equals(s1Sort)) return true;

                map.merge(s2.charAt(L), -1, Integer::sum);
                if (map.get(s2.charAt(L)) == 0) map.remove(s2.charAt(L));
                L++;
            }
        }

        return false;
    }
}
