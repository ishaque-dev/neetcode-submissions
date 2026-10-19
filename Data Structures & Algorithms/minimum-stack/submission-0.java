class MinStack {
     private MinStackNode headNode;

    public MinStack() {

    }

    public void push(int val) {
        if (headNode == null) {
            headNode = new MinStackNode(null, val, val);
        } else {
            headNode = new MinStackNode(headNode, val, Math.min(val, headNode.minValue));

        }
    }

    public void pop() {
        headNode = headNode.next;
    }

    public int top() {
        return headNode.value;

    }

    public int getMin() {

        return headNode.minValue;

    }
    
}
class MinStackNode {
    MinStackNode next;
    int value;
    int minValue;

    public MinStackNode() {
    }

    public MinStackNode(MinStackNode next, int value, int minValue) {
        this.next = next;
        this.value = value;
        this.minValue = minValue;
    }
}

