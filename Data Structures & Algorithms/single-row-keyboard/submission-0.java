class Solution {
    public int calculateTime(String keyboard, String word) {
        int counter = 0;
        int wordCount = 0;
        int len = 0;

        Set<Character> set = new LinkedHashSet<>();

        while (wordCount != word.length()) {
            char curr = word.charAt(wordCount);
            if(keyboard.charAt(counter) == word.charAt(wordCount)) {
                wordCount++;
            } else {
                if (set.contains(curr)) {
                    set.remove(keyboard.charAt(counter));
                    counter--;
                } else {
                    set.add(keyboard.charAt(counter));
                    counter++;
                }
                len++;
            }
        }

        return len;
    }
}
