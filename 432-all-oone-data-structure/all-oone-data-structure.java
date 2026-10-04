class AllOne {

    class Node {
        int count;
        Set<String> keys;
        Node prev, next;

        Node(int count) {
            this.count = count;
            keys = new HashSet<>();
        }
    }

    private Node head, tail;
    private Map<String, Node> map;

    public AllOne() {
        head = new Node(0);
        tail = new Node(0);

        head.next = tail;
        tail.prev = head;

        map = new HashMap<>();
    }

    public void inc(String key) {
        if (!map.containsKey(key)) {
            Node first = head.next;

            if (first == tail || first.count != 1) {
                Node newNode = new Node(1);
                addAfter(head, newNode);
                first = newNode;
            }

            first.keys.add(key);
            map.put(key, first);

        } else {
            Node curr = map.get(key);
            Node next = curr.next;

            if (next == tail || next.count != curr.count + 1) {
                Node newNode = new Node(curr.count + 1);
                addAfter(curr, newNode);
                next = newNode;
            }

            next.keys.add(key);
            map.put(key, next);

            curr.keys.remove(key);

            if (curr.keys.isEmpty()) {
                remove(curr);
            }
        }
    }

    public void dec(String key) {
        Node curr = map.get(key);

        if (curr.count == 1) {
            curr.keys.remove(key);
            map.remove(key);

            if (curr.keys.isEmpty()) {
                remove(curr);
            }
        } else {
            Node prev = curr.prev;

            if (prev == head || prev.count != curr.count - 1) {
                Node newNode = new Node(curr.count - 1);
                addAfter(prev, newNode);
                prev = newNode;
            }

            prev.keys.add(key);
            map.put(key, prev);

            curr.keys.remove(key);

            if (curr.keys.isEmpty()) {
                remove(curr);
            }
        }
    }

    public String getMaxKey() {
        if (tail.prev == head) {
            return "";
        }

        return tail.prev.keys.iterator().next();
    }

    public String getMinKey() {
        if (head.next == tail) {
            return "";
        }

        return head.next.keys.iterator().next();
    }

    private void addAfter(Node prev, Node node) {
        node.next = prev.next;
        node.prev = prev;

        prev.next.prev = node;
        prev.next = node;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */