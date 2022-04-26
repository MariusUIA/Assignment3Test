
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Objects;
import java.util.PriorityQueue;

public class Dijkstra {
    public static Dictionary[] dijkstra (Graph graph, Node startingNode){
        Dictionary<String, Integer> distances = new Hashtable<>();
        Dictionary<String, Node> previous = new Hashtable<>();
        PriorityQueue<Sorter> queue = new PriorityQueue<>();
        queue.add(new Sorter(startingNode, 0));


        for (Node node: graph.getNodes()) {
            if(node != startingNode)
            {
                distances.put(node.getData(), Integer.MAX_VALUE);
            }
            previous.put(node.getData(), new Node("Null"));
        }
        distances.put(startingNode.getData(), 0);



        while(queue.size() != 0){
            Node current = queue.poll().Node;

            for (Destination dest: current.getDestinations())
            {
                Integer alternate = distances.get(current.getData()) + dest.getCost();
                String adjacentNodeDistance = dest.getEnd().getData();

                if (alternate < distances.get(adjacentNodeDistance))
                {
                    distances.put(adjacentNodeDistance, alternate);
                    previous.put(adjacentNodeDistance, current);
                    queue.add(new Sorter(dest.getEnd(), distances.get(adjacentNodeDistance)));
                }
            }
        }

        return new Dictionary[]{distances, previous};
    }



    public static void cheapestPathBetween(Graph table, Node startingNode, Node targetNode){

        Dictionary[] dijkstraDictionaries = dijkstra(table, startingNode);

        var distances = dijkstraDictionaries[0];
        var previous = dijkstraDictionaries[1];
        Integer distance = (Integer) distances.get(targetNode.getData());

        System.out.println("The cheapest connection for " + startingNode.getData() + " and " + targetNode.getData() + " is " + cheapestPath(targetNode, previous) + " Cost: " + distance);
    }



    private static String cheapestPath(Node targetNode, Dictionary previous){
        ArrayList<Node> path = new ArrayList<>();
        Node node = targetNode;
        
        while(!Objects.equals(node.getData(), "Null")){
            path.add(0, node);
            node = (Node) previous.get(node.getData());
        }
        
        StringBuilder cheapestPath = new StringBuilder();
        
        for (Node pathNode: path){
            cheapestPath.append(pathNode.getData());
            cheapestPath.append(" ");
        }
        
        cheapestPath.setLength(cheapestPath.length() - 1);
        return "[" + cheapestPath + "]";
    }
}