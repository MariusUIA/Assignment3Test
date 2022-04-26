import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Graph table = new Graph(true, false);
        
        Node a = table.addNode("A");
        Node b = table.addNode("B");
        Node c = table.addNode("C");
        Node d = table.addNode("D");
        Node e = table.addNode("E");
        Node f = table.addNode("F");

        ArrayList<Node> Nodes = new ArrayList<>();
        Nodes.add(a);
        Nodes.add(b);
        Nodes.add(c);
        Nodes.add(d);
        Nodes.add(e);
        Nodes.add(f);

        table.addDestination(a, b, 10);
        table.addDestination(a, c, 5);
        table.addDestination(a, d, 9999);
        table.addDestination(a, e, 3);
        table.addDestination(a, f, 12);

        table.addDestination(b, c, 17);
        table.addDestination(b, d, 9);
        table.addDestination(b, e, 17);
        table.addDestination(b, f, 12);

        table.addDestination(c, d, 35);
        table.addDestination(c, e, 3);
        table.addDestination(c, f, 12);

        table.addDestination(d, e, 9999);
        table.addDestination(d, f, 12);

        table.addDestination(e, f, 12);

        for (Node startingNode : table.getNodes()) {
            System.out.println(" ");
            System.out.println("Node " + startingNode.getData());
            for (Node endNode : Nodes) {
                Dijkstra.cheapestPathBetween(table, startingNode, endNode);
            }
            Nodes.remove(startingNode);
        }
    }
}