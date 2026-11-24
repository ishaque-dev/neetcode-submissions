class LRUCache {

     private static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.headNode = new Node(0, 0);
        this.tailNode = new Node(0, 0);
        headNode.next = tailNode;
        tailNode.prev = headNode;
    }

    private final int capacity;
    private final HashMap<Integer, Node> map;
    private final Node headNode;
    private final Node tailNode;

    public int get(int key) {

        if (!map.containsKey(key)) {
            return -1;
        } else {
            Node node = map.get(key);
            remove(node);
            insertAtHead(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            remove(node);
            insertAtHead(node);

        } else {
            if (map.size() == capacity) {
                map.remove(tailNode.prev.key);
                remove(tailNode.prev);

            }
            Node node = new Node(key, value);
            map.put(key, node);
            insertAtHead(node);

        }

    }

    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insertAtHead(Node node) {
        // head node is dummy
        node.next = headNode.next;
        node.next.prev = node;
        headNode.next = node;
        node.prev = headNode;

    }
}
