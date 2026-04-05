class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] weight = new int[26];
        for (int i = 0; i < order.length(); i++) {
            weight[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            boolean foundDifference = false;
            
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    if (weight[word1.charAt(j) - 'a'] > weight[word2.charAt(j) - 'a']) {
                        return false;
                    }
                    foundDifference = true;
                    break;
                }
            }
            
            if (!foundDifference && word1.length() > word2.length()) {
                return false;
            }
        }

        return true;
    }
}