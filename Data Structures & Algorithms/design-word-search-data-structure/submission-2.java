class WordDictionary {

    static class TrieNode {
        boolean word = false;
        Map<Character, TrieNode> childrens = new HashMap<>(26);
    }

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()) {
            if(!curr.childrens.containsKey(c)) {
                curr.childrens.put(c, new TrieNode());
            }
            curr = curr.childrens.get(c);
        }
        curr.word = true;
    }

    public boolean search(String word) {
        return searchIn(word, root);
    }

    public boolean searchIn(String word, TrieNode inputNode) {
        TrieNode curr = inputNode;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(c == '.') {
                for (TrieNode node : curr.childrens.values()) {
                    if(searchIn(word.substring(i + 1), node)) {
                        return true;
                    }
                }
                return false;
            }
            if(!curr.childrens.containsKey(c)) {
                return false;
            }
            curr = curr.childrens.get(c);
        }
        return curr.word;
    }
}
