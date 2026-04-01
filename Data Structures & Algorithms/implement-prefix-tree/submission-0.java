class PrefixTree {

    static class TrieNode {
        boolean word = false;
        Map<Character, TrieNode> childrens = new HashMap<>(26);
    }

    TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
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
        TrieNode curr = root;
        for(char c : word.toCharArray()) {
            if(!curr.childrens.containsKey(c)) {
                return false;
            }
            curr = curr.childrens.get(c);
        }
        return curr.word;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char c : prefix.toCharArray()) {
            if(!curr.childrens.containsKey(c)) {
                return false;
            }
            curr = curr.childrens.get(c);
        }
        return true;
    }
}
