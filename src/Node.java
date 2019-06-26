
public class Node {

    private int number;
    private boolean isVisited;
    private NodeType nodeType;

    public boolean isVisited() {
        return isVisited;
    }

    public NodeType getNodeType() {
        return nodeType;
    }

    public int getNumber() {
        return number;
    }

    public Node(int number, NodeType nodeType) {
        this.number = number;
        this.nodeType = nodeType;
        this.isVisited = false;
    }
}