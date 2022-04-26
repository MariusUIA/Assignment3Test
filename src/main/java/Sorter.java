
public class Sorter implements Comparable<Sorter> {
    public Node Node;
    public int priority;

    public Sorter(Node sortNode, int sortPrio) {
        this.Node = sortNode;
        this.priority = sortPrio;
    }

    @Override
    public int compareTo(Sorter queue) {
        return Integer.compare(this.priority, queue.priority);
    }
}