/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node dummy = new Node(0);
        Node node = dummy;

        while (head != null) {
            node.next = new Node(head.val);
            node = node.next;
            node.random = head.random;

            map.put(head, node);

            head = head.next;
        }

        node = dummy.next;
        while (node != null) {
            if (node.random != null) {
                node.random = map.get(node.random);
            }
            node = node.next;
        }

        return dummy.next;
    }
}
