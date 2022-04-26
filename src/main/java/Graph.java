import java.util.ArrayList;

public class Graph {
    private final ArrayList<Node> Nodes;
    private final boolean hasDirection;
    private final boolean hasCost;

    public Graph(boolean nodeHasCost, boolean nodeHasDirection) {
        this.Nodes = new ArrayList<>();
        this.hasCost = nodeHasCost;
        this.hasDirection = nodeHasDirection;
    }


    public Node addNode(String data) {
        Node newNode = new Node(data);
        this.Nodes.add(newNode);
        return newNode;
    }

    public ArrayList<Node> getNodes() {
        return this.Nodes;
    }

    public void addDestination(Node n1, Node n2, int cost) {
        if (!hasCost)
        {
            cost = 0;
        }
        n1.addDestination(n2, cost);

        if (!this.hasDirection)
        {
            n2.addDestination(n1, cost);
        }
    }
}