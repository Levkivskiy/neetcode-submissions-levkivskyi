class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        HashMap<Integer, Node> visited = new HashMap<>();
        Deque<Node> queue = new ArrayDeque<>();
        
        visited.put(node.val, new Node(node.val));
        queue.offer(node);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            for (Node neighbor : curr.neighbors) {
                if (!visited.containsKey(neighbor.val)) {
                    visited.put(neighbor.val, new Node(neighbor.val));
                    queue.offer(neighbor);
                }
                visited.get(curr.val).neighbors.add(visited.get(neighbor.val));
            }
        }

        return visited.get(node.val);
    }
}