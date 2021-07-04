package exercise.ex04.ex04;

public class CountingList {

    private Node firstNode;
    private Node lastNode;

    public CountingList() {
        firstNode = lastNode = null;
    }

    public boolean isEmpty() {
        return firstNode == null;
    }

    public void add(String string) {
        Node node = new Node();
        node.setData(string);
        node.setNextNode(null);
        if (firstNode == null) {
            node.setPreviousNode(null);
            firstNode = lastNode = node;
        } else {
            node.setPreviousNode(lastNode);
            lastNode.setNextNode(node);
            lastNode = node;
        }
    }

    public String get(int index) {
        return "";
    }
}
