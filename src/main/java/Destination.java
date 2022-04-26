public class Destination {

    private final Node start;
    private final Node end;
    private final int cost;

    public Destination(Node nodeOrigin, Node nodeEnd, int nodeCost) {
        this.start = nodeOrigin;
        this.end = nodeEnd;
        this.cost = nodeCost;
    }

    public Node getStart() {
        return start;
    }

    public Node getEnd() {
        return end;
    }

    public int getCost() {
        return cost;
    }

}