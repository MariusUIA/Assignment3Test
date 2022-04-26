import java.util.ArrayList;

public class Node {

    private final String data;
    private final ArrayList<Destination> Destinations;

    public Node(String setData) {
        data = setData;
        Destinations = new ArrayList<>();
    }

    public void addDestination(Node node, int cost) {
        Destinations.add(new Destination(this, node, cost));
    }

    public ArrayList<Destination> getDestinations() {
        return Destinations;
    }

    public String getData() {
        return data;
    }



}