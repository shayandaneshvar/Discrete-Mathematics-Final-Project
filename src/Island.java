import javafx.util.Pair;

import java.util.List;

public class Island {
    private List<Node> nodes;
    private List<Pair<Node,Node>> links;


    public Island(List<Node> nodes, List<Pair<Node, Node>> links) {
        this.nodes = nodes;
        this.links = links;
    }
}