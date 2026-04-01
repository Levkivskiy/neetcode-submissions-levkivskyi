class LRUCache {

        class LruNode {
        int value;
        int key;
        LruNode prev;
        LruNode next;

        public LruNode(int key, int value) {
            this.value = value;
            this.key = key;
            prev = null;
            next = null;
        }
    }

    Map<Integer, LruNode> map = new HashMap<>();
    LruNode start;
    LruNode tail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.start = new LruNode(0, 0);
        this.tail = new LruNode(0, 0);
        this.start.next = tail;
        this.tail.prev = start;

    }

    public void removeNode(LruNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addTail(LruNode node) {
        LruNode prev = tail.prev;
        prev.next = node;
        node.prev = prev;
        node.next = tail;
        tail.prev = node;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        LruNode node = map.get(key);

        removeNode(node);
        addTail(node);

        return node.value;
    }

    public void put(int key, int value) {
        LruNode node = new LruNode(key, value);

        if (map.containsKey(key)) removeNode(map.get(key));

        map.put(key, node);
        addTail(node);

        if (map.size() > capacity) {
            LruNode toRemove = start.next;
            removeNode(toRemove);
            map.remove(toRemove.key);
        }
    }
}
