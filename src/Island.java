import javafx.util.Pair;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Island implements Comparable<Island> {
    private List<Node> nodes;
    private List<Pair<Node, Node>> links;
    private int number;


    public Island(List<Node> nodes, List<Pair<Node, Node>> links, int number) {
        this.nodes = nodes;
        this.links = links;
        this.number = number;
    }

    public Node getAirport() {
        return nodes.stream().filter(x -> x.getNodeType() == NodeType.AIRPORT)
                .collect(Collectors.toList()).get(0);
    }

    public Node getCafe() {
        return nodes.stream().filter(x -> x.getNodeType() == NodeType.CAFE)
                .collect(Collectors.toList()).get(0);
    }

    public int getNumber() {
        return number;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public List<Pair<Node, Node>> getLinks() {
        return links;
    }

    @Override
    public int compareTo(Island o) {
        if(Main.bfs(this,this.getAirport(),this.getCafe())>Main.bfs(o,
            o.getAirport(),o.getCafe())){
            return 1;
        }else if(Main.bfs(this,this.getAirport(),this.getCafe()) < Main.bfs(o,
            o.getAirport(),o.getCafe())) {
            return -1;
        } else {
            return 0;
        }
    }
}